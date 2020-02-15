package io.vortex.intellij.plugin.actions.screens

import com.intellij.uiDesigner.core.GridLayoutManager
import io.vortex.intellij.plugin.actions.screens.base.BaseScreen
import io.vortex.intellij.plugin.modules.VortexWindowSize
import io.vortex.intellij.plugin.modules.content.VortexAboutPluginContent
import javax.swing.BoxLayout
import javax.swing.JPanel
import javax.swing.JTextField

class AboutPlugin : BaseScreen<VortexAboutPluginContent>() {

    private val screenWidth = 600
    private val screenHeight = 500
    private var screenContainer: JPanel = JPanel()
    private var screenTitleField: JTextField = JTextField(getScreenContent().title)
    private var screenDescription: JTextField = JTextField(getScreenContent().description)
    private var screenListConfigurations: JTextField = JTextField(getScreenContent().supportedGenerators.toString())
    private var screenLinks: JTextField = JTextField(getScreenContent().links)

    init {
        screenContainer.let {
            it.layout = BoxLayout(it, BoxLayout.PAGE_AXIS)
            it.add(screenTitleField)
            it.add(screenDescription)
            it.add(screenListConfigurations)
            it.add(screenLinks)

            this.add(screenContainer)
            showScreen(true)
        }
    }

    override fun getWindowSize(): VortexWindowSize {
        return VortexWindowSize(screenWidth, screenHeight)
    }

    override fun getScreenTitle(): String {
        return getScreenContent().title
    }

    override fun getScreenContent(): VortexAboutPluginContent {
        return VortexAboutPluginContent()
    }

}