package ng.zerosoft.joke.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "jokes")
class Joke(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank
    @Column(nullable = false)
    var setup: String,

    @field:NotBlank
    @Column(nullable = false)
    var punchline: String
)
