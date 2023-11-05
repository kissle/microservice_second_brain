package secondbrain.notes

import io.quarkus.test.InjectMock
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import secondbrain.notes.control.NoteService
import secondbrain.notes.entities.Note

fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

@QuarkusTest
class NoteResourceTest {

    @InjectMock
    lateinit var mockNoteService: NoteService

    @Test
    fun testGetNotesEndpoint() {
        val note = Note()
        note.title = "Test Title"
        note.content = "Test Content"

        val notes = listOf(note)
        Mockito.`when`(mockNoteService.getAllNotes()).thenReturn(notes)

        given()
                .`when`().get("/notes")
                .then()
                .statusCode(200)
                .body(`is`("[{\"id\":null,\"title\":\"Test Title\",\"content\":\"Test Content\"}]"))
    }

    @Test
    fun `test create note endpoint`() {
        val note = Note()
        note.title = "Test Title"
        note.content = "Test Content"

        Mockito.`when`(mockNoteService.createNote(any(Note::class.java))).thenReturn(note)

        given()
                .contentType("application/json")
                .body(note)
                .`when`().post("/notes")
                .then()
                .statusCode(200)
                .body(`is`("{\"id\":null,\"title\":\"Test Title\",\"content\":\"Test Content\"}"))
    }
}