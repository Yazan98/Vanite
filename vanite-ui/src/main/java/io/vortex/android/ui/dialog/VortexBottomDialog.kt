package io.vortex.android.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.vortex.android.VortexAction
import io.vortex.android.base.VortexViewModel
import io.vortex.android.state.VortexState
import io.vortex.android.ui.R

abstract class VortexBottomDialog<State : VortexState, Action : VortexAction, Reducer : VortexViewModel<State, Action>> :
    BottomSheetDialogFragment() {

    private lateinit var mainDialog: BottomSheetBehavior<View>
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

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    /**
     * Call this method on @{override fun onCreateDialog(savedInstanceState: Bundle?): Dialog}
     */
    fun getFullScreenDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: BottomSheetDialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = View.inflate(context, getLayoutRes(), null)
        dialog.setContentView(view)
        mainDialog = BottomSheetBehavior.from(view.parent as View)

        dialog.setOnShowListener {
            val d = it as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet)
            bottomSheet?.let {
                BottomSheetBehavior.from(it).setState(BottomSheetBehavior.STATE_EXPANDED)
            }
        }
        return dialog
    }

    /**
     * Call this in OnStart Method
     */
    fun onStartFullScreenBehavior() {
        val bottomSheet = dialog?.findViewById<View>(R.id.design_bottom_sheet)
        bottomSheet?.layoutParams?.height = ViewGroup.LayoutParams.MATCH_PARENT
    }

}