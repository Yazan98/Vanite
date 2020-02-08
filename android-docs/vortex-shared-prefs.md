# Vortex Shared Prefs

Shared Preferences is the Common Part of Android Applications because there are some keys you want to save Them and get the result from any place you can easily attach the Shared Prefs for Your App with Application Class Like This

```text
VortexPrefsConfig.prefs = getSharedPreferences(ApplicationConsts.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
```

You can save keys With Any Value not a Specific Value , The Lazy part of Shared Prefs is always you get the Shared prefs from Context then Save the Value Depends on Type \(String , etc\) Here you can pass any type with one method

```text
VortexPrefs.put("key", value)
```

When you need to get The Data Just call the Get method and Cast the result to your expected result like this example

```text
GlobalScope.launch {
            VortexPrefs.getUserStatus()?.let {
                when (it) {
                    true -> startScreen<MainScreen>(true)
                    false -> startScreen<RegisterScreen>(true)
                }
            }
        }
```

