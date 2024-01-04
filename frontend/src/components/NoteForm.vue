<script setup lang="ts">
import {ref} from "vue";
import {type NoteFormData} from "@/components/NotesService";
import {useNoteStore} from "@/stores/notes";

const noteStore = useNoteStore();

const note = ref<NoteFormData>({
  title: "",
  content: "",
});

const submitNote = () => {
  console.log(note.value);
  noteStore.add(note.value)

  note.value = {
    title: "",
    content: "",
  };
}
</script>

<template>
<div>
  <form @submit.prevent="submitNote">
    <label for="title">Title</label>
    <input type="text" id="title" v-model="note.title" />
    <label for="content">Content</label>
    <textarea id="content" v-model="note.content"></textarea>
    <button type="submit">Submit</button>
  </form>
</div>
</template>

<style scoped>

</style>