package ng.zerosoft.joke.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import ng.zerosoft.joke.service.JokeNotFoundException
import ng.zerosoft.joke.service.JokeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

data class JokeRequest(
    @field:NotBlank
    val setup: String,
    @field:NotBlank
    val punchline: String
)

data class JokeResponse(
    val id: Long,
    val setup: String,
    val punchline: String
)

@Validated
@RestController
@RequestMapping("/api/jokes")
class JokeController(private val jokeService: JokeService) {

    @GetMapping
    fun list(): List<JokeResponse> = jokeService.list().map { JokeResponse(it.id!!, it.setup, it.punchline) }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<JokeResponse> = try {
        val j = jokeService.findById(id)
        ResponseEntity.ok(JokeResponse(j.id!!, j.setup, j.punchline))
    } catch (ex: JokeNotFoundException) {
        ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@Valid @RequestBody req: JokeRequest): ResponseEntity<JokeResponse> {
        val created = jokeService.create(req.setup, req.punchline)
        return ResponseEntity.status(HttpStatus.CREATED).body(JokeResponse(created.id!!, created.setup, created.punchline))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody req: JokeRequest): ResponseEntity<JokeResponse> = try {
        val updated = jokeService.update(id, req.setup, req.punchline)
        ResponseEntity.ok(JokeResponse(updated.id!!, updated.setup, updated.punchline))
    } catch (ex: JokeNotFoundException) {
        ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> = try {
        jokeService.delete(id)
        ResponseEntity.noContent().build()
    } catch (ex: JokeNotFoundException) {
        ResponseEntity.notFound().build()
    }
}
