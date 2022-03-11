package io.vanite.android.ui.fragment.manager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import io.vanite.android.ui.impl.VaniteFragmentManagerImpl

open class VaniteFragmentManager : VaniteFragmentManagerImpl {

    override fun addFragment(context: FragmentActivity?, fragment: Fragment, container: Int) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction().add(container, fragment).commit()
            }
        }
    }

    override fun replace(context: FragmentActivity?, fragment: Fragment, container: Int) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction().replace(container, fragment).commit()
            }
        }
    }

    override fun remove(context: FragmentActivity?, fragment: Fragment, container: Int) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction().remove(fragment).commit()
            }
        }
    }

    override fun addStateLessCommit(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction().add(container, fragment).commitAllowingStateLoss()
            }
        }
    }

    override fun replaceStateLessCommit(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction().replace(container, fragment).commitAllowingStateLoss()
            }
        }
    }

    override fun replaceWithFadeAnimation(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int
    ) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, (android.R.anim.fade_out))
                    .add(container, fragment)
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun replaceWithCustomAnimation(
        context: FragmentActivity?,
        fragment: Fragment,
        container: Int,
        start: Int,
        end: Int
    ) {
        context?.let {
            it.supportFragmentManager.also {
                it.beginTransaction()
                    .setCustomAnimations(start, end)
                    .add(container, fragment)
                    .commitAllowingStateLoss()
            }
        }
    }

}
