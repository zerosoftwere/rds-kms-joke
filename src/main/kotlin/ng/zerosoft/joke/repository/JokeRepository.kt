package ng.zerosoft.joke.repository

import ng.zerosoft.joke.domain.Joke
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JokeRepository : JpaRepository<Joke, Long>
