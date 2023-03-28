package top.kengtion.dsaudiojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import top.kengtion.dsaudiojetpack.data.ServerConfig
import top.kengtion.dsaudiojetpack.ui.enums.TabEnum
import top.kengtion.dsaudiojetpack.ui.screen.MainScreen
import top.kengtion.dsaudiojetpack.ui.screen.ServerConfigScreen
import top.kengtion.dsaudiojetpack.ui.state.Song
import top.kengtion.dsaudiojetpack.ui.theme.DSAudioJetPackTheme
import top.kengtion.dsaudiojetpack.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DSAudioJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val mainViewModel = mockViewModel()
                    val tabList =
                        listOf(TabEnum.Album, TabEnum.Artist, TabEnum.Style, TabEnum.PlayList)
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(
                                tabContent = tabList,
                                isExpandedScreen = false,
                                onTabChange = {},
                                openDrawer = {},
                                viewModel = mainViewModel,
                                onNavigateToConfig = { navController.navigate("setting/null") }
                            )
                        }
                        composable("setting/{config}") {
                            ServerConfigScreen(
                                config = null,
                                saveConfig = {
                                    navController.navigate("main")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

fun mockViewModel(): MainViewModel {
    val viewModel = MainViewModel()
    viewModel.uiState.serverInfo =
        ServerConfig("server one", "userName", "password", cookieId = null);
    viewModel.uiState.serverList.add(viewModel.uiState.serverInfo)
    viewModel.uiState.serverList.add(
        ServerConfig(
            "server two",
            "userName",
            "password",
            cookieId = null
        )
    )
    viewModel.uiState.curPlaying = Song(
        "",
        "追梦赤子心",
        "GALA",
        123,
        "追梦赤子心",
        5,
        null
    )
    return viewModel
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DSAudioJetPackTheme {
        Greeting("Android")
    }
}