package io.vortex.intellij.plugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import io.vortex.intellij.plugin.actions.screens.AboutPlugin

class AboutPluginAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        AboutPlugin()
    }

}
