package secondbrain.notes.entities

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
open class Note() : PanacheEntity() {
    companion object: PanacheCompanion<Note> {
        open fun findByTitle(title: String) = list("title ILIKE ?1", title)
    }

    open lateinit var title: String
    open var content: String? = null
}