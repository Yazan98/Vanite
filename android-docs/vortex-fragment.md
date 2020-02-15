# Vortex Fragment

The Fragments is The Important Part For User Interface layer because everything is Fragments and will Show The User \(ViewModel Result\) 

The Fragment Types

1. Local Fragment
2. Network Fragment
3. Lce Fragment \(Loading Content Error\)

## Local Fragment Example

```text
class OnBoardingFragment @Inject constructor() : VortexBaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_on_boarding
    }

    override fun initScreen(view: View) {
        // the ui operations here
    }

}
```

## Network Fragment Example

This Type of Fragments Require Some Configuration Like The Fragment State , Actions

Each Fragment has own Actions , Fragment it means The Fragment can't execute other Fragment Actions 

This Fragment has The Loading State Implemented

```text
class RegisterFragment @Inject constructor() :
VortexLceFragment<AuthState, AuthAction, AuthViewModel>() {
// Fragment Code
}
```

This Type not Include Loading State

```text
class RegisterFragment @Inject constructor() :
VortexFragment<AuthState, AuthAction, AuthViewModel>() {
// Fragment Code
}
```

Each Fragment has 2 Methods 

1. GetLayoutRes
2. initScreen

```text
override fun getLayoutRes(): Int {
    return R.layout.fragment_register
}

override fun initScreen(view: View) {
    // screen code
}
```

At Fragment You Can Just Submit Actions From Execute Action To ViewModel and This is The Register Form To Submit User Info to ViewModel 

```text
getController().execute(
   AuthAction.RegisterAction(
        RegisterBody(
           NameField?.text.toString().trim(),
           PasswordField?.text.toString().trim(),
           EmailField?.text.toString().trim(),
           ApplicationConsts.IMAGE,
           PhoneNumberField?.text.toString().trim(),
           RegisterLocation(name = LocationField?.text.toString().trim())
       )
   )
)
```

At Any Fragment There are a method called onStateChanged and this method notify when The ViewModel Handle a New State to View , The method check the InComing State and handle the data to View

```text
override suspend fun onStateChanged(newState: AuthState) {
        withContext(Dispatchers.IO) {
            when (newState) {
                is AuthState.AuthSuccessResponse -> successResponse(newState.get())
                is AuthState.ErrorResponse -> showMessage(newState.get())
            }
        }
    }
```

This is the Success Response At View When The onStateChanged Call The Right Result Like This

```text
private suspend fun successResponse(response: AuthResponse) {
        withContext(Dispatchers.Main) {
            activity?.let {
                MaterialAlertDialogBuilder(it)
                    .setTitle(getString(R.string.register_completed))
                    .setMessage("Hi Mr, ${response.user.username} Your Account Created Successfully , Welcome To Culttrip Client")
                    .setPositiveButton("Ok") { dialog, which ->
                        viewLifecycleOwner.lifecycleScope.launch {
                            saveKeys(response)
                            FirebaseMessaging.getInstance().subscribeToTopic("app_offers")
                            startScreen<MainScreen>(true)
                        }
                        dialog.dismiss()
                    }
                    .show();
            }
        }
    }
```

Also You Can Save Shared Preferences at Any View Like This

 

```text
private suspend fun saveKeys(response: AuthResponse) {
        withContext(Dispatchers.IO) {
            VortexPrefs.saveUserStatus(true)
            VortexPrefs.saveAccessToken(response.token)
            VortexPrefs.put(ApplicationConsts.ID, response.user.id)
        }
    }
```

With LCE \(Loading , Content , Error\) View There are a method to Handle The Loading State to Show , Hide The Screen Content Depends on The State Like This

```text
override suspend fun getLoadingState(newState: Boolean) {
        withContext(Dispatchers.IO) {
            onLoadingChanged(newState)
        }
    }

    override suspend fun onLoadingChanged(status: Boolean) {
        withContext(Dispatchers.Main) {
            when (status) {
                true -> {
                    RegisterLoading?.showView()
                    RegisterContainer?.goneView()
                }

                false -> {
                    RegisterLoading?.goneView()
                    RegisterContainer?.showView()
                }
            }
        }
    }
```

Finally You can Show Messages , And The Common Cases for This Action is Error Response you need to Show user The Error Message

```text
private suspend fun showMessage(message: String) {
        withContext(Dispatchers.Main) {
            activity?.let {
                messageController.showSnackbarWithColor(it, message, R.color.colorPrimary)
            }
        }
}
```

