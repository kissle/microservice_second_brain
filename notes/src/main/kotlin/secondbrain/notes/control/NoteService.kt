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
}