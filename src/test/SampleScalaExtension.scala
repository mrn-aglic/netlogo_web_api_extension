package test

import org.nlogo.api

/**
  * Created by Marin on 23/04/16.
  */
class SampleScalaExtension extends api.DefaultClassManager {
    def load(manager: api.PrimitiveManager) {

        manager.addPrimitive("setup", WebApp.Setup)
        manager.addPrimitive("start", WebApp.Start)
        manager.addPrimitive("stop", WebApp.Stop)
        manager.addPrimitive("putData", WebApp.PutData)
        manager.addPrimitive("first-n-integers", IntegerList)
        manager.addPrimitive("my-list", MyList)
        manager.addPrimitive("create-red-turtles", CreateRedTurtles)
    }
}
