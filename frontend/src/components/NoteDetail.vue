<script setup lang="ts">
import { type Note} from "@/components/NotesService";

const props = defineProps<{
  note: Note | null
}>()
</script>

<template>
  <div v-if="props.note">
    <h3>{{ props.note.title }}</h3>
    <p>{{ props.note.content }}</p>
  </div>
</template>

<style scoped>

</style>