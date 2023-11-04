package secondbrain.notes.boundary

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import secondbrain.notes.control.NoteService
import secondbrain.notes.entities.Note

@Path("/notes")
class NoteResource {

    @Inject
    lateinit var noteService: NoteService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllNotes(): List<Note> {
        return noteService.getAllNotes()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(note: Note): Note {
        return noteService.createNote(note)
    }
}