<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset">
      <b-form-group
        label="Email address:"
        >
        <b-form-input
          v-model="form.email"
          type="email"
          placeholder="Enter email"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        label="Password:"
        >
        <b-form-input
          v-model="form.password"
          type="password"
          placeholder="Password"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        label="Address:"
        >
        <b-form-input
          v-model="form.address"
          placeholder="Address"
          required
        ></b-form-input>
      </b-form-group>

      <b-button variant="primary">Sign up</b-button>
    </b-form>
  </div>
</template>

<script>
export default {
  name: "Registration",
  data() {
      return {
        form: {
          email: '',
          password: '',
          address: ''
        }
      }
  },
  methods: {
      onSubmit(event) {
        event.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(event) {
        event.preventDefault()
        this.form.email = ''
        this.form.password = ''
        this.form.address = ''
      }
    }
}
</script>