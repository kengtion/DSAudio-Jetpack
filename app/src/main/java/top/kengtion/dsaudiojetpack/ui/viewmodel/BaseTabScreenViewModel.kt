package top.kengtion.dsaudiojetpack.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import top.kengtion.dsaudiojetpack.ui.screen.BaseTabContent

abstract class BaseTabScreenViewModel<T : BaseTabContent>:ViewModel() {
    var contentList by mutableStateOf(
        listOf<T>()
    )

    abstract fun onTabClick(data:T)
}