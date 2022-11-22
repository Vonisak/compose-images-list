package com.vonisak.composeImageList

import android.app.Application
import com.vonisak.composeImageList.di.component.AppComponent
import com.vonisak.composeImageList.di.component.DaggerAppComponent

class MainApp: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}