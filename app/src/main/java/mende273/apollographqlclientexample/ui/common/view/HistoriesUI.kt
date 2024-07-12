package mende273.apollographqlclientexample.ui.common.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mende273.apollographqlclientexample.domain.model.History
import mende273.apollographqlclientexample.ui.common.state.UIState

@Composable
fun HistoriesUI(
    modifier: Modifier = Modifier,
    uiState: UIState<List<History>>
) {
    UiStateWrapper(uiState = uiState) { data ->
        LazyColumn(
            state = rememberLazyListState(),
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(data) {
                Column {
                    Text(text = it.title)
                    Text(text = it.details)
                }
            }
        }
    }
}