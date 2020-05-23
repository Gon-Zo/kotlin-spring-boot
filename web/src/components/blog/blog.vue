<template>
  <div>
    <div>
      <span>Blog</span>
    </div>
    <div>
      <AppScrollTable :scrollData="postData"/>
    </div>
  </div>
</template>

<script>

  import AppTable from "../table/AppTable";
  import {createNamespacedHelpers} from 'vuex'
  import AppScrollTable from '../table/AppScrollTable'

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
      ...mapActions(['getPostData'])
    },
  }
</script>
