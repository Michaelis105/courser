<template>
	<v-col cols="9">
		<v-card class="mx-auto">
			<v-data-table :headers="headers" :items="desserts" :items-per-page="5" class="elevation-1"></v-data-table>
		</v-card>
	</v-col>
</template>

<script>

export default {
  name: 'Plan',

  components: {

  },

}
</script>