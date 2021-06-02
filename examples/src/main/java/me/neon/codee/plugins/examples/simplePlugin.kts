@file:DependsOn("me.neon.codee:core:1.0.0")
package me.neon.codee.plugins.examples

import me.neon.codee.core.plugins.Plugin
import me.neon.codee.core.plugins.api.registerPlugin
import kotlin.script.experimental.dependencies.DependsOn

// defines plugin info
object SimplePluginTest : Plugin {
    override val author: String = "Neon"
    override val dependsOn: List<String> = listOf()
    override val name: String = "TestTheme"
    override val uuid: String = "neon-test-simple-plugin"
    override val version: String = "1.0"
}

// lets add our plugin to runtime:
// registerPlugin returns Result<PluginContext>
val result = registerPlugin(SimplePluginTest)
// lets check it's success
if(result.isSuccess) {
    // now it's safe to get context
    val context = result.getOrThrow()
    // TODO whatever you want
} else {
    println(result.exceptionOrNull())
}