package com.example.themovieapp.domain.usecase

import com.example.themovieapp.data.source.remote.dto.movielist.MovieListDto
import com.example.themovieapp.domain.model.CastAndCrew
import com.example.themovieapp.domain.model.ExtraMovieDetails
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.Review
import com.example.themovieapp.domain.repository.MovieRepository
import com.example.themovieapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(
    private val movieRepository: MovieRepository
)  {
    operator fun invoke(id: Int): Flow<Resource<Movie>> {
        return movieRepository.getMovieByIdStream(id)
    }

    fun addExtraMovieDetails(id: Int): Flow<Resource<ExtraMovieDetails>> {
        return movieRepository.addExtraMovieDetails(id)
    }

    fun getCastAndCrewStream(id: Int): Flow<Resource<List<CastAndCrew>>> {
        return movieRepository.getCastAndCrewStream(id)
    }
    fun getMovieReviewStream(id: Int): Flow<Resource<List<Review>>> {
        return movieRepository.getMovieReviewStream(id)
    }


}