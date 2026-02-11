package org.crabcraft.trackmaster.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.ui.common.components.StatusBar
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.viewmodel.MainViewModel

class AthleteActivity : ComponentActivity() {

    private val db by lazy { TrackMasterDatabase.getDatabase(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("id", -1)

        setContent {
            TrackMasterTheme {

                val athlete by db.athleteDao().getAthleteById(id).collectAsState(initial = Athlete(name = "Loading..."))

                Scaffold (
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = { StatusBar( athlete, back = { navigateToHome() }, delete = { /* TODO implement delete */ }) }
                ) { it }
            }

        }
    }

    fun navigateToHome() {
        val intent = Intent(this@AthleteActivity, MainActivity::class.java).apply {
            putExtra("athleteMode", true)
        }
        startActivity(intent)
    }
}