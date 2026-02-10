package org.crabcraft.trackmaster

import android.app.Application
import org.crabcraft.trackmaster.data.AppDataContainer
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.data.DatabaseProvider

class TrackMasterApplication : Application() {
    lateinit var container: AppDataContainer
    lateinit var database: TrackMasterDatabase

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        database = DatabaseProvider.provideDatabase(this)
    }

    fun getAppContainer(): AppDataContainer {
        return container
    }
}