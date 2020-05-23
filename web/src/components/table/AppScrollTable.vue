<template>
  <div style="width: 100%; height: 400px; overflow: auto">
    <table class="table">
      <thead>
      <tr>
        <th class="scroll-title">#</th>
        <th class="scroll-title" v-for=" k in scrollData.keys " scope="col">
          {{k}}
        </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for=" ( d , i ) in  scrollData.data">
        <th>{{i + 1}}</th>
        <th v-for=" k in scrollData.keys">
          {{ d[`${k}`] }}
        </th>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
    export default {
      name: 'AppScrollTable',
      props: ['scrollData'],
      computed: {},
      created () {
      }
    }
</script>

<style scoped>
  .scroll-title {
    position: sticky;
    top: -1px;
    background-color: #fff;
  }
</style>
