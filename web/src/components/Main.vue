<template>
	<v-content>
		<v-container fluid>
			<!--<v-breadcrumbs :items="items" large></v-breadcrumbs>-->
			<router-view/>
		</v-container>
	</v-content>
</template>

<script>
	export default {
		name: 'Main',
	}
</script>