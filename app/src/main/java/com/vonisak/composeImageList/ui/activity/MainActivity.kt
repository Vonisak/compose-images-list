package com.vonisak.composeImageList.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.vonisak.composeImageList.MainApp
import com.vonisak.composeImageList.presentation.viewmodel.ImagesViewModel
import com.vonisak.composeImageList.ui.screen.ImageListScreen
import com.vonisak.composeImageList.ui.theme.ComposeImageListTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ImagesViewModel by viewModels {
        (application as MainApp).appComponent.viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeImageListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImageListScreen(viewModel)
                }
            }
        }

        viewModel.getImages()
    }
}