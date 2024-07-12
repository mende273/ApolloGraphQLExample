package mende273.apollographqlclientexample.ui.common.view

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import mende273.apollographqlclientexample.ui.theme.ApolloGraphqlClientExampleTheme

@Composable
fun ErrorText(reason: String) {
    Text(
        modifier = Modifier.wrapContentSize(),
        text = reason,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun ErrorTextPreview() {
    ApolloGraphqlClientExampleTheme {
        ErrorText(reason = "text to display")
    }
}
