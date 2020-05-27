<template>
  <div>

    <div>
      <button @click="showModal=true">TEST</button>
    </div>

    <template>
      <div v-show="showModal" style="position: fixed; top: 200px; left: 300px; background-color: #c9c9c9;
       width: 1000px; height: 500px; z-index: 100; ">

        <div>
          Header Text
        </div>

        <div class="container" style="background-color: #f00; height: 200px;">
          <draggable v-model="headerData">

<!--              <div v-for=" d in headerData" :key="d.seq" style="width: 100px; height: 40px; background-color: #00f; float: left">-->
            <div :class=" i == 5 ? 'col' : 'row' " v-for=" ( d , i ) in headerData" :key="d.seq">
              <div>
                <label>
                  {{d.name}}
                  <input type="checkbox" v-model="d.isShow"/>
                </label>
              </div>
            </div>

          </draggable>
        </div>

        <div>
          Footet Text
        </div>

      </div>
    </template>

    <div style="height: 500px; overflow: auto;">



      <table class="table table-dark">
        <thead>
        <tr>
          <th scope="col" v-for=" ( aa , idx ) in headerData ">
          <span v-if="aa.isShow">
            {{aa.name}}
          </span>
          </th>
        </tr>
        <tr>
          <th scope="col" v-for=" ( aa , idx) in headerData">
            <div class="input-group mb-2" v-if="aa.isShow">
              <div class="input-group-prepend">
                <div class="input-group-text" style="cursor: pointer;" @click="$isClick(idx)">@</div>
                <template v-if="aa.isOpen">
                  <ul
                    style="width: 100px; height: 100px; background-color: #f00; position: absolute; top:40px; left: 0px; ">
                    <li @click="$setSearchType('container' , idx)">포함</li>
                    <li @click="$setSearchType('start' , idx)">처음</li>
                    <li @click="$setSearchType('end' , idx)">끝</li>
                  </ul>
                </template>
              </div>
              <input v-model="aa.inputVal" type="text" class="form-control" placeholder="Username"/>
            </div>
          </th>
        </tr>
        </thead>
        <tbody>
        <template v-if="tableData.length > 0">
          <tr v-for="d in tableData">
            <th v-for=" k in headerData">
          <span v-if="k.isShow">
          {{d[k.key]}}
          </span>
            </th>
          </tr>
        </template>
        <template v-else>
          <div>
            <span>데이터가 없습니다</span>
          </div>
        </template>
        </tbody>
      </table>
      <!--// table end-->
    </div>
    <!--// wrap end-->
  </div>
</template>



<script>

  import {mapActions, mapGetters, mapMutations, mapState} from 'vuex'
  import draggable from 'vuedraggable'

  export default {
    name: "AppTable",
    created() {
      this.createData();
      // this.getTableData()
    },
    components: {
      draggable,
    },
    data(){
      return {
        showModal : false
      }
    },
    computed: {

      ...mapState({

        // headerData (state, getters) {
        //   return getters[`table/headerData`]
        // },

        tableData (state, getters) {
          return getters[`table/tableData`]
        },

        inputVal () {
          return this.headerData.map(it => it.inputVal)
        },
        inputType () {
          return this.headerData.map(m => m.inputType)
        },

      }),

      headerData: {
        get () {
          return this.$store.state.table.headerData
        },
        set (value) {
          this.$store.commit('table/setHeaderData', value)
        }
      }

    },
    watch : {
      inputVal(){
        this.getTableData()
      },
      inputType(){
        this.getTableData()
      }
    },
    methods : {
      ...mapActions({
        createData(dispatch){
          return dispatch(`table/createData`)
        },
        getTableData(dispatch){
          return dispatch(`table/getTableData`)
        },
      }),

      ...mapMutations({
        setIsOpen(commit , payload){
          commit(`table/setIsOpen` , payload)
        },
        setInputType(commit , payload){
          commit("table/setInputType" , payload);
        }
      }),

      $isClick(idx) {
        this.setIsOpen(idx)
      },

      $setSearchType(val, idx) {
        this.setInputType({type: val, idx: idx});
        this.setIsOpen(idx)
      }

    }
  }
</script>

<style>
</style>
