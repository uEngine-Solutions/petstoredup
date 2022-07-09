<template>

    <v-data-table
            :headers="headers"
            :items="address"
            :items-per-page="5"
            class="elevation-1"
    ></v-data-table>

</template>

<script>

    export default {
        name: 'AddressList',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { 
                    text: "city", 
                    value: "city" 
                },
                { 
                    text: "state", 
                    value: "state" 
                },
                { 
                    text: "detail", 
                    value: "detail" 
                },
            ],
            address : [],
        }),
        async created() {
            if(!this.value) this.value = [];
        },
        methods: {
        }
    }
</script>

