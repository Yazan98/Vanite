package io.vanite.android.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 9:04 PM
 */

interface VaniteThreadProvider {

    fun getMainThread(): Scheduler = AndroidSchedulers.mainThread()

    fun getBackgroundThread(): Scheduler = Schedulers.newThread()

}
