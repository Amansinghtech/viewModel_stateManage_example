package com.example.androidprac.presentation.components

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.androidprac.R
import com.example.androidprac.presentation.components.DynamicImageSource.DrawableObject
import com.example.androidprac.presentation.components.DynamicImageSource.ImageUri
import com.example.androidprac.presentation.components.DynamicImageSource.Local
import com.example.androidprac.presentation.components.DynamicImageSource.Url
import com.example.androidprac.presentation.components.DynamicImageSource.Vector


/**
 * DynamicImageSource is a sealed class that defines the source of the image.
 *
 * @property Url The image will be loaded from a URL.
 * @property Local The image will be loaded from a local asset.
 * @property Vector The image will be loaded from a vector graphic.
 * @property ImageUri The image will be loaded from a URI.
 * @property DrawableObject The image will be loaded from a drawable object.
 *
 * @see [DynamicImage]
 */
sealed class DynamicImageSource {
    data class Url(
        val url: String?,
        val placeholder: Int = R.drawable.ic_loading,
        val fallback: Int = R.drawable.ic_fallback_image,
    ) : DynamicImageSource()

    data class Local(val localImage: Int, val asVector: Boolean = false) : DynamicImageSource()
    data class Vector(val vectorImage: ImageVector) : DynamicImageSource()
    data class ImageUri(val uri: Uri) : DynamicImageSource()
    data class DrawableObject(val drawable: Drawable) : DynamicImageSource()
}

/**
 * ImageCustomization is a data class that allows you to modify the appearance of the image.
 *
 * @param contentScale Defines how the content should be scaled. Default is 'ContentScale.Crop'.
 * @param alignment Alignment within the box. Default is 'Alignment.Center'.
 * @param colorFilter An optional color filter to be applied to the image.
 * @param tint An optional tint color to be applied to the image vector.
 *
 */
data class ImageCustomization(
    val modifier: Modifier = Modifier,
    val contentScale: ContentScale = ContentScale.FillWidth,
    val alignment: Alignment = Alignment.Center,
    val colorFilter: ColorFilter? = null,
    val tint: Color? = null,
) {
    companion object {
        val Default
            @Composable
            get() = ImageCustomization(
                tint = LocalContentColor.current
            )
    }
}

/**
 * DynamicImage provides a flexible way to display images. It can handle various image sources
 * including URLs, local assets, or even vector graphics. This component ensures a unified
 * interface for image rendering across different types of sources.
 *
 * @param imageSource The source of the image. Can be a URL, local asset, or vector graphic.
 * @param description An optional content description for the image. Essential for accessibility.
 * @param customization An optional customization object that allows you to modify the image's appearance.
 *
 * @see [DynamicImageSource]
 *
 * @author
 * Deepak Yadu @deepak404found
 */

@Composable
fun DynamicImage(
    imageSource: DynamicImageSource,
    description: String? = null,
    customization: ImageCustomization = ImageCustomization.Default
) {
    when (imageSource) {
        is Url -> {
            // load image from url
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageSource.url)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = description,
                contentScale = customization.contentScale,
                alignment = customization.alignment,
                colorFilter = customization.colorFilter,
                modifier = customization.modifier,
                placeholder = painterResource(id = imageSource.placeholder),
                error = painterResource(id = imageSource.fallback),
                onError = { error ->
                    Log.e("DynamicImage", "URL: ${imageSource.url} DynamicImage Error: $error")
                },
//                    onLoading = { loading ->
//                        Log.d("DynamicImage", "DynamicImage: $loading, URL: ${imageSource.url}")
//                    },
//                    onSuccess = { success ->
//                        Log.d("DynamicImage", "DynamicImage: $success")
//                    }
            )
        }

        is Local -> {
            // load image from local
            if (imageSource.asVector) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = imageSource.localImage),
                    contentDescription = null,
                    modifier = customization.modifier,
                    tint = customization.tint ?: LocalContentColor.current,
                )
            } else {
                Image(
                    painter = painterResource(id = imageSource.localImage),
                    contentDescription = description,
                    contentScale = customization.contentScale,
                    alignment = customization.alignment,
                    colorFilter = customization.colorFilter,
                    modifier = customization.modifier
                )
            }
        }

        is Vector -> {
            Icon(
                imageVector = imageSource.vectorImage,
                contentDescription = null,
                modifier = customization.modifier,
                tint = customization.tint ?: LocalContentColor.current,
            )
        }

        is ImageUri -> {
            // load image from uri
            Image(
                painter = rememberAsyncImagePainter(imageSource.uri),
                contentDescription = description,
                contentScale = customization.contentScale,
                alignment = customization.alignment,
                colorFilter = customization.colorFilter,
                modifier = customization.modifier
            )
        }

        is DrawableObject ->
            Image(
                painter = rememberAsyncImagePainter(imageSource.drawable),
                contentDescription = description,
                contentScale = customization.contentScale,
                alignment = customization.alignment,
                colorFilter = customization.colorFilter,
                modifier = customization.modifier
            )
    }
}