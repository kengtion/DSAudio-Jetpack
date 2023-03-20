package top.kengtion.dsaudiojetpack.ui.screen

import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.kengtion.dsaudiojetpack.R
import top.kengtion.dsaudiojetpack.ui.theme.DSAudioJetPackTheme
import top.kengtion.dsaudiojetpack.utils.AppContextHelper


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T : BaseTabContent> BaseTabScreen(content: List<T>, onTabClick: (T) -> Unit) {
    LazyColumn (modifier = Modifier.background(Color.LightGray)){
        stickyHeader {

        }

        items(content) { item ->
            renderAlbum(content = item)
        }
    }
}


@Composable
fun renderAlbum(content: BaseTabContent) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(80.dp)
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.mipmap.album_cover_place_holder),//TODO place with net image
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(style = TextStyle(fontSize = 20.sp, color = Color.Black), text = content.title)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                text = content.subTitle ?: ""
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
    Divider(modifier = Modifier.padding(start = 10.dp , end = 10.dp), color = Color.DarkGray , thickness = 1.dp)
}


@Preview(showBackground = true)
@Composable
fun TabPreview() {
    val list = listOf<BaseTabContent>(
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),
        BaseTabContent(null, "12新作", "周杰伦"),
        BaseTabContent(null, "13新作", "周杰伦1"),
        BaseTabContent(null, "14新作", "周杰伦2"),
        BaseTabContent(null, "15新作", "周杰伦3"),
        BaseTabContent(null, "16新作", "周杰伦4"),
        BaseTabContent(null, "17新作", "周杰伦5"),
        BaseTabContent(null, "18新作", "周杰伦6"),

    )
    DSAudioJetPackTheme {
        BaseTabScreen(content = list, onTabClick = {
            Log.i("ContentPreview", it.title + " clicked")
        })
    }
}