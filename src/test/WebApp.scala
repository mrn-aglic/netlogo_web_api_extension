package test

import net.liftweb.util.Props
import org.eclipse.jetty.server.{Server, ServerConnector}
import org.eclipse.jetty.webapp.WebAppContext
import org.nlogo.api
import org.nlogo.api.{Argument, Context, ExtensionException}
import org.nlogo.core.Syntax
import org.nlogo.core.Syntax._

/**
  * Created by Marin on 23/04/16.
  */
object WebApp {

    private var id = 0

    val data = collection.mutable.HashMap[Int, Int]()

    private val server = new Server

    object Setup extends api.Command {

        //override def getSyntax = commandSyntax(right = List(NumberType), agentClassString = "o---", blockAgentClassString = None)

        def perform(args: Array[api.Argument], context: api.Context): Unit = {

            val port = args(0).getIntValue

            val connector = new ServerConnector(server)
            connector.setPort(port)

            server.addConnector(connector)

            val webappDir: String = Option(this.getClass.getClassLoader.getResource("webapp"))
              .map(_.toExternalForm)
              .filter(_.contains("jar:file:")) // this is a hack to distinguish in-jar mode from "expanded"
              .getOrElse("target/webapp")

            val context = new WebAppContext(webappDir, Props.get("jetty.contextPath").openOr("/"))

            server.setHandler(context)
        }

        override def getSyntax: Syntax = commandSyntax(List(NumberType))
    }

    object Start extends api.Command {

        def perform(args: Array[api.Argument], context: api.Context): Unit = {

            server.start()
        }

        override def getSyntax: Syntax = commandSyntax(List())
    }

    object Stop extends api.Command {

        def perform(args: Array[api.Argument], context: api.Context): Unit = {

            server.stop()
        }

        override def getSyntax: Syntax = commandSyntax(List())
    }

    object PutData extends api.Command {
        @scala.throws[ExtensionException](classOf[ExtensionException])
        override def perform(args: Array[Argument], context: Context): Unit = {


            val number = args(0).getIntValue

            data += id -> number

            id = id + 1
        }

        override def getSyntax: Syntax = reporterSyntax(right = List(NumberType), ret = NumberType)
    }

}
