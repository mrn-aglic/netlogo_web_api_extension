package sampleapi

import net.liftweb.http.LiftRules
import net.liftweb.http.rest.RestHelper
import net.liftweb.json.Extraction._
import net.liftweb.json.JsonAST.JValue
import net.liftweb.json.{JValue => _, _}
import net.liftweb.json.JsonDSL._
import test.WebApp.data

/**
  * Created by Marin on 17/03/16.
  */

object RestAPI extends RestHelper {

    implicit override val formats = DefaultFormats + MapSerializer

    def getTest: Option[JValue] = Some("test" -> decompose(data.toMap) )

    def init(): Unit = {

        LiftRules.statelessDispatch.append(RestAPI)
    }

    serve {

        case "api" :: "test" :: Nil JsonGet req => getTest
    }
}


object MapSerializer extends Serializer[Map[Any, Any]] {
    def serialize(implicit format: Formats): PartialFunction[Any, JValue] = {
        case m: Map[_, _] => JObject(m.map({
            case (k, v) => JField(
                k match {
                    case ks: String => ks
                    case ks: Symbol => ks.name
                    case ks: Any => ks.toString
                },
                Extraction.decompose(v)
            )
        }).toList)
    }

    def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Map[Any, Any]] = {
        sys.error("Not interested.")
    }
}
