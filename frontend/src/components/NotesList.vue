<script setup lang="ts">

import { useNoteStore } from "@/stores/notes";
import {onMounted} from "vue";

const noteStore = useNoteStore();

onMounted(() => {
  noteStore.getNotes();
});

</script>

<template>
  {{ noteStore.currentNote }}
  <div>
    <h3>Notes List<span v-if="noteStore.loading">: Loading</span></h3>
    <ul>
      <li v-for="note in noteStore.notes" :key="note.id">
        <router-link :to="`/notes/${note.id}`"> {{ note.title }} </router-link> - {{ note.content }}
        <button @click="noteStore.deleteNote(note.id)">Delete</button></li>
    </ul>
    <div v-if="noteStore.error">{{ noteStore.error }}</div>
  </div>
</template>

<style scoped>

</style>