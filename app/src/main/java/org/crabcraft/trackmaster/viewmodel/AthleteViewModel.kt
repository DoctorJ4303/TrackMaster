package org.crabcraft.trackmaster.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.emhs.trackmaster.db.Athlete

class AthleteViewModel :ViewModel() {
    private val _athletes = MutableLiveData<List<Athlete>>()
    val athletes: LiveData<List<Athlete>> = _athletes

    fun addAthlete(name: String, description: String, records: MutableList<Record>) {
        val currentList = _athletes.value ?: emptyList()

        val athlete = Athlete(name, description, records)
        _athletes.value = currentList + athlete
    }
}