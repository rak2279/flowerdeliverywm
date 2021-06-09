<template>

<v-data-table
    :headers="headers"
    :items="myPage"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyPage',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "storeName", value: "storeName" },
            { text: "itemName", value: "itemName" },
            { text: "orderQty", value: "orderQty" },
            { text: "itemPrice", value: "itemPrice" },
            { text: "orderStatus", value: "orderStatus" },
            { text: "deliveryStatus", value: "deliveryStatus" },
            { text: "orderId", value: "orderId" },
            { text: "userName", value: "userName" },
            { text: "productStatus", value: "productStatus" },
        ],
        myPage : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/mypages')

      this.myPage = temp.data._embedded.mypages;

    },
    methods: {
    }
  }
</script>

