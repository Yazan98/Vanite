![logo_2](https://user-images.githubusercontent.com/29167110/71951958-f6738f00-31ed-11ea-92bd-278e4e9c8ddb.png)

![](https://img.shields.io/badge/License-Apache%202.0-blue)
![](https://img.shields.io/badge/Project%20Status-Beta%20Version-yellow)
![](https://img.shields.io/badge/Android%20Status-AndroidX-green)
![](https://img.shields.io/badge/Download-1.0.13-orange)
![](https://img.shields.io/badge/Language-Kotlin-orange)

# Library Overview

This Library is The Android Version And it's Built On 
1. Clean Architecture
2. Multi Modular Applications
3. RxJAva With Retrofut
4. Multi Threading With Kotlin Coroutines
5. Component Architecture (ViewModel)

The Library Should Implement At 3 Layers

1. UserInterface Layer : This Layer Should Include UI Things Like Activity , Fragments , Notifications , Vustom Views , UI Utils , etc

2. Data Layer : This Layer Should Include Api's Requests , Database Implementation , Shared Prefs , Models

3. Domain Layer : This Layer Should Include All ViewModels And State About Each ViewModel and this layer is the Logic Layer 

# Implementation Notes
Built On Kotlin coroutines every method at this library is suspend function it means every process at the library execute on the background thread you can change the thread at your view to ui thread [Read More](https://github.com/Kotlin/kotlinx.coroutines)

# Install

```
    repositories {
        maven {
            url  "https://dl.bintray.com/yt98/Vortex"
        }
    }
```

```
    dependencies {
        implementation "io.vortex:vortex-ui-ktx:${final_version}" STABLE
        implementation "io.vortex:vortex-permissions-ktx:${final_version}" NOT-STABLE
        implementation "io.vortex:vortex-core-ktx:${final_version}" STABLE
        implementation "io.vortex:vortex-local-ktx:${final_version}" NOT-STABLE
        implementation "io.vortex:vortex-data-ktx:${final_version}" STABLE
        implementation "io.vortex:vortex-utils-ktx:${final_version}" STABLE
        implementation "io.vortex:vortex-prefs-ktx:${final_version}" STABLE
        implementation "io.vortex:vortex-firebase-ktx:${final_version}" NOT-COMPLETED
    }
```

# Library Example 
1. First We Should Configure The Application From The Application Class To Set The Main Configuration About Hhe Application .. Application Class Allows you To Configure Notification Clannels , Firebase , SharedPrefs , etc...

Code Example :
```
class CulttripApplication : VortexApplication(), Thread.UncaughtExceptionHandler {

    // show Toasts , Snackbar , Dialogs
    private val messageDelegation: VortexMessageDelegation by lazy {
        VortexMessageDelegation()
    }

    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch {
            // Beta Declaration For SharedPrefs
            VortexPrefsConfig.prefs = getSharedPreferences(ApplicationKeys.SHARED_PREFS_NAME , Context.MODE_PRIVATE)
            
            VortexConfiguration
                .registerApplicationClass(this@CulttripApplication)
                .registerExceptionHandler(this@CulttripApplication)
                // This Line Control Timber , Strict Mode , LeakCanary On (Debug , Release)
                .registerApplicationState(BuildConfig.DEBUG)
                .registerVortexPermissionsSettings()
                // Initialization The Image Loaders (Fresco , Picasso)
                .registerImageLoader(ImageLoader.FRESCO)
                .registerCompatVector()
                .registerStrictMode()
        }

        // Start Koin Dependencies Injection
        startKoin {
            androidContext(this@CulttripApplication)
            modules(applicationModules)
        }

        // Start Create Notification Channels
        GlobalScope.launch {
            registerApplicationChannels()
        }
    }

    private suspend fun registerApplicationChannels() {
        withContext(Dispatchers.IO) {
            notificationsController.createMultiNotificationChannels(
                arrayListOf(
                    VortexNotificationDetails(
                        getString(R.string.offers_notification_channel),
                        getString(R.string.offers_notification_channel_des),
                        getString(R.string.offers_notification_channel_id)
                    )
                ),
                this@CulttripApplication.applicationContext
            )
        }
    }

    private val applicationModules = module {
        viewModel { RegisterViewModel() }
    }

    override fun uncaughtException(p0: Thread, p1: Throwable) {
        GlobalScope.launch {
            p1.message?.let {
                messageDelegation.showAlertDialog(
                    this@CulttripApplication.applicationContext,
                    getString(R.string.un_expected_error),
                    it
                )
            }
        }
    }

}
```

#### 2.1 : Action
Each Step At View Can just send actions from View To ViewModel to Single method at ViewModel (reduce(Action)) and We Can Create Action Like This

```
open class AuthAction: VortexAction {
    // You can Send this action from view to viewModel When User Click Login Button
    class RequestLoginState(private val requestBody: LoginBody): AuthAction() {
        fun getLoginDetails() = requestBody
    }
    // Call this action when user click on Register Button
    class RequestRegisterState(private val body: RegisterBody): AuthAction() {
        fun getDetails() = body
    }

}
```

   #### 2.2 : State
   Each Action Should Return An State To Tell View About The ViewModel State And what is the last state saved at ViewModel And we can declare The State Like This
    
```
open class AuthState : VortexState {

    class EmptyState: AuthState()
    class LoginSuccessState(private val response: AuthResponse): AuthState() {
        fun getResponse() = response
    }

    class LoginError(private val message: String): AuthState() {
        fun getErrorMessage() = message
    }

}
```

#### EmptyState
First State is Empty State it means the Initialization State at the screen is EmptyState Without any data , 

#### LoginSuccessState
This State Return To View The User Information From Login , Register Api When Request Completed and View Start to execute operations about the user info

#### LoginError
This State Should Notify The View is the viewModel has any error should show the error at view

#### Note
Each State At Application Should Implement VortexState
Each Action At Application Should Implement VortexAction

#### The View Model Implementation
1. You Should Tell The ViewModel That This is the States , Actions for You
```
open class RegisterViewModel @Inject constructor() : VortexViewModel<AuthState, AuthAction>() {
    ...
}
```

2. Each ViewModel has the Only reduce() method to handle Actions
```
override suspend fun reduce(newAction: AuthAction) {
    when (newAction) {
        is AuthAction.RequestLoginState -> loginAccount(newAction)
        is AuthAction.RequestRegisterState -> registerAccount(newAction.getDetails())
    }
}
```

3. You Can Decalre The Initial State Like This
```
 override suspend fun getInitialState(): AuthState {
    return AuthState.EmptyState()
}
```

4. each viewModel has Loading State , Data State it means you can control the loading at view using Loading State and the data state you can submit it using acceptNewState(...)

5. At This Example You Can Send Request From The Repository And Handle The Success / Error To View

```
private suspend fun loginAccount(login: AuthAction.RequestLoginState) {
        withContext(Dispatchers.IO) {
            when {
                login.getLoginDetails().email.isEmpty() -> handleError("Invalid Email")
                login.getLoginDetails().password.isEmpty() -> handleError("Invalid Password")
                else -> {
                    acceptLoadingState(true)
                    addRxRequest(loginRepository.login(login.getLoginDetails()).subscribe({
                        GlobalScope.launch {
                            handleSuccessState(AuthState.LoginSuccessState(it.data))
                        }
                    }, {
                        GlobalScope.launch {
                            it.message?.let {
                                handleErrorState(ConnectionException(it))
                            }
                        }
                    }))
                }
            }
        }
    }
```

6. At Least The ViewModel should be like this 
```
open class RegisterViewModel @Inject constructor() : VortexViewModel<AuthState, AuthAction>() {

    private val loginRepository: AuthRepository by lazy {
        AuthRepository()
    }

    override suspend fun getInitialState(): AuthState {
        return AuthState.EmptyState()
    }

    override suspend fun reduce(newAction: AuthAction) {
        when (newAction) {
            is AuthAction.RequestLoginState -> loginAccount(newAction)
            is AuthAction.RequestRegisterState -> registerAccount(newAction.getDetails())
        }
    }

    private suspend fun loginAccount(login: AuthAction.RequestLoginState) {
        withContext(Dispatchers.IO) {
            when {
                login.getLoginDetails().email.isEmpty() -> handleError("Invalid Email")
                login.getLoginDetails().password.isEmpty() -> handleError("Invalid Password")
                else -> {
                    acceptLoadingState(true)
                    addRxRequest(loginRepository.login(login.getLoginDetails()).subscribe({
                        GlobalScope.launch {
                            handleSuccessState(AuthState.LoginSuccessState(it.data))
                        }
                    }, {
                        GlobalScope.launch {
                            it.message?.let {
                                handleErrorState(ConnectionException(it))
                            }
                        }
                    }))
                }
            }
        }
    }
    
    private suspend fun handleError(message: String) {
        withContext(Dispatchers.IO) {
            acceptNewState(AuthState.LoginError(message))
        }
    }
}
```

7. We Should Now Decalre View at this Example We Can Use Declare The Fragment With ViewModel like this

```
lass LoginFragment @Inject constructor() : VortexFragment<AuthState, AuthAction,RegisterViewModel>() {
    private val loginViewModel: RegisterViewModel by viewModel(RegisterViewModel::class)

    override fun getLayoutRes(): Int {
        return R.layout.fragment_login
    }

    override suspend fun getController(): RegisterViewModel {
        return loginViewModel
    }
    ...
}
```

8. The Library Majic Here
```
override suspend fun onStateChanged(newState: AuthState) {
        withContext(Dispatchers.IO) {
            when (newState) {
                is AuthState.LoginError -> showMessage(newState.getErrorMessage())
                is AuthState.LoginSuccessState -> showAccountInfo(newState.getResponse())
            }
        }
    }
```

This Method Should Navigate Any State To The Right Direction

## Example Overview
This is just an simple example about the beta version and you can find the full code at this link
[Example Link](https://github.com/Yazan98/Vortex-Example)

## Note
Better Documentation Soon xD

# Contributing


To contribute to Vortex , follow these steps:

1. Fork this repository.
2. Create a branch: git checkout -b <branch_name>.
3. Make your changes and commit them: `git commit -m '<commit_message>'
4. Push to the original branch: git push origin <project_name>/<location>
5. Create the pull request.

# Developers

(Yazan Tarifi) - Author -> yazantarifi1@hotmail.com

# License

Copyright (C) 2019 Vortex is An Open Source Library  (Licensed under the Apache License, Version 2.0)
