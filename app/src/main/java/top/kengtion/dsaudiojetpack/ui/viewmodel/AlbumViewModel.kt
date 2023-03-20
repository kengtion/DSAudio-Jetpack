package top.kengtion.dsaudiojetpack.ui.viewmodel

import android.util.Log
import top.kengtion.dsaudiojetpack.data.Album

class AlbumViewModel : BaseTabScreenViewModel<Album>() {

    init {
        val list = listOf<Album>(
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),
            Album(null, "12新作", "周杰伦"),
            Album(null, "13新作", "周杰伦1"),
            Album(null, "14新作", "周杰伦2"),
            Album(null, "15新作", "周杰伦3"),
            Album(null, "16新作", "周杰伦4"),
            Album(null, "17新作", "周杰伦5"),
            Album(null, "18新作", "周杰伦6"),

            )
        contentList = list
    }

    override fun onTabClick(data: Album) {
        // TODO:
        Log.i("AlbumViewModel" , data.name + " clicked")
    }
}