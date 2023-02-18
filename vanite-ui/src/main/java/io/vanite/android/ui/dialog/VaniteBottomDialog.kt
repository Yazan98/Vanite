package io.vanite.android.ui.dialog

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
import io.vanite.android.VaniteAction
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState

abstract class VaniteBottomDialog<State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>> :
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
     * id Param: R.id.design_bottom_sheet
     */
    fun getFullScreenDialog(savedInstanceState: Bundle?, id: Int): Dialog {
        val dialog: BottomSheetDialog =
            super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = View.inflate(context, getLayoutRes(), null)
        dialog.setContentView(view)
        mainDialog = BottomSheetBehavior.from(view.parent as View)

        dialog.setOnShowListener {
            val d = it as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(id)
            bottomSheet?.let {
                BottomSheetBehavior.from(it).setState(BottomSheetBehavior.STATE_EXPANDED)
            }
        }
        return dialog
    }

    /**
     * Call this in OnStart Method
     * param id: R.id.design_bottom_sheet
     */
    fun onStartFullScreenBehavior(id: Int) {
        val bottomSheet = dialog?.findViewById<View>(id)
        bottomSheet?.layoutParams?.height = ViewGroup.LayoutParams.MATCH_PARENT
    }

}