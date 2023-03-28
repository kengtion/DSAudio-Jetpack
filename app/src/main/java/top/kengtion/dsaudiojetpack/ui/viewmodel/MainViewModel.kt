package top.kengtion.dsaudiojetpack.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import top.kengtion.dsaudiojetpack.data.ServerConfig
import top.kengtion.dsaudiojetpack.ui.enums.TabEnum
import top.kengtion.dsaudiojetpack.ui.screen.BaseTabContent
import top.kengtion.dsaudiojetpack.ui.state.Album
import top.kengtion.dsaudiojetpack.ui.state.MainUIState

class MainViewModel : ViewModel() {

    private val viewModels = mutableMapOf(
        TabEnum.Album to AlbumViewModel(),//TODO implement ViewModels
        TabEnum.Artist to AlbumViewModel(),
        TabEnum.Style to AlbumViewModel(),
        TabEnum.PlayList to AlbumViewModel()
    )

    var uiState by mutableStateOf(
        MainUIState(
            TabEnum.Album,
            null,
            ServerConfig("", "", "", null),
            false,
            mutableListOf<ServerConfig>()
        )
    )
        private set

    public fun getScreenViewModel(tab: TabEnum): ViewModel {
        return viewModels[tab]!!
    }

    public fun findAlbumById(id: Long): Album? {
        return null
    }

    public fun onNextClick() {

    }

    public fun onPauseClick() {
        uiState.isPlaying = !uiState.isPlaying
    }

    public fun onDetailClick() {

    }
}