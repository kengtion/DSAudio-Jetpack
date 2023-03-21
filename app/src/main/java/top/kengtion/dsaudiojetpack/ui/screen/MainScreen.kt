package top.kengtion.dsaudiojetpack.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.kengtion.dsaudiojetpack.R
import top.kengtion.dsaudiojetpack.data.ServerConfig
import top.kengtion.dsaudiojetpack.ui.enums.TabEnum
import top.kengtion.dsaudiojetpack.ui.state.Song
import top.kengtion.dsaudiojetpack.ui.theme.DSAudioJetPackTheme
import top.kengtion.dsaudiojetpack.ui.viewmodel.AlbumViewModel
import top.kengtion.dsaudiojetpack.ui.viewmodel.BaseTabScreenViewModel
import top.kengtion.dsaudiojetpack.ui.viewmodel.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    tabContent: List<TabEnum>,
    isExpandedScreen: Boolean,
    onTabChange: (TabEnum) -> Unit,
    openDrawer: () -> Unit,
    viewModel: MainViewModel
) {
    var currentSection by remember {
        mutableStateOf(TabEnum.Album)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                TitleBar(
                    serverInfo = viewModel.uiState.serverInfo,
                    serverList = viewModel.uiState.serverList,
                    onSearchClick = {},
                    onSettingClick = {})
            }, navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            })
        },
        bottomBar = {
            BottomPlayer(viewModel = viewModel)
        },
        drawerContent = {
            Text(text = "drawer")
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TopBar(
                tabContent = tabContent,
                currentSection = currentSection,
                onTabChange = {
                    currentSection = it
                    onTabChange(it)
                }
            )
            HorizontalPager(pageCount = tabContent.size, userScrollEnabled = false) {
                when (currentSection) { //TODO more screens
                    TabEnum.Album -> {
                        val albumViewModel =
                            viewModel.getScreenViewModel(TabEnum.Album) as AlbumViewModel
                        BaseTabScreen(
                            content = albumViewModel.contentList,
                            onTabClick = { albumViewModel.onTabClick(it) })
                    }
                    TabEnum.Artist -> {
                        val albumViewModel =
                            viewModel.getScreenViewModel(TabEnum.Album) as AlbumViewModel
                        BaseTabScreen(
                            content = albumViewModel.contentList,
                            onTabClick = { albumViewModel.onTabClick(it) })
                    }
                    TabEnum.Style -> {
                        val albumViewModel =
                            viewModel.getScreenViewModel(TabEnum.Album) as AlbumViewModel
                        BaseTabScreen(
                            content = albumViewModel.contentList,
                            onTabClick = { albumViewModel.onTabClick(it) })
                    }
                    TabEnum.PlayList -> {
                        val albumViewModel =
                            viewModel.getScreenViewModel(TabEnum.Album) as AlbumViewModel
                        BaseTabScreen(
                            content = albumViewModel.contentList,
                            onTabClick = { albumViewModel.onTabClick(it) })
                    }
                }
            }
            Text(text = "content")
        }

    }
}

@Composable
fun BottomPlayer(
    viewModel: MainViewModel
) {
    var playing by remember { mutableStateOf(false) }
    val album =
        if (viewModel.uiState.curPlaying != null) viewModel.findAlbumById(viewModel.uiState.curPlaying!!.albumId) else null
    val curPlaying = viewModel.uiState.curPlaying
    BottomAppBar(modifier = Modifier
        .height(80.dp),
        content = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.mipmap.album_cover_place_holder),
                    modifier = Modifier
                        .height(60.dp)
                        .width(80.dp)
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(shape = RoundedCornerShape(2.dp)),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(260.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                        text = curPlaying?.name ?: ""
                    )
                    Text(
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onPrimary,
                        text = "${curPlaying?.artist?:""} ${album?.name?:""}"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    onClick = {
                        playing = !playing
                        viewModel.onPauseClick()
                    }

                ) {
                    Icon(
                        bitmap = ImageBitmap.imageResource(id = if (playing) R.mipmap.ic_stop_play else R.mipmap.ic_play),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                IconButton(
                    onClick = { viewModel.onNextClick() },
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                ) {
                    Icon(
                        bitmap = ImageBitmap.imageResource(id = R.mipmap.ic_play_next),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
        })
}

@Composable
fun TitleBar(
    serverInfo: ServerConfig,
    serverList: List<ServerConfig>,
    onSearchClick: () -> Unit,
    onSettingClick: () -> Unit
) {
    var dropDownMenu by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(200.dp)
                .clickable(onClick = {
                    dropDownMenu = true
                })
        ) {
            Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
            Text(serverInfo.domain)
            DropdownMenu(expanded = dropDownMenu, onDismissRequest = { dropDownMenu = false }) {
                serverList.forEach {
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(it.domain)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { onSearchClick() }) {
            Icon(Icons.Filled.Search, contentDescription = "search")
        }
        IconButton(onClick = { onSettingClick() }) {
            Icon(Icons.Filled.Settings, contentDescription = "settings")
        }
    }
}

@Composable
fun TopBar(tabContent: List<TabEnum>, currentSection: TabEnum, onTabChange: (TabEnum) -> Unit) {
    ScrollableTabRow(
        selectedTabIndex = tabContent.indexOf(currentSection),
        modifier = Modifier.height(50.dp),
        edgePadding = 0.dp
    ) {
        tabContent.forEachIndexed { _, tab ->
            Tab(selected = currentSection == tab,
                modifier = Modifier.height(50.dp),
                onClick = { onTabChange(tab) }) {
                Column(
                    Modifier.padding(5.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = tab.title)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
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
    val tabList = listOf(TabEnum.Album, TabEnum.Artist, TabEnum.Style, TabEnum.PlayList)
    DSAudioJetPackTheme {
        MainScreen(
            tabContent = tabList,
            isExpandedScreen = false,
            onTabChange = {},
            openDrawer = {},
            viewModel = viewModel
        )
    }
}