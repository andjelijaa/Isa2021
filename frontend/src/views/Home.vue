<template>
  <div class="">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <h1>Neregistrovani korisnici</h1>
    <h3>Ovde idu filteri ali prvo resi ovo oko modela</h3>
    <!-- <HelloWorld msg="Pocetak projekta sa VueJs frontend-om"/> -->
    <Pocetna />
  </div>
</template>

<script>
import Pocetna from '../components/Pocetna.vue'

export default {
  name: 'Home',
  components: {
    Pocetna
    
  }
}
</script>
