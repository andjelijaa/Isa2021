<template>
  <nav
    class="
      top-0
      fixed
      z-50
      w-full
      flex flex-wrap
      items-center
      justify-between
      navbar-expand-lg
      bg-white
      shadow
    "
  >
    <div
      class="container px-4 mx-auto flex flex-wrap items-center justify-between"
    >
      <div
        class="
          w-full
          relative
          flex
          justify-between
          lg:w-auto lg:static lg:block lg:justify-start
        "
      >
        <router-link to="/">
          <a
            class="
              text-blueGray-700 text-sm
              font-bold
              leading-relaxed
              inline-block
              mr-4
              py-2
              whitespace-nowrap
              uppercase
            "
            href="#pablo"
          >
            Rezervacije
          </a>
        </router-link>
        <button
          class="
            cursor-pointer
            text-xl
            leading-none
            px-3
            py-1
            border border-solid border-transparent
            rounded
            bg-transparent
            block
            lg:hidden
            outline-none
            focus:outline-none
          "
          type="button"
          v-on:click="setNavbarOpen"
        >
          <i class="fas fa-bars"></i>
        </button>
      </div>
      <div
        class="lg:flex flex-grow items-center"
        :class="[navbarOpen ? 'block' : 'hidden']"
        id="example-navbar-warning"
      >
        <ul class="flex flex-col lg:flex-row list-none lg:ml-auto">
          <li class="flex items-center" v-if="!isUserAuth">
            <router-link
              to="/auth/login"
              class="
                text-sm
                py-2
                px-4
                font-normal
                block
                w-full
                whitespace-nowrap
                bg-transparent
                text-blueGray-700
              "
            >
              Login
            </router-link>
          </li>
          <li class="flex items-center" v-if="!isUserAuth">
            <router-link
              to="/auth/register"
              class="
                text-sm
                py-2
                px-4
                font-normal
                block
                w-full
                whitespace-nowrap
                bg-transparent
                text-blueGray-700
              "
            >
              Register
            </router-link>
          </li>
           <li class="flex items-center" v-if="isUserAuth">
            <button
              class="
                text-sm
                py-2
                px-4
                font-normal
                block
                w-full
                whitespace-nowrap
                bg-transparent
                text-blueGray-700
              "
              @click="logOut"
            >
              Logout
            </button>
          </li>
          <li class="flex items-center" v-if="isUserAuth">
            <router-link
              to="/profile"
              class="
                text-sm
                py-2
                px-4
                font-normal
                block
                w-full
                whitespace-nowrap
                bg-transparent
                text-blueGray-700
              "
            >
              Profile
            </router-link>
          </li>
          <li class="flex items-center">
            <index-dropdown />
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
import IndexDropdown from "@/components/Dropdowns/IndexDropdown.vue";

export default {
  data() {
    return {
      navbarOpen: false,
      isUserAuth: false
    };
  },
  beforeMount() {
    const isAuth = localStorage.auth;
    if(isAuth !== undefined){
      this.isUserAuth = true;
    }else{
      this.isUserAuth = false;
    }
  },
  methods: {
    setNavbarOpen: function () {
      this.navbarOpen = !this.navbarOpen;
    },
  logOut(){
      localStorage.removeItem('auth');
      this.$router.push('/')
    }
  },
  components: {
    IndexDropdown,
  },
};
</script>
