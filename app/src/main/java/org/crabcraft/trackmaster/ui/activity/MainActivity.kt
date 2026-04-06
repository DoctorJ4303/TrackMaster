package org.crabcraft.trackmaster.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.Serializable
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.data.repository.TrackMasterRepository
import org.crabcraft.trackmaster.model.Athlete
import org.crabcraft.trackmaster.model.Trackable
import org.crabcraft.trackmaster.model.TrackableType
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.ui.screens.AthleteScreenComposable
import org.crabcraft.trackmaster.ui.screens.HomeScreen
import org.crabcraft.trackmaster.ui.screens.HomeScreenComposable
import org.crabcraft.trackmaster.viewmodel.MainViewModel


@Serializable
data class DetailScreen(val userId: Int, val type: TrackableType)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db by lazy { TrackMasterDatabase.getDatabase(applicationContext) }
        val repository by lazy { TrackMasterRepository(db) }

        // ViewModel Factory
        val viewModel: MainViewModel by viewModels {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel(repository) as T
                }
            }
        }

        setContent {
            TrackMasterTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = HomeScreen) {
                    composable<HomeScreen> {
                        HomeScreenComposable(viewModel) { trackable, type ->
                            navController.navigate(
                                DetailScreen(trackable.uid, type)
                            )
                        }
                    }
                    composable<DetailScreen> {
                        val dest: DetailScreen = it.toRoute()
                        val trackable: StateFlow<Trackable?> = when (dest.type) {
                            TrackableType.ATHLETE -> repository.getAthleteById(dest.userId)
                            TrackableType.WORKOUT -> repository.getWorkoutById(dest.userId)
                        }.stateIn(viewModel.viewModelScope, SharingStarted.WhileSubscribed(5000), null)

                        when (trackable.value) {
                            is Athlete -> AthleteScreenComposable(
                                viewModel,
                                trackable.value as Athlete
                            )
                        }
                    }
                }
            }
        }
    }
}

