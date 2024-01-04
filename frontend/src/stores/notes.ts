import {defineStore} from "pinia";
import {ref} from "vue";
import type {Note, NoteFormData} from "@/components/NotesService";
import {NoteService} from "@/components/NotesService";
import type {RouteParamValue} from "vue-router";

export const useNoteStore = defineStore('notes', () => {
    const notes = ref<Note[]>([])
    const error = ref<Error | null>(null)
    const loading = ref(false)
    const currentNote = ref<Note | null>(null)

    function setNotes(newNotes: Note[]) {
        notes.value = newNotes
    }

    function add(note: NoteFormData) {
        NoteService.create(note)
            .then(() => getNotes())
    }

    function getNotes(): void {
        loading.value = true
        NoteService.getNotes()
            .then(notes => setNotes(notes))
            .catch(error => error.value = error)
            .finally(() => loading.value = false)
    }

    function deleteNote(id: number): void {
        loading.value = true
        console.log('deleteNote', id)
        NoteService.deleteNote(id)
            .catch(error => error.value = error)
            .finally(() => {
                getNotes()
            })
    }

    function getNoteById(id: string | RouteParamValue[]): void {
        loading.value = true
        NoteService.getNoteById(id)
            .then(note => {
                console.log('getNoteById', note)
                currentNote.value = note
                console.log('currentNote', currentNote)
            })
            .catch(error => error.value = error)
            .finally(() => loading.value = false)
    }

    function clearCurrentNote() {
        currentNote.value = null
    }

    return {notes, currentNote, loading, error, getNotes, getNoteById, setNotes, deleteNote, clearCurrentNote, add}
})