package io.jero.kmpmovies.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.jero.kmpmovies.data.Movie
import io.jero.kmpmovies.ui.common.LoadingIndicator
import io.jero.kmpmovies.ui.screens.Screen
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.back
import movies.composeapp.generated.resources.original_language
import movies.composeapp.generated.resources.original_title
import movies.composeapp.generated.resources.popularity
import movies.composeapp.generated.resources.release_date
import movies.composeapp.generated.resources.vote_average
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(viewModel: DetailViewModel, onBack: () -> Unit) {
    val state = viewModel.state
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Screen {
        Scaffold(
            topBar = {
                DetailTopAppBar(
                    title = state.movie?.title.orEmpty(),
                    onBack = onBack,
                    scrollBehavior = scrollBehavior
                )
            }
        ) { padding ->
            LoadingIndicator(isLoading = state.isLoading, modifier = Modifier.padding(padding))
            state.movie?.let { movie ->
                MovieDetail(Modifier.padding(padding), movie)
            }
        }
    }
}

@Composable
private fun MovieDetail(
    modifier: Modifier,
    movie: Movie
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        with(movie) {
            AsyncImage(
                model = backDrop ?: poster,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
            Text(
                text = overview,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = buildAnnotatedString {
                    property(name = stringResource(Res.string.original_language), value = originalLanguage)
                    property(name = stringResource(Res.string.original_title), value = originalTitle)
                    property(name = stringResource(Res.string.release_date), value = releaseDate)
                    property(name = stringResource(Res.string.popularity), value = popularity.toString())
                    property(
                        name = stringResource(Res.string.vote_average),
                        value =voteAverage.toString(),
                        endLine = true
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(16.dp)
            )
        }
    }
}

private fun AnnotatedString.Builder.property(name: String, value: String, endLine: Boolean = false) {
    withStyle(ParagraphStyle(lineHeight = 18.sp)) {
        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
            append("$name: ")
            append(value)
            if (!endLine) append("\n")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailTopAppBar(
    title: String,
    onBack: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = stringResource(
                        Res.string.back
                    )
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}
