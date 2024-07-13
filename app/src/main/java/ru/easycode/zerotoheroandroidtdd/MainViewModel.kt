package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        Log.d("wut", "progress visible")
        viewModelScope.launch {
            Log.d("wut", "scope launched")
            val result = repository.load()
            Log.d("wut", "result is simpleresponse(" + result.text + ")")
            liveDataWrapper.update(UiState.ShowData(result.text))
            Log.d("wut", "ldw upd sD with text- " + result.text)
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val uiState = bundleWrapper.restore()
        liveDataWrapper.update(uiState)
    }

}