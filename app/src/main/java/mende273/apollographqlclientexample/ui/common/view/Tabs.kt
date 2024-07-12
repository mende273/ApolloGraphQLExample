package mende273.apollographqlclientexample.ui.common.view

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Tabs(
    selectedTabIndex: Int,
    tabTitles: List<String>,
    onClick: (Int) -> Unit
) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        tabTitles.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onClick(index) },
                content = { Text(title) })
        }
    }
}