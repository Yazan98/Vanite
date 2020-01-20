package io.vortex.android.ui

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.vortex.android.VortexAction
import io.vortex.android.reducer.VortexViewModel
import io.vortex.android.state.VortexState
import io.vortex.android.ui.fragment.VortexFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {

    }

    class TestFragment : VortexFragment<TestState , TestAction , TestReducer>() {

        private val controller by lazy {
            ViewModelProvider(this).get(TestReducer::class.java)
        }

        override fun getLayoutRes(): Int {
            return 0
        }

        @Test
        public fun fsf() {
            GlobalScope.launch {
                println("The State is : Request TO Reducer")
                controller.execute(TestAction())
            }
        }

        public override fun initScreen(view: View) {

        }

        override suspend fun onStateChanged(newState: TestState) {
            println("The State is : ${newState}")
        }

        override suspend fun getController(): TestReducer {
            return controller
        }

    }

    class TestReducer : VortexViewModel<TestState, TestAction>() {

        override suspend fun execute(newAction: TestAction) {
            withContext(Dispatchers.IO) {
                println("The State is :At Reduce")
                acceptNewState(TestState.ValidateValueState("Yazan"))
                acceptNewState(TestState.GetInformationState())
                acceptNewState(TestState.OnSuccessState("Ahmad"))
                println("The State is : After All")
            }
        }

        override suspend fun getInitialState(): TestState {
            return TestState.InitState()
        }

    }

    class TestAction : VortexAction
    open class TestState : VortexState {
        class InitState : TestState()
        class ValidateValueState(private val name: String) : TestState() {
            fun getName(): String = name
        }

        class GetInformationState : TestState()

        class OnSuccessState(private val name: String) : TestState() {
            fun getName(): String = name
        }

    }
}
