package com.vonisak.composeImageList.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import com.vonisak.composeImageList.R
import com.vonisak.composeImageList.domain.entity.Image
import com.vonisak.composeImageList.presentation.viewmodel.ImagesViewModel

@Composable
fun ImageItem(image: Image, modifier: Modifier = Modifier) {

    SubcomposeAsyncImage(
        model = image.url,
        contentDescription = stringResource(R.string.image_content_description),
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
            .padding(
                top = dimensionResource(R.dimen.item_padding),
                bottom = dimensionResource(R.dimen.item_padding)
            ),
        loading = {
            CircularProgressIndicator()
        },
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun ImageList(images: List<Image>, modifier: Modifier = Modifier, onImageDelete: (Image) -> Unit) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(
            items = images,
            key = { _: Int, item: Image -> item.id }) { _: Int, item: Image ->

            val state = rememberDismissState(
                confirmStateChange = { dismissValue ->
                    if (dismissValue == DismissValue.DismissedToStart) {
                        onImageDelete(item)
                    }
                    true
                }
            )

            SwipeToDismiss(
                state = state,
                modifier = modifier.animateItemPlacement(),
                background = {
                    ItemDeleteBackground(state)
                }, dismissContent = {
                    ImageItem(image = item)
                },
                directions = setOf(DismissDirection.EndToStart)
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemDeleteBackground(dismissState: DismissState, modifier: Modifier = Modifier) {

    val color = when (dismissState.dismissDirection) {
        DismissDirection.StartToEnd -> Color.Transparent
        DismissDirection.EndToStart -> Color.Red
        else -> Color.White
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = dimensionResource(R.dimen.item_padding),
                bottom = dimensionResource(R.dimen.item_padding)
            )
            .background(color = color)

    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(R.string.delete_icon_content_description),
            tint = Color.Gray,
            modifier = modifier
                .align(Alignment.CenterEnd)
                .size(dimensionResource(R.dimen.delete_icon_size))
        )
    }
}

@Composable
fun ImageListScreen(viewModel: ImagesViewModel = viewModel()) {

    ImageList(viewModel.imagesState) { image ->
        viewModel.deleteImage(image)
    }
}