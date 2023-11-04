package secondbrain.notes.control

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import secondbrain.notes.entities.Note

@ApplicationScoped
class NoteService {
    fun getAllNotes(): List<Note> {
        return Note.listAll()
    }

    @Transactional
    fun createNote(note: Note): Note {
        note.persist()
        return note
    }

    fun getNoteById(id: Long): Note? {
        return Note.findById(id)
    }

    @Transactional
    fun deleteNoteById(id: Long) {
        val note = Note.findById(id)
        note?.delete()
    }

    @Transactional
    fun updateNote(id: Long, note: Note): Note {
        val entity = Note.findById(id)
        entity?.title = note.title
        entity?.content = note.content
        return entity!!
    }

    fun getNotesByTitle(title: String): List<Note> {
        return Note.findByTitle(title)
    }
}
