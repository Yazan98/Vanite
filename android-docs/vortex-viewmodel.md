# Vortex ViewModel

The Logic Layer has 3 main parts

## The Main Parts in Logic Layer

1. State
2. Action
3. ViewModel

The Action Example , Each ViewModel Can Submit Action and This Action depends on the Base Action Of Current ViewModel , at the following example the Auth Action can Submit 2 type of Actions \(Login Action , Register Action\)

```text
open class AuthAction : VortexAction {

    class LoginAction(private val email: String, private val password: String): AuthAction() {
        fun getEmail() = email
        fun getPassword() = password
    }

    class RegisterAction(private val body: RegisterBody): AuthAction() {
        fun get() = body
    }

}
```

Now The ViewModel also has State and here you can declare the ViewModels Stats at this example The ViewModel can Submit an \(Empty , Success , Error\) State , The empty State is Required at Auth Views because When the user open the view there are a default state to execute  the View depends on the Default State , also when api return the response you can submit Success State or Error State

```text
open class AuthState : VortexState {

    class EmptyState: AuthState()
    class AuthSuccessResponse(private val response: AuthResponse): AuthState() {
        fun get() = response
    }

    class ErrorResponse(private val message: String): AuthState() {
        fun get() = message
    }


}
```

Now we can Declare The ViewModel Configuration With The State , Action

```text
class AuthViewModel @Inject constructor() : VortexViewModel<AuthState, AuthAction>() {
}
```

At ViewModel there are the Execute Method to execute the incoming actions and call the right method depends on the action , here at this example we can check the action if LoginAction you can send the Login Request , RegisterAction call the Register Api Request

```text
override suspend fun execute(newAction: AuthAction) {
        withContext(Dispatchers.IO) {
            if (getStateHandler().value == null || getStateHandler().value is AuthState.ErrorResponse) {
                when (newAction) {
                    is AuthAction.LoginAction -> loginAccount(
                        newAction.getEmail(),
                        newAction.getPassword()
                    )
                    is AuthAction.RegisterAction -> registerAccount(newAction.get())
                }
            }
        }
    }

```

The next method Example about The registerAccount Request using RxJava With Suspend Function , This is the RxJava Request with 2 Consumers To Handle The Success Response , Error Response, When Execute any Request at ViewModel you can Call \(acceptLoadingState\) and this will notify the view with the new Loading State , also when the Response back to viewModel you can submit the new State with \(acceptNewState\) and this method will notify the View With \(onStateChanged\) ، when execute The RxJava Request you should unSubscribe all Disposables and Vortex will destroy them automatically just submit the Request at \(AddRxRequest\) and Submit The Observable , etc and Vortex Should Destroy Them 

```text
private suspend fun registerAccount(body: RegisterBody) {
        withContext(Dispatchers.IO) {
            acceptLoadingState(true)
            addRxRequest(authRepository.registerAccount(body).subscribe({
                it?.let {
                    viewModelScope.launch(Dispatchers.IO) {
                        handleStateWithLoading(AuthState.AuthSuccessResponse(it.data))
                    }
                }
            }, {
                it?.let {
                    it.message?.let {
                        viewModelScope.launch(Dispatchers.IO) {
                            acceptNewState(AuthState.ErrorResponse(it))
                            acceptLoadingState(false)
                        }
                    }
                }
            }))
        }
    }

```

Finally This is the initial State of the viewModel

```text
override suspend fun getInitialState(): AuthState {
    return AuthState.EmptyState()
}
```

