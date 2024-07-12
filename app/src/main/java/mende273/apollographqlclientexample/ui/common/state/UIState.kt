package mende273.apollographqlclientexample.ui.common.state

sealed interface UIState<out T> {
    data class Success<T>(val data: T) : UIState<T>
    data object ErrorRetrievingData : UIState<Nothing>
    data object Loading : UIState<Nothing>
}