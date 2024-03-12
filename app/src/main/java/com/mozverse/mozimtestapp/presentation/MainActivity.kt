package com.mozverse.mozimtestapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mozverse.mozim.Mozim
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.presentation.features.session.add.AddSessionScreen
import com.mozverse.mozimtestapp.presentation.features.session.configurator.ActionBuilderScreen
import com.mozverse.mozimtestapp.presentation.features.session.list.SessionsScreen
import com.mozverse.mozimtestapp.presentation.service.ForegroundedSessionService
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var mozim: Mozim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInteractionListener()
        setSampleLogger()

        setContent {
            MozimTestAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "sessions") {
                    composable("sessions") {
                        //todo: extract starting service to a different navigator and call it through viewmodel
                        SessionsScreen(
                            navController = navController,
                            onStartSessionForegrounded = { startSessionForegrounded(it) }
                        )
                    }
                    composable("new_interaction") {
                        AddSessionScreen(navController = navController)
                    }
                    composable("action_builder") {
                        ActionBuilderScreen(navController = navController)
                    }
                }

            }
        }
    }

    private fun setInteractionListener() {
        mozim.setInteractionListener(SampleIMInteractionListener())
    }

    private fun startSessionForegrounded(session: Session) {
        lifecycleScope.async {
            ForegroundedSessionService.startForegroundedSession(this@MainActivity, session)
        }
    }

    private fun setSampleLogger() {
        // library feature not yet enabled
        mozim.setLogger(SampleIMLogger())
    }

}