<template>
  <div>
      <h1>Vikendica</h1>
      <h1>{{card.title}}</h1>
    <b-container>
      <b-row>
        <b-col>{{card.img}}</b-col>
        <b-col>{{card.text}}</b-col>
      </b-row>
    </b-container>

    <button>Iznajmi brod</button>
  </div>
</template>
<script>
  card = {
      id: 0,
    img: "https://picsum.photos/600/300/?image=25",
    title: "Vikendica 1",
    text: "asdgawr efae fwgea vsd g hrtbgsfdfetgre sdfgerefwae gwesbfdvdfsetf",
    href: "#",
  }
export default {
  name: "Vikendica",
  data() {
    return {
      card: card,
    };
  },
  mounted () {
    axios
      .get('https://localhost:8083/vlasnik/pretraga')
      .then(response => (console.log(response)))
  }
};
</script>