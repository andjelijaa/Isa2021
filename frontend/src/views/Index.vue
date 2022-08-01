<template>
  <div>
    <index-navbar />
    <section
      class="header relative pt-16 items-center flex h-screen max-h-860-px"
    >
      <div class="container px-4 mx-auto">
        <div class="flex flex-wrap">
          <div class="w-full px-4 flex-1" @click="getVikendice">
            <span
              class="
                text-sm
                block
                my-4
                p-3
                text-blueGray-700
                rounded
                border border-solid border-blueGray-100
              "
              >Vikendice</span
            >
          </div>
          <div class="w-full px-4 flex-1" @click="getBrodovi">
            <span
              class="
                text-sm
                block
                my-4
                p-3
                text-blueGray-700
                rounded
                border border-solid border-blueGray-100
              "
              >Brodovi</span
            >
          </div>
          <div class="w-full px-4 flex-1" @click="getInstruktori">
            <span
              class="
                text-sm
                block
                my-4
                p-3
                text-blueGray-700
                rounded
                border border-solid border-blueGray-100
              "
              >Instruktori</span
            >
          </div>
        </div>
      </div>
    </section>
    <div v-for="item in items" :key="item.id">
       <div class="float-left">
        <kartica-za-prikaz-ponude
          :name="item.name"
          :id="item.id"
          :text="item.text"
        />
      </div>
    </div><br/>
    <!-- <section class="mt-48 md:mt-40 pb-40 relative bg-blueGray-100"></section> -->
  </div>
</template>

<script>
import IndexNavbar from "@/components/Navbars/IndexNavbar.vue";
import KarticaZaPrikazPonude from "@/components/Kartice/KarticaZaPrikazPonude.vue";
// import FooterComponent from "@/components/Footers/Footer.vue";

import patternVue from "@/assets/img/pattern_vue.png";
import componentBtn from "@/assets/img/component-btn.png";
import componentProfileCard from "@/assets/img/component-profile-card.png";
import componentInfoCard from "@/assets/img/component-info-card.png";
import componentInfo2 from "@/assets/img/component-info-2.png";
import componentMenu from "@/assets/img/component-menu.png";
import componentBtnPink from "@/assets/img/component-btn-pink.png";
import documentation from "@/assets/img/documentation.png";
import login from "@/assets/img/login.jpg";
import profile from "@/assets/img/profile.jpg";
import landing from "@/assets/img/landing.jpg";
import axios from "axios";

const api = "http://localhost:8083";

const vikendice = "/api/vikendica/getAll";
const brodovi = "/api/brod/getAllBrodovi";
const instruktori = "/api/cas/getAllCas";

const config = {
        headers: {
          Authorization: localStorage.auth,
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",        },
      };
export default {
  data() {
    return {
      patternVue,
      componentBtn,
      componentProfileCard,
      componentInfoCard,
      componentInfo2,
      componentMenu,
      componentBtnPink,
      documentation,
      login,
      profile,
      landing,
      items:[
         {
          name: "ime",
          id: 1,
          text: "text1",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime2",
          id: 2,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
        {
          name: "ime22222",
          id: 222222,
          text: "text2",
          src: "https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg",
        },
      ],
    };
  },
  methods:{
    getVikendice(){
      console.log(config)
      console.log('link: ', api + vikendice)
      axios.get(api + vikendice, config)
      .then((res) => {
        console.log(JSON.stringify(res))
        this.items = JSON.stringify(res)
      })
      .catch(err => {
        console.log(err.response)
      });
    },
    getBrodovi(){
      console.log(config)
      console.log('link: ', api + brodovi)
      axios
      .get(api + brodovi, config)
      .then((res) => {
        console.log(JSON.stringify(res))
        this.items = JSON.stringify(res)
      })
      .catch(err => {
        console.log(err.response)
      });

    },
    getInstruktori(){
      console.log(config)
      console.log('link: ', api + instruktori)
      axios
      .get(api + instruktori, config)
      .then((res) => {
        console.log(JSON.stringify(res))
        this.items = JSON.stringify(res)
      })
      .catch(err => {
        console.log(err.response)
      });
    },
  },
  components: {
    IndexNavbar,
    KarticaZaPrikazPonude
 // FooterComponent,
  },
};
</script>
