package io.vortex.intellij.plugin.actions.screens.base

import io.vortex.intellij.plugin.modules.VortexContent

interface ScreenOperations<C: VortexContent> {

    fun showScreen(isScreenHeaderEnabled: Boolean)

    fun getScreenTitle(): String

    fun getHeaderFrameConfiguration()

    fun getScreenContent(): C

}