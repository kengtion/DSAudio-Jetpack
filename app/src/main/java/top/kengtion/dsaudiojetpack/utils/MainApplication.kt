package top.kengtion.dsaudiojetpack.utils

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppContextHelper.application = this
    }
}