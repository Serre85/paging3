package com.hslee.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.hslee.ui.DetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    imageId: Int,
    onNavigateBack: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val image by viewModel.image.collectAsState()
    var showFullScreen by remember { mutableStateOf(false) }

    LaunchedEffect(imageId) {
        viewModel.getImage(imageId)
    }

    if (showFullScreen) {
        image?.let {
            FullScreenImage(
                imageUrl = it.download_url,
                onDismiss = { showFullScreen = false }
            )
        }
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Image Details") },
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                image?.let {
                    AsyncImage(
                        model = it.download_url,
                        contentDescription = "Image ${it.id}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clickable { showFullScreen = true }
                    )

                    DetailItem("ID", it.id.toString())
                    DetailItem("Author", it.author)
                    DetailItem("Width / Height", "${it.width} / ${it.height}")
                    DetailItem("URL", it.url)
                    DetailItem("Download URL", it.download_url)
                }
            }
        }
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
} 