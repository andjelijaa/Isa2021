<template>
  <div>
    <navbar />
    <main class="profile-page">
      <section class="relative block h-500-px">
        <div
          class="absolute top-0 w-full h-full bg-center bg-cover"
          style="
            background-image: url('https://images.unsplash.com/photo-1499336315816-097655dcfbda?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2710&q=80');
          "
        >
          <span
            id="blackOverlay"
            class="w-full h-full absolute opacity-50 bg-black"
          ></span>
        </div>
        <div
          class="
            top-auto
            bottom-0
            left-0
            right-0
            w-full
            absolute
            pointer-events-none
            overflow-hidden
            h-70-px
          "
          style="transform: translateZ(0)"
        >
          <svg
            class="absolute bottom-0 overflow-hidden"
            xmlns="http://www.w3.org/2000/svg"
            preserveAspectRatio="none"
            version="1.1"
            viewBox="0 0 2560 100"
            x="0"
            y="0"
          >
            <polygon
              class="text-blueGray-200 fill-current"
              points="2560 0 2560 100 0 100"
            ></polygon>
          </svg>
        </div>
      </section>
      <section class="relative py-16 bg-blueGray-200">
        <div class="container mx-auto px-4">
          <div
              class="
              relative
              flex flex-col
              min-w-0
              break-words
              bg-white
              w-full
              mb-6
              shadow-xl
              rounded-lg
              -mt-64
            "          >
            <div class="px-6">
              <div class="flex flex-wrap justify-center">
                <div
                  class="w-full lg:w-3/12 px-4 lg:order-2 flex justify-center"
                >
                </div>
                <div
                   class="
                    w-full
                    lg:w-4/12
                    px-4
                    lg:order-3 lg:text-right lg:self-center
                  "                >
                   <div class="py-6 px-3 mt-32 sm:mt-0">
                    <button
 class="
                        bg-emerald-500
                        active:bg-emerald-600
                        uppercase
                        text-white
                        font-bold
                        hover:shadow-md
                        shadow
                        text-xs
                        px-4
                        py-2
                        rounded
                        outline-none
                        focus:outline-none
                        sm:mr-2
                        mb-1
                        ease-linear
                        transition-all
                        duration-150
                      "
                      type="button"
                     @click="edit"
                    >
                      Edit
                    </button>
                  </div>
                </div>
                <div class="w-full lg:w-4/12 px-4 lg:order-1">
                  <div class="flex justify-center py-4 lg:pt-4 pt-8">
                    <div class="mr-4 p-3 text-center">
                      <span
                          class="
                          text-xl
                          font-bold
                          block
                          uppercase
                          tracking-wide
                          text-blueGray-600
                        "                      >
                        33
                      </span>
                      <span class="text-sm text-blueGray-400">Friends</span>
                    </div>
                    <div class="mr-4 p-3 text-center">
                      <span
                         class="
                          text-xl
                          font-bold
                          block
                          uppercase
                          tracking-wide
                          text-blueGray-600
                        "                      >
                        10
                      </span>
                      <span class="text-sm text-blueGray-400">Photos</span>
                    </div>
                    <div class="lg:mr-4 p-3 text-center">
                      <span
                          class="
                          text-xl
                          font-bold
                          block
                          uppercase
                          tracking-wide
                          text-blueGray-600
                        "                      >
                        89
                      </span>
                      <span class="text-sm text-blueGray-400">Comments</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center mt-12">
               
              <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">email</span
                      >                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="username"
                      readonly="readonly"
                    />
                  </div>
                </div>
                <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">password</span
                      >                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="password"
                    />
                  </div>
                </div>
                                <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text" id="basic-addon1"
                        >ime</span
                      >
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="ime"
                    />
                  </div>
                </div>
                <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text" id="basic-addon1"
                        >prezime</span
                      >
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="prezime"
                    />
                  </div>
                </div>
                <div class="mb-2 text-blueGray-600">
                       <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1"
                        >grad</span>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="grad"
                    />
                  </div>
                </div>



                <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1"
                        >drzava</span
                      >                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="drzava"
                    />
                  </div>
                </div>
                 <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text" id="basic-addon1"
                        >adresa</span
                      >
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="adresa"
                    />
                  </div>
                </div>

                <div class="mb-2 text-blueGray-600">
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                       <span class="input-group-text" id="basic-addon1"
                        >telefon</span>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      aria-describedby="basic-addon1"
                      v-model="broj_telefona"
                    />
                  </div>
                </div>
              </div>
              <div>
                  <!-- Button trigger modal -->
                  <button
                    type="button"
                    class="btn btn-danger"
                    data-toggle="modal"
                    data-target="#exampleModal"
                  >
                    Obrisi nalog
                  </button>

                  <!-- Modal -->
                  <div
                    class="modal fade"
                    id="exampleModal"
                    tabindex="-1"
                    role="dialog"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true"
                  >
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">
                            Modal title
                          </h5>
                          <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                          >
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <div class="input-group">
                            <div class="input-group-prepend">
                              <span class="input-group-text"
                                >Razlog brisanja naloga</span
                              >
                            </div>
                            <textarea
                              class="form-control"
                              v-model="text_brisanje"
                            ></textarea>
                          </div>
                        </div>
                        <div class="modal-footer">
                          <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                          >
                            Close
                          </button>
                          <button
                            type="button"
                            @click="zahtevZaBrisanjeNaloga"
                            class="btn btn-danger"
                          >
                            Obrisi
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                
            </div>
          </div>
        </div>
      </section>
    </main>
    <footer-component />
  </div>
</template>
<script>
import Navbar from "@/components/Navbars/AuthNavbar.vue";
import axios from "axios";

const apiUser = "http://localhost:8083/api/user/updateUser";
const apiDeleteUser = "http://localhost:8083/api/user/brisanjeNaloga";
const config = {
  headers: {
    Authorization: localStorage.auth,
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  },
};
export default {
  data() {
    return {
      username: "",
      pass: "",
      ime: "",
      prezime: "",
      adresa: "",
      grad: "",
      drzava: "",
      broj_telefona: "",
      text_brisanje: "",
    };
  },
  beforeMount() {
    axios
      .get(apiUser, config)
      .then((res) => {
        console.log(JSON.stringify(res));
        const user = JSON.stringify(res);
        this.username = user.username;
        this.pass = user.password;
        this.ime = user.ime;
        this.prezime = user.prezime;
        this.adresa = user.adresa;
        this.grad = user.grad;
        this.drzava = user.drzava;
        this.broj_telefona = user.phone;      })
      .catch((err) => {
        console.log(err.response);
      });
  },
  methods: {
    edit(){
      const updateUser = {
          ime: this.ime,
          prezime: this.prezime,
          adresa: this.adresa,
          grad: this.grad,
          drzava: this.drzava,
          phone: this.broj_telefona,
          password: this.pass,
        };
      axios
        .put(apiUser, updateUser, config)
        .then(res => {
          console.log(res)
        })
        .catch((err) => console.log(err));
    },
    zahtevZaBrisanjeNaloga() {
      const brisanjeNalogaDto = {
        zahtev: this.text_brisanje
      }
      axios
        .post(apiDeleteUser, brisanjeNalogaDto, config)
        .then((res) => {
          console.log(res);
          if(res){
            alert("Uspesno ste podneli zahtev");
          }else{
            alert("Nesto je krenulo lose :(, pokusajte ponovo");
          }
        })
        
        .catch(err =>{
          console.log(err)
          alert("Nesto je krenulo lose :(, pokusajte ponovo");
        });
    },
  },
  components: {
    Navbar
  },
};
</script>
