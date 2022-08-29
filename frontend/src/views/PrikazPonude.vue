<template>
<div>
    <index-navbar />
    <br />
    <div class="container">
      <div class="col-lg-8 border p-3 main-section bg-white">
        <div class="row hedding m-0 pl-3 pt-0 pb-3">Ime kategorije</div>
        <div class="row m-0">
          <div class="col-lg-4 left-side-product-box pb-3">
            <img
              src="https://thumbs.dreamstime.com/z/demo-seal-watermark-distress-texture-red-vector-rubber-print-demo-text-dust-texture-text-tag-placed-double-135335018.jpg"
              class="border p-3"
            />
            <span class="sub-img">
              <img
                src="https://thumbs.dreamstime.com/z/demo-seal-watermark-distress-texture-red-vector-rubber-print-demo-text-dust-texture-text-tag-placed-double-135335018.jpg"
                class="border p-2"
              />
              <img
                src="https://thumbs.dreamstime.com/z/demo-seal-watermark-distress-texture-red-vector-rubber-print-demo-text-dust-texture-text-tag-placed-double-135335018.jpg"
                class="border p-2"
              />
              <img
                src="https://thumbs.dreamstime.com/z/demo-seal-watermark-distress-texture-red-vector-rubber-print-demo-text-dust-texture-text-tag-placed-double-135335018.jpg"
                class="border p-2"
              />
            </span>
          </div>
          <div class="col-lg-8">
            <div class="right-side-pro-detail border p-3 m-0">
              <div class="row">
                <div class="col-lg-12">
                  <span>Ime</span>
                  <p class="m-0 p-0">Mesto</p>
                </div>
                <div class="col-lg-12">
                  <p class="m-0 p-0 price-pro">$30</p>
                  <hr class="p-0 m-0" />
                </div>
                <div class="col-lg-12 pt-2">
                  <h5>Product Detail</h5>
                  <span
                    >Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                    ullamco laboris.</span
                  >
                  <hr class="m-0 pt-2 mt-2" />
                </div>
                <div class="col-lg-12">
                  <p class="tag-section">
                    <strong>Tag : </strong><a href="">kategorija</a
                    ><a href="">,Man</a>
                  </p>
                </div>
                <div class="col-lg-12">
                  <h1>Ovde ide datum</h1>
                  <h1>OD :</h1>
                  <Kalendar />
                  <h6>DO :</h6>
                  <Kalendar />
                </div>
                <div class="col-lg-12 mt-3">
                  <div class="row">
                    <div class="col-lg-6 pb-2">
                      <a href="#" class="btn btn-danger w-100">akcija</a>
                    </div>
                    <div class="col-lg-6">
                      <a href="#" class="btn btn-success w-100">rezervisi</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
	</div> 
</template>

<script>
import axios from "axios";
import IndexNavbar from "@/components/Navbars/IndexNavbar.vue";
import Kalendar from "@/components/Kalendar/Kalendar.vue";
const api = "http://localhost:8083";
const brod = "/api/brod/";
const instruktor = "/api/cas/";
const vikendica = "/api/vikendica/";

const config = {
  headers: {
    Authorization: localStorage.auth,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  },
};
const getBrod = () => {
 axios
    .get(api + brod + this.id, config)
    .then((res) => {
      console.log(JSON.stringify(res));
      this.item = JSON.stringify(res);
    })
    .catch((err) => {
      console.log(err.response);
    });
};
const getVikendica = () => {
 axios
    .get(api + vikendica + this.id, config)
    .then((res) => {
      console.log(JSON.stringify(res));
      this.item = JSON.stringify(res);
    })
    .catch((err) => {
      console.log(err.response);
    });
};
const getInstruktor = () => {
 axios
    .get(api + instruktor + this.id, config)
    .then((res) => {
      console.log(JSON.stringify(res));
      this.item = JSON.stringify(res);
    })
    .catch((err) => {
      console.log(err.response);
    });
};

export default {
  props: ["id", "category"],
  data() {
    return {
      item: [],
    };
 },
beforeMount() {
	if (this.category == "brod") {
      getBrod();
    }
    if (this.category == "instruktor") {
      getInstruktor();
    }
    if (this.category == "vikendica") {
      getVikendica();
    }
  },
  components: {
    IndexNavbar,
    Kalendar
},
};
</script>