<template>
  <div>
    <Header></Header>
    <div style="display:flex">
      <Aside></Aside>
      <router-view />
    </div>
  </div>
  
</template>
<script>

import Aside from "@/components/Aside";
import Header from "@/components/Header";

export default({
  name:'Home',
  data(){

  },

  components:{
    Aside,
    Header,
  },
})
</script>

<style>

</style>
