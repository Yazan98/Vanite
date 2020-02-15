package io.vortex.intellij.plugin.actions.screens.base

import io.vortex.intellij.plugin.modules.VortexContent
import io.vortex.intellij.plugin.modules.VortexWindowSize
import javax.swing.JFrame

abstract class BaseScreen<C : VortexContent> : JFrame(), ScreenOperations<C> {

    override fun showScreen(isScreenHeaderEnabled: Boolean) {
        setSize(getWindowSize().width, getWindowSize().height)
        if (isScreenHeaderEnabled) {
            getHeaderFrameConfiguration()
        }
        isVisible = true
    }

    override fun getHeaderFrameConfiguration() {
        defaultCloseOperation = JFrame.HIDE_ON_CLOSE
        title = getScreenTitle()
        setLocationRelativeTo(null)
    }

    abstract fun getWindowSize(): VortexWindowSize
}
