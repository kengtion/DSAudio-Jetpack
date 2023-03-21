package top.kengtion.dsaudiojetpack.ui.state

data class Song(
    val path:String,
    val name:String,
    val artist:String,
    val albumId:Long,
    val albumName:String,
    val rate:Int,
    val type:String?,
)