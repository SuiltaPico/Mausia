import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.ModalDrawer
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailDefaults
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import mausia.composeapp.generated.resources.Res
import mausia.composeapp.generated.resources.eg
import mausia.composeapp.generated.resources.fr
import mausia.composeapp.generated.resources.id
import mausia.composeapp.generated.resources.jp
import mausia.composeapp.generated.resources.mx
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
  this.clickable(
    indication = null,
    interactionSource = remember { MutableInteractionSource() }) {
    onClick()
  }
}

class NoRippleInteractionSource : MutableInteractionSource {
  override val interactions: Flow<Interaction> = emptyFlow()
  override suspend fun emit(interaction: Interaction) {}
  override fun tryEmit(interaction: Interaction) = true
}


@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
@Preview
fun App() {
  var selectedItem by remember { mutableStateOf(0) }
  val items = listOf("聊天", "知识库", "设置")
  val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
  val interactionSource = remember { MutableInteractionSource() }

  Row {

  }
  NavigationRail(windowInsets = NavigationRailDefaults.windowInsets) {
    items.forEachIndexed { index, item ->
      NavigationRailItem(
        icon = { Icon(icons[index], contentDescription = item) },
        label = { Text(item) },
        selected = selectedItem == index,
        onClick = { selectedItem = index },
        interactionSource = NoRippleInteractionSource(),
//        modifier = Modifier.noRippleClickable({})
      )
    }
  }

}