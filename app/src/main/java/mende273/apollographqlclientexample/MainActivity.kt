package mende273.apollographqlclientexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import mende273.apollographqlclientexample.ui.common.view.HistoriesUI
import mende273.apollographqlclientexample.ui.common.view.RocketsUI
import mende273.apollographqlclientexample.ui.common.view.Tabs
import mende273.apollographqlclientexample.ui.theme.ApolloGraphqlClientExampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel: MainViewModel = hiltViewModel()

            val rocketsUiState by viewModel.rocketsUiState.collectAsStateWithLifecycle()
            val historiesUiState by viewModel.historiesUiState.collectAsStateWithLifecycle()

            val tabTitles = listOf("Rockets", "History")
            var selectedTabIndex by remember { mutableIntStateOf(0) }

            ApolloGraphqlClientExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Tabs(selectedTabIndex = selectedTabIndex,
                            tabTitles = tabTitles,
                            onClick = { selectedTabIndex = it })

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            content = {
                                when (selectedTabIndex) {
                                    0 -> RocketsUI(uiState = rocketsUiState)
                                    1 -> HistoriesUI(uiState = historiesUiState)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
