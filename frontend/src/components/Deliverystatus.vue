<template>

<v-data-table
    :headers="headers"
    :items="deliverystatus"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Deliverystatus',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
        ],
        deliverystatus : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/deliverystatuses')

      this.deliverystatus = temp.data._embedded.deliverystatuses;

    },
    methods: {
    }
  }
</script>

