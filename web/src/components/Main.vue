<template>
	<v-content>
		<v-container class="fill-height" fluid>
			<SystemBar/>
			<router-view/>
		</v-container>

	</v-content>
</template>

<script>

import SystemBar from '../components/SystemBar';

export default {
  name: 'Main',

  components: {
    SystemBar
  }
}
</script>