<template>
  <div>
    <div>
      <span>Blog</span>
    </div>
    <div>
      <button  @click="onCLick">
        test
      </button>
    </div>
<!--    <div>-->
<!--      <AppScrollTable :scrollData="postData"/>-->
<!--    </div>-->
  </div>
</template>

<script>

  import AppTable from "../table/AppTable";
  import {createNamespacedHelpers} from 'vuex'
  import AppScrollTable from '../table/AppScrollTable'
  import axios from 'axios';

  const {mapActions, mapGetters, mapMutations, mapState} = createNamespacedHelpers('blog')

  export default {
    name: "blog",
    components: {AppScrollTable, AppTable},
    computed : {
      ...mapState({
        postData : state => state.postData
      })
    },
    created () {
     this.getPostData();
    },
    methods :{
      ...mapActions(['getPostData']) ,

      onCLick (){
        const param = {
          email: "test@naver.com",
          password: 1234
        }
       axios.post('https://localhost:8080/test/login', param)
        .then(res => console.log(res.status)).catch(err => console.log(err))
      }

    },
  }
</script>
