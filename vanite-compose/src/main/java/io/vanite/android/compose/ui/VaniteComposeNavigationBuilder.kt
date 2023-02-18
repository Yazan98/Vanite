package io.vanite.android.compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

abstract class VaniteComposeNavigationBuilder<Navigation: VaniteRouter> {

    fun initGraphConfiguration(
        navHost: NavGraphBuilder,
        onComposableLoaded: (Navigation) -> Unit = {}
    ) {
        getSupportedComposables().apply {
            for ((key, value) in this) {
                navHost.composable(key.getRoute()) {
                    value()
                    onComposableLoaded(key)
                }
            }
        }
    }

    abstract fun getSupportedComposables(): HashMap<Navigation, @Composable () -> Unit>

}
