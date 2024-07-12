package mende273.apollographqlclientexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mende273.apollographqlclientexample.domain.model.History
import mende273.apollographqlclientexample.domain.model.Rocket
import mende273.apollographqlclientexample.domain.usecase.GetHistoriesUseCase
import mende273.apollographqlclientexample.domain.usecase.GetRocketsUseCase
import mende273.apollographqlclientexample.ui.common.state.UIState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRocketsUseCase: GetRocketsUseCase,
    private val getHistoriesUseCase: GetHistoriesUseCase
) : ViewModel() {

    private val _rocketsUiState = MutableStateFlow<UIState<List<Rocket>>>(UIState.Loading)
    val rocketsUiState: StateFlow<UIState<List<Rocket>>> get() = _rocketsUiState

    private val _historiesUiState = MutableStateFlow<UIState<List<History>>>(UIState.Loading)
    val historiesUiState: StateFlow<UIState<List<History>>> get() = _historiesUiState

    init {
        getRocketsData()
        getHistoriesData()
    }

    private fun getRocketsData() {
        viewModelScope.launch {
            getRocketsUseCase().fold(
                onSuccess = { items ->
                    updateRocketsUiState(UIState.Success(items))
                },
                onFailure = {
                    updateRocketsUiState(UIState.ErrorRetrievingData)
                })
        }
    }

    private fun getHistoriesData() {
        viewModelScope.launch {
            getHistoriesUseCase().fold(
                onSuccess = { items ->
                    updateHistoriesUiState(UIState.Success(items))
                },
                onFailure = {
                    updateHistoriesUiState(UIState.ErrorRetrievingData)
                }
            )
        }
    }

    private fun updateRocketsUiState(uiState: UIState<List<Rocket>>) {
        _rocketsUiState.update { uiState }
    }

    private fun updateHistoriesUiState(uiState: UIState<List<History>>) {
        _historiesUiState.update { uiState }
    }
}
