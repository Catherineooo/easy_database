import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);


export default new Vuex.Store({
    state: {
        user: '',
        token: '',
        type: -1,
        password:'',
        code: 0,//fail
    },
    mutations: {
        setCname(state, cname) {
            state.cname = cname;
            localStorage.setItem('cname', cname);
        },

    },
    actions: {

    }
})
