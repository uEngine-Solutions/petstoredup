<template>
    <v-card outlined>
        <v-card-title>
            Pet # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <int offline label="Appearance" v-model="item.appearance" :editMode="false" :key="false" @change="change" />
            <int offline label="Energy" v-model="item.energy" :editMode="false" :key="false" @change="change" />
            <Address offline label="Address" v-model="item.address" :editMode="false" @change="change" />
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'PetDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/pets/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
