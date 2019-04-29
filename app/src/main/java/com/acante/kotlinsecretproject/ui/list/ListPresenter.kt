package com.acante.kotlinsecretproject.ui.list

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.acante.kotlinsecretproject.api.RequestInterface
import com.acante.kotlinsecretproject.repo.model.MovieData
import com.acante.kotlinsecretproject.utils.Constance
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ListPresenter() : ListContract.Presenter {

    lateinit var data : List<MovieData>
    lateinit var view:ListContract.View

    override fun loadData() {

        var retrofit = Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        var remoteData = retrofit.create(RequestInterface::class.java)
        remoteData.getData()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view.dataLoaded(it)
                },{
                    Log.d(ListPresenter.TAG,"error message : $it.localizedMessage")
                }
            )
    }

    override fun attache(view: ListContract.View) {
        this.view = view
    }



    companion object{
        val TAG:String = "List Presenter"
    }
}