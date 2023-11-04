package secondbrain.notes.boundary

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200", description = "Note found")
    @APIResponse(responseCode = "204", description = "Note not found")
    fun getById(id: Long): Note? {
        return noteService.getNoteById(id)
    }

    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204", description = "Note deleted")
    fun deleteById(id: Long) {
        return noteService.deleteNoteById(id)
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200", description = "Note updated")
    @APIResponse(responseCode = "204", description = "Note not found")
    fun updateNote(@PathParam("id") id: Long, note: Note): Note {
        return noteService.updateNote(id, note)
    }

    @GET
    @Path("/byTitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200", description = "Note found")
    @APIResponse(responseCode = "204", description = "Note not found")
    fun getByTitle(@PathParam("title") title: String): List<Note> {
        return noteService.getNotesByTitle(title)
    }
}