package io.vanite.gradle.plugin.dependencies

import org.gradle.api.Project

interface VortexPluginImpl {

    void applyUserInterfaceLayer(Project project, boolean isViewBindingEnabled)

    void applyDataLayer(Project project)

    void applyDomainLayer(Project project)

}