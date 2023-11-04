package secondbrain.notes.entities

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
open class Note() : PanacheEntity() {
    companion object: PanacheCompanion<Note> {

    }

    lateinit var title: String
    var content: String? = null

    constructor(title: String, content: String) : this() {
        this.title = title
        this.content = content
    }
}