package org.crabcraft.trackmaster.data

import android.content.Context
import org.crabcraft.trackmaster.data.repository.TrackMasterRepository

interface AppContainer {
    val athleteRepository: TrackMasterRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val athleteRepository: TrackMasterRepository by lazy {
        TrackMasterRepository(TrackMasterDatabase.getDatabase(context))
    }
}