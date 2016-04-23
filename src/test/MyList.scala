package test

import org.nlogo.api
import org.nlogo.api.ScalaConversions._
import org.nlogo.core.Syntax._
/**
  * Created by Marin on 23/04/16.
  */
object MyList extends api.Reporter {
    override def getSyntax =
        reporterSyntax(right = List(WildcardType | RepeatableType), ret = ListType, defaultOption = Some(3))

    def report(args: Array[api.Argument], context: api.Context) =
        args.map(_.get).toLogoList
}
