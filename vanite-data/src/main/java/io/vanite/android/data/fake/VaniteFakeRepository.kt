package io.vanite.android.data.fake

import android.content.res.Resources
import androidx.annotation.RawRes
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class VaniteFakeRepository<Api> {

    protected val resourceReader: VaniteResourceReader by lazy {
        VaniteResourceReader()
    }

    protected suspend fun getObservableFromJson(res: Resources, @RawRes jsonId: Int):Observable<String> {
        return withContext(Dispatchers.IO) {
            Observable.just(resourceReader.readJsonFromResource(res, jsonId))
        }
    }

    protected suspend fun getFlowableFromJson(res: Resources, @RawRes jsonId: Int):Flowable<String> {
        return withContext(Dispatchers.IO) {
            Flowable.just(resourceReader.readJsonFromResource(res, jsonId))
        }
    }

    protected suspend fun getSingleFromJson(res: Resources, @RawRes jsonId: Int):Single<String> {
        return withContext(Dispatchers.IO) {
            Single.just(resourceReader.readJsonFromResource(res, jsonId))
        }
    }

    abstract fun getService(): Api
}
