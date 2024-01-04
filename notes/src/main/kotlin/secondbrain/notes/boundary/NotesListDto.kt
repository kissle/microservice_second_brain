package secondbrain.notes.boundary

import secondbrain.notes.entities.Note

class NotesListDto {

    var data: List<Note> = emptyList()
    var page: Int = 0
    var pageSize: Int = 0
    var pages: Int = 1
}