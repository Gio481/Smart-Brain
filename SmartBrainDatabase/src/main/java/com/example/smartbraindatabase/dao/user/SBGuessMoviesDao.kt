package com.example.smartbraindatabase.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartbraindatabase.entity.SBGuessMoviesEntity

@Dao
interface SBGuessMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuessMovie(guessMoviesEntity: SBGuessMoviesEntity)

    @Query("SELECT * FROM guess_movies_table")
    suspend fun getAllGuessMovies(): List<SBGuessMoviesEntity>
}