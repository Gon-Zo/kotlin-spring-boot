import axios from 'axios'

const state = {
  title: 'title success',
  content: '',
  postData : {} ,
}
const getters = {
  title: (state) => {
    return state.title
  },
  content: (state) => {
    return state.content
  },
}
const mutations = {

  setTitle: (state, data) => {
    state.title = data
  },

  setPostData : (state , data) =>{
    state.postData = data
  },

  bindPostData : (state , payload) =>{

    if(payload.length >  0 ){
      state.postData = {
        keys: Object.keys(payload[0]),
        data: payload
      }
    }

  }



}
const actions = {

  actionToBlog(context) {
    console.log("Action success...")
  },

  getPostData(context){
    axios.get(`/post`)
      .then(res => context.commit('bindPostData', res.data))
      .catch( err => console.log(err))
  }

}
export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
}
