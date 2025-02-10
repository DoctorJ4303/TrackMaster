package org.crabcraft.trackmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import org.crabcraft.trackmaster.ui.theme.TrackMasterTheme
import org.crabcraft.trackmaster.view.AthleteListActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val athleteList = findViewById<Button>(R.id.main_athlete_list)

        athleteList.setOnClickListener() {
            val intent = Intent(this, AthleteListActivity::class.java)
            startActivity(intent)
        }
    }
}