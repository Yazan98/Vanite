package io.vortex.android.ui.fragment.manager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import io.vortex.android.ui.impl.VortexThrededFragmentManagerImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class VortexThrededFragmentManager : VortexThrededFragmentManagerImpl {

    override suspend fun addFragment(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.supportFragmentManager.also {
                    it.beginTransaction().add(container, fragment).commit()
                }
            }
        }
    }

    override suspend fun replace(context: FragmentActivity?, fragment: Fragment, container: Int) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.supportFragmentManager.also {
                    it.beginTransaction().replace(container, fragment).commit()
                }
            }
        }
    }

    override suspend fun remove(context: FragmentActivity?, fragment: Fragment, container: Int) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.supportFragmentManager.also {
                    it.beginTransaction().remove(fragment).commit()
                }
            }
        }
    }

    override suspend fun addStateLessCommit(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.supportFragmentManager.also {
                    it.beginTransaction().add(container, fragment).commitAllowingStateLoss()
                }
            }
        }
    }

    override suspend fun replaceStateLessCommit(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.supportFragmentManager.also {
                    it.beginTransaction().replace(container, fragment).commitAllowingStateLoss()
                }
            }
        }
    }

    override suspend fun replaceWithFadeAnimation(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.supportFragmentManager.also {
                    it.beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, (android.R.anim.fade_out))
                        .add(container, fragment)
                        .commitAllowingStateLoss()
                }
            }
        }
    }

}
