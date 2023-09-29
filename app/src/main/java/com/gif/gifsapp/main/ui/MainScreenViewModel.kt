package com.gif.gifsapp.main.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gif.gifsapp.main.domain.GetGifListUseCase
import com.gif.gifsapp.main.ui.mapper.GifMapper
import com.gif.gifsapp.main.ui.model.GifUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    application: Application,
    private val getGifListUseCase: GetGifListUseCase,
    private val gifMapper: GifMapper
) :
    AndroidViewModel(application) {

    private val _content =
        MutableStateFlow<List<GifUiModel>>(emptyList())
    val content = _content.asStateFlow()


    fun getGifList() {
        viewModelScope.launch {
            _content.emit(getGifListUseCase.invoke().data.map {
                gifMapper.map(it)
            })
        }
    }
}
