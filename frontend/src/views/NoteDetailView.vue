<script setup lang="ts">
import {useRoute} from "vue-router";
import {useNoteStore} from "@/stores/notes";
import {onMounted, onUnmounted} from "vue";
import NoteDetail from "@/components/NoteDetail.vue";

const route = useRoute();
const noteStore = useNoteStore();
const noteId = route.params.id;


onMounted(() => {
  noteStore.getNoteById(noteId);
})

onUnmounted(() => {
  console.log("Unmounting");
  noteStore.clearCurrentNote();
})

</script>

<template>
  <div v-if="noteStore.currentNote">
    <NoteDetail :note="noteStore.currentNote"/>
  </div>
  <div v-else>
    <h3>Note not found. Return to <router-link to="/notes">Notes</router-link></h3>
  </div>
</template>

<style scoped>

</style>