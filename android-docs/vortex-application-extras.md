# Vortex Application Extras

Application Configuration When Start The Application You Can Submit Some Configuration At Application Class 

The Application Class Can Control The Notifications Settings , Notification Channels , Database Config , Strict Mode , LeakCanary , Image loaders , Device Information , OS info

```text

class DestinyApplication : VortexApplication() {

    private val messageController: VortexMessageDelegation by lazy {
        VortexMessageDelegation()
    }

    override fun onCreate() {
        super.onCreate()
        VortexPrefsConfig.prefs = getSharedPreferences(ApplicationConsts.SHARED_PREFS_NAME, Context.MODE_PRIVATE)

        GlobalScope.launch {
            VortexConfiguration
                .registerStrictMode()
                .registerCompatVector()
                .registerApplicationState(BuildConfig.DEBUG)
                .registerApplicationLogger(LoggerType.TIMBER)
                .registerApplicationClass(this@DestinyApplication)
                .registerImageLoader(ImageLoader.FRESCO)
                .registerLeakCanaryConfiguration()

            configNotifications()

            AppWatcher.config = AppWatcher.config.copy(watchFragmentViews = true)
            LeakCanary.config = LeakCanary.config.copy(onHeapAnalyzedListener = LeakUploader())

            try {
                applicationContext?.let {
                    Realm.init(it)
                    Realm.getInstance(setupRealmConfiguration())
                }
            } catch (ex: Exception) {
                Timber.e("Realm Error : ${ex.message}")
                handleDatabaseError(ex.message)
            }
        }

        startKoin {
            androidLogger(Level.DEBUG)
            modules(appModules)
        }
    }

    private val appModules: Module = module {
        viewModel<AuthViewModel> { AuthViewModel() }
        viewModel<RecipeCommentsViewModel> { RecipeCommentsViewModel() }
    }

    private suspend fun configNotifications() {
        withContext(Dispatchers.IO) {
            applicationContext?.let {
                //TODO(Yazan): "Change Values Later"
                notificationsController.createMultiNotificationChannels(
                    arrayListOf(
                        VortexNotificationDetails("Offers", "Offers Channel", "fdsgd15d3fg1"),
                        VortexNotificationDetails("Offers", "Offers Channel", "fdsgd15d3fg1"),
                        VortexNotificationDetails("Offers", "Offers Channel", "fdsgd15d3fg1")
                    ),
                    it
                )
            }
        }
    }

    private suspend fun setupRealmConfiguration() = suspendCoroutine<RealmConfiguration> {
        try {
            val config = RealmConfiguration.Builder()
                .name(ApplicationConsts.DATABASE_NAME)
                .schemaVersion(ApplicationConsts.DATABASE_VERSION)
                .inMemory()
                .build()
            it.resume(config)
        } catch (ex: Exception) {
            it.resumeWithException(ex)
        }
    }

    private suspend fun handleDatabaseError(message: String?) {
        withContext(Dispatchers.Main) {
            message?.let { result ->
                applicationContext?.let {
                    messageController.showLongMessage(result, it)
                }
            }
        }
    }

}
```

