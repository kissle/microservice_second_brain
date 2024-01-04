import axios from 'axios';
import type {UnwrapRef} from "vue";
import type {RouteParamValue} from "vue-router";

export interface Note {
    id: number;
    title: string;
    content: string;
}

export interface NoteFormData {
    title: string;
    content: string;
}

export interface NoteListDto {
    data: Note[]
    page: number;
    pageSize: number;
    pages: number;
}

export class NoteService {
    static getNotes() {
        return axios.get('/api/notes')
            .then(response => response.data.data)
            .catch(error => {
                console.log(error);
                throw error;
            })
    }

    static create(value: UnwrapRef<NoteFormData>) {
        return axios.post('/api/notes', value)
            .then(response => response.data.data)
            .catch(error => {
                console.log(error);
                throw error;
            })

    }

    static getNoteById(id: string | RouteParamValue[]) {
        return axios.get(`/api/notes/${id}`)
            .then(response => response.data)
            .catch(error => {
                console.log(error);
                throw error;
            })
    }

    static deleteNote(id: number) {
        return axios.delete(`/api/notes/${id}`)
    }
}