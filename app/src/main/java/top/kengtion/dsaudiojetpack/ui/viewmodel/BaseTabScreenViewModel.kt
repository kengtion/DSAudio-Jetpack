package top.kengtion.dsaudiojetpack.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import top.kengtion.dsaudiojetpack.data.ServerConfig
import top.kengtion.dsaudiojetpack.ui.enums.TabEnum
import top.kengtion.dsaudiojetpack.ui.screen.BaseTabContent
import top.kengtion.dsaudiojetpack.ui.state.MainUIState

class BaseTabScreenViewModel<T : BaseTabContent> {
    var uiState by mutableStateOf(
        listOf<T>()
    )
        private set
}