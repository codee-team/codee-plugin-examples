@file:DependsOn("me.neon.codee:core:1.0.0")

import kotlinx.coroutines.runBlocking
import me.neon.codee.core.plugins.Plugin
import me.neon.codee.core.plugins.api.registerPlugin
import me.neon.codee.core.plugins.api.registerTheme
import me.neon.codee.core.plugins.api.removeTheme
import me.neon.codee.core.plugins.api.themes
import me.neon.codee.core.plugins.permissions.ForceThemeLanguageSetPermission
import me.neon.codee.core.plugins.permissions.RemoveThemesPermission
import me.neon.codee.core.plugins.theme.LightTheme
import kotlin.script.experimental.dependencies.DependsOn

// defines plugin info
object TestThemePlugin : Plugin {
    override val author: String = "Neon"
    override val dependsOn: List<String> = listOf()
    override val name: String = "TestTheme"
    override val uuid: String = "neon-test-theme-plugin"
    override val version: String = "1.0"
}

// defines new theme. It is better to inherit `LightTheme` or `DarkTheme`
// to avoid runtime errors when new fields will appear in `Theme`.
object MyTheme : LightTheme() {
    override val primary: UInt = 0x000000u
}

// registers a plugin to start working with the application
val registerResult = registerPlugin(TestThemePlugin)

if(registerResult.isSuccess) {
    val context = registerResult.getOrThrow()
    context.registerTheme("My Theme", MyTheme)
    // Also, we can remove some registered theme:
    runBlocking {
        // calls user permission
        if(context.requestPermission(RemoveThemesPermission)) {
            // removes first theme in the list
            context.removeTheme(themes.first().name)
        }
    }
} else error("Error while adding plugin")