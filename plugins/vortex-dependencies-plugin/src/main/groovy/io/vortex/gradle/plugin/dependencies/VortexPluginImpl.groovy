package io.vortex.gradle.plugin.dependencies

import org.gradle.api.Project

interface VortexPluginImpl {

    void applyUserInterfaceLayer(Project project)

    void applyDataLayer(Project project)

    void applyDomainLayer(Project project)

}
