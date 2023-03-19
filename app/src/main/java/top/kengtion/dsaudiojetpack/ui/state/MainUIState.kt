package top.kengtion.dsaudiojetpack.ui.state

import top.kengtion.dsaudiojetpack.data.ServerConfig
import top.kengtion.dsaudiojetpack.ui.enums.TabEnum

data class MainUIState(
    val curTab: TabEnum,
    val curPlaying: Song?,
    var serverInfo: ServerConfig,
    var isPlaying: Boolean,
    val serverList: MutableList<ServerConfig>
) {
}