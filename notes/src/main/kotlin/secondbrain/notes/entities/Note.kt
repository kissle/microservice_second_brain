package secondbrain.notes.entities

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
open class Note() : PanacheEntity() {
    companion object: PanacheCompanion<Note> {
        fun findByTitle(title: String) = list("title ILIKE ?1", title)
    }

    lateinit var title: String
    var content: String? = null
}