package com.example.themovieapp.data.source.local.room.moviedetails.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.themovieapp.domain.model.ExtraMovieDetails

@Entity(
    tableName = "extra_movie_details_table",
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["id"],
        childColumns = ["movie_id"],
    )]
)
data class ExtraMovieDetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = "movie_id") val movieId: Int,
    val budget: Long,
    val homepage: String,
    @ColumnInfo("imdb_id") val imdbId: String,
    @ColumnInfo("original_language") val originalLanguage: String,
    @ColumnInfo("original_title") val originalTitle: String,
    @ColumnInfo("recommendation_movies_list") val recommendationMoviesList: String,
    val revenue: Long,
    val runtime: Int,
    val status: String,
    val tagline: String,
) {
    fun toExtraMovieDetails(): ExtraMovieDetails = ExtraMovieDetails(
        id = movieId,
        budget = budget.toLong(),
        homepage = homepage,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        revenue = revenue.toLong(),
        runtime = runtime,
        status = status,
        tagline = tagline,
        recommendationMoviesList =
        try {
            recommendationMoviesList.replace("[","").replace("]","").split(", ") .map { it.toInt() }.toList()
        } catch (e: Exception) {
            listOf(-1, -2)
        },

        )

}
