<template>
  <nav
    class="
      top-0
      absolute
      z-50
      w-full
      flex flex-wrap
      items-center
      justify-between
      px-2
      py-3
      navbar-expand-lg
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
        <router-link
          class="
            text-white text-sm
            font-bold
            leading-relaxed
            inline-block
            mr-4
            py-2
            whitespace-nowrap
            uppercase
          "
          to="/"
        >
          Rezervacije
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
          <i class="text-white fas fa-bars"></i>
        </button>
      </div>
      <div
        class="
          lg:flex
          flex-grow
          items-center
          bg-white
          lg:bg-opacity-0 lg:shadow-none
        "
        :class="[navbarOpen ? 'block rounded shadow-lg' : 'hidden']"
        id="example-navbar-warning"
      >
        <ul class="flex flex-col lg:flex-row list-none lg:ml-auto">
          <li class="flex items-center">
            <PagesDropdown />
          </li>

          <li class="flex items-center">
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
          <li class="flex items-center">
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
          <li class="flex items-center">
            <index-dropdown />
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script>
import PagesDropdown from "@/components/Dropdowns/PagesDropdown.vue";
export default {
  data() {
    return {
      navbarOpen: false,
    };
  },
  methods: {
    setNavbarOpen: function () {
      this.navbarOpen = !this.navbarOpen;
    },
  },
  components: {
    PagesDropdown,
  },
};
</script>
