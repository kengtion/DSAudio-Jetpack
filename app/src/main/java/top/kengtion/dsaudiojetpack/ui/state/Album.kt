package top.kengtion.dsaudiojetpack.ui.state

import top.kengtion.dsaudiojetpack.ui.screen.BaseTabContent

data class Album(
    val artist: String,
    val name: String,
    val id: Long,
    val cover: String?,
) : BaseTabContent(cover, name, artist)