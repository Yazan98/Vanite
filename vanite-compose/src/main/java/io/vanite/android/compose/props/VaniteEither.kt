package io.vanite.android.compose.props

data class VaniteEither<State, SecondState>(
    val state: State?,
    val secondState: SecondState?
) {

    fun onStateTriggered(onTriggered: (State) -> Unit) {
        if (this.state != null) {
            onTriggered(this.state)
        }
    }

    fun onSecondStateTriggered(onTriggered: (SecondState) -> Unit) {
        if (this.secondState != null) {
            onTriggered(this.secondState)
        }
    }

}