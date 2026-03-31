package org.crabcraft.trackmaster.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import org.crabcraft.trackmaster.data.TrackMasterDatabase
import org.crabcraft.trackmaster.data.repository.TrackMasterRepository
import org.crabcraft.trackmaster.ui.common.theme.TrackMasterTheme
import org.crabcraft.trackmaster.ui.screens.AthleteScreen
import org.crabcraft.trackmaster.ui.screens.AthleteScreenComposable
import org.crabcraft.trackmaster.ui.screens.HomeScreen
import org.crabcraft.trackmaster.ui.screens.HomeScreenComposable
import org.crabcraft.trackmaster.ui.screens.Routes
import org.crabcraft.trackmaster.viewmodel.MainViewModel

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
                        HomeScreenComposable(viewModel, navController)
                    }
                    composable<AthleteScreen> { backStackEntry ->
                        val dest: AthleteScreen = backStackEntry.toRoute()
                        AthleteScreenComposable()
                    }
                }
            }
        }
    }
}
