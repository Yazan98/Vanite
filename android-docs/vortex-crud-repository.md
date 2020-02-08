# Vortex Crud Repository

Crud repository is \(Create , Read/Retrieve , Update , Delete\) and this Type of Repositories is Generated from The Vortex - ICG with Default Crud Requests 

Now Let's Move to The Current Repository And at this example we will build the Auth Repository , This Api Interface is just a Simple and here we can declare the Register Request

```text
interface AuthApi {

    @POST("accounts/register")
    fun registerAccount(@Body body: RegisterBody): Observable<DestinyResponse<AuthResponse>>

}
```

Now We Should Declare the Base Repository and This Way we can Submit Multi base Url for Micro Services With Multi Base Url

```text

abstract class DestinyRepository<Api> : VortexRepository<Api>() {

    // Retrofit Configuration
    private val provider: RepositoryComponent by lazy {
        RepositoryComponentImpl()
    }

    init {
        this.serviceProvider = provider.getRetrofitConfiguration()
    }


    override fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun getRequestDetails(): VortexRequestDetailsProvider {
        // This is for Vortex Retrofit Interceptor and no need to implement the Interceptor at this Application
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
```

Now We Can Declare The Auth Api Requests With The Auth Repository ، The Repository is just called from The ViewModel to Execute The Requests at AuthApi interface

```text
class AuthRepository @Inject constructor() : DestinyRepository<AuthApi>() {

    override suspend fun getService(): AuthApi {
        return serviceProvider.create(AuthApi::class.java)
    }

    suspend fun registerAccount(body: RegisterBody): Observable<DestinyResponse<AuthResponse>> {
        return getService().registerAccount(body)
    }

}
```



