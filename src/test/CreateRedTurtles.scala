package test

import org.nlogo.core.AgentKind
import org.nlogo.core.Syntax._
import org.nlogo.{agent, api, nvm}

/**
  * Created by Marin on 23/04/16.
  */
object CreateRedTurtles extends api.Command with nvm.CustomAssembled {
    override def getSyntax =
        commandSyntax(right = List(NumberType, CommandBlockType | OptionalType),
            agentClassString = "O---",
            blockAgentClassString = Some("-T--"))

    // only box this once
    private val red = Double.box(15)

    def perform(args: Array[api.Argument], context: api.Context) {
        // the api package have what we need, so we'll often
        // be dropping down to the agent and nvm packages
        val n = args(0).getIntValue
        val world = context.getAgent.world.asInstanceOf[agent.World]
        val eContext = context.asInstanceOf[nvm.ExtensionContext]
        val nvmContext = eContext.nvmContext
        val agents =
            new agent.AgentSetBuilder(AgentKind.Turtle, n)
        for (_ <- 0 until n) {
            val turtle = world.createTurtle(world.turtles)
            turtle.colorDoubleUnchecked(red)
            agents.add(turtle)
            eContext.workspace.joinForeverButtons(turtle)
        }
        // if the optional command block wasn't supplied, then there's not
        // really any point in calling this, but it won't bomb, either
        nvmContext.runExclusiveJob(agents.build(), nvmContext.ip + 1)
        // prim._extern will take care of leaving nvm.Context ip in the right place
    }

    def assemble(a: nvm.AssemblerAssistant) {
        a.block()
        a.done()
    }
}
