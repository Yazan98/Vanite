package io.vanite.android.ui.impl

import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface VaniteFragmentManagerImpl {

    fun addFragment(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    fun replace(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    fun remove(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    fun addStateLessCommit(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    fun replaceStateLessCommit(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    fun replaceWithFadeAnimation(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    fun replaceWithCustomAnimation(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int, @AnimRes start: Int, @AnimRes end: Int)

}

interface VaniteThrededFragmentManagerImpl {

   suspend fun addFragment(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    suspend fun replace(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    suspend fun remove(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    suspend fun addStateLessCommit(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    suspend fun replaceStateLessCommit(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    suspend fun replaceWithFadeAnimation(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int)

    suspend fun replaceWithCustomAnimation(context: FragmentActivity?, fragment: Fragment,  @IdRes container: Int, @AnimRes start: Int, @AnimRes end: Int)

}
