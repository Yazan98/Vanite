package io.vanite.android.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import io.vanite.android.VaniteAction
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState

abstract class VaniteDialog<State: VaniteState, Action: VaniteAction, Reducer: VaniteViewModel<State, Action>>: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getController().getStateHandler().observe(viewLifecycleOwner, Observer {
            onStateChanged(it)
        })

        getController().getLoadingStateHandler().observe(viewLifecycleOwner, Observer {
            onLoadingChanged(it.getLoadingState())
        })

        initDialog(view)
    }

    protected abstract fun onLoadingChanged(newState: Boolean)
    protected abstract fun onStateChanged(newState: State)
    protected abstract fun initDialog(view: View)
    protected abstract fun getController(): Reducer
    @LayoutRes protected abstract fun getLayoutRes(): Int


}