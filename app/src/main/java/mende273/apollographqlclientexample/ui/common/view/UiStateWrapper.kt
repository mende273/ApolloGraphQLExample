package mende273.apollographqlclientexample.ui.common.view

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import mende273.apollographqlclientexample.R
import mende273.apollographqlclientexample.ui.common.state.UIState

@Composable
fun <T> UiStateWrapper(
    uiState: UIState<T>,
    onErrorRetrievingData: @Composable () -> Unit = {
        FullSizeBox { ErrorText(reason = stringResource(id = R.string.generic_error)) }
    },
    onLoading: @Composable () -> Unit = {
        FullSizeBox {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.tertiary,
                trackColor = MaterialTheme.colorScheme.secondary
            )
        }
    },
    onSuccessWithData: @Composable (T) -> Unit
) {
    when (uiState) {
        UIState.Loading -> onLoading()
        UIState.ErrorRetrievingData -> onErrorRetrievingData()
        is UIState.Success -> onSuccessWithData(uiState.data)
    }
}