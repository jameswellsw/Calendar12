import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(SampleColorScheme) {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            CompositionLocalProvider(LocalScaffoldPaddingValues provides padding) {
                Example3Page()
            }
        }
    }
}
