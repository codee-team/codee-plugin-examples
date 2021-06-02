@file:DependsOn("me.neon.codee:core:1.0.0")

import me.neon.codee.core.plugins.Plugin
import me.neon.codee.core.plugins.api.registerPlugin
import me.neon.codee.core.plugins.api.registerStrings
import me.neon.codee.core.plugins.language.EnglishStrings
import kotlin.script.experimental.dependencies.DependsOn

// defines plugin info
object SimplePluginTest : Plugin {
    override val author: String = "Neon"
    override val dependsOn: List<String> = listOf()
    override val name: String = "TestLanguagePlugin"
    override val uuid: String = "neon-test-lang-plugin"
    override val version: String = "1.0"
}

// defines our strings
object MyStrings : EnglishStrings() {
    override val titleCreate: String = "Make"
    override val messageNoProjects: String = "No projects.. meh"
}

// lets add our plugin to runtime:
// registerPlugin returns Result<PluginContext>
val result = registerPlugin(SimplePluginTest)
// lets check it's success
if(result.isSuccess) {
    // now it's safe to get context
    val context = result.getOrThrow()
    // lets register our translation:
    if(context.registerStrings("en", MyStrings))
        println("Successfully added!")
    else println("Some internal error happened")
} else {
    println(result.exceptionOrNull())
}