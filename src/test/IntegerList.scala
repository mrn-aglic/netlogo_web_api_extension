package test

import org.nlogo.api
import org.nlogo.api.ScalaConversions._
import org.nlogo.core.Syntax._

/**
  * Created by Marin on 23/04/16.
  */
object IntegerList extends api.Reporter {
    override def getSyntax =
        reporterSyntax(right = List(NumberType), ret = ListType)

    def report(args: Array[api.Argument], context: api.Context): AnyRef = {
        val n = try args(0).getIntValue
        catch {
            case e: api.LogoException =>
                throw new api.ExtensionException(e.getMessage)
        }
        if (n < 0)
            throw new api.ExtensionException("input must be positive")
        (0 until n).toLogoList
    }
}
