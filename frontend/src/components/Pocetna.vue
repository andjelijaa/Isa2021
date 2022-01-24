<template>
  <div>
    Pocetna
    <b-container class="bv-example-row">
      <b-row>
        <b-col v-for="card in cards" :key="card.id">
          <div>
            <b-card
              :title= "card.title"
              :img-src="card.img"
              img-alt="Image"
              img-top
              tag="article"
              style="max-width: 20rem"
              class="mb-2"
            >
              <b-card-text>
                {{card.text}}
              </b-card-text>

              <b-button :href="card.href" variant="primary">Go somewhere</b-button>
            </b-card>
          </div>
        </b-col>
      </b-row>
    </b-container>
<!-- Uradi na BE da vraca objekat sastavljen od sva tri entiteta umesto da se razdvaja na FE -->
  </div>
</template>

<script>
const cards = [
  {
    id: 0,
    img: "https://picsum.photos/600/300/?image=25",
    title: "Cards 1",
    text: "asdgawr efae fwgea vsd g hrtbgsfdfetgre sdfgerefwae gwesbfdvdfsetf",
    href: "#",
  },
  {
    id: 1,
    img: "https://picsum.photos/600/300/?image=25",
    title: "Cards 2",
    text: "asdgawr efae fwgea vsd g hrtbgsfdfetgre sdfgerefwae gwesbfdvdfsetf",
    href: "#",
  },
  {
    id: 2,
    img: "https://picsum.photos/600/300/?image=25",
    title: "Cards 3",
    text: "asdgawr efae fwgea vsd g hrtbgsfdfetgre sdfgerefwae gwesbfdvdfsetf",
    href: "#",
  },
];
export default {
  name: "Pocetna",
  data() {
    return {
      cards: cards,
    };
  },
  //   Dodaj sutra da vuce sa BE kad sredis bazu oko slika
};
</script>
