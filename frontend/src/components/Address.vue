<template>

    <v-card outlined>
        <v-card-title>
            Address
        </v-card-title>

        <v-card-text>
            <String label="City" v-model="value.city" :editMode="editMode"/>
            <String label="State" v-model="value.state" :editMode="editMode"/>
            <String label="Detail" v-model="value.detail" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'Address',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!this.value) {
                this.$emit('input', {});
                this.newValue = {
                    'city': '',
                    'state': '',
                    'detail': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('city' in this.value)) {
                    this.value.city = '';
                }
                if(!('state' in this.value)) {
                    this.value.state = '';
                }
                if(!('detail' in this.value)) {
                    this.value.detail = '';
                }
            }
            
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

