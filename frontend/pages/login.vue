<template>
    <form @submit.prevent="submit">
      <h1 class="h3 mb-3 fw-normal">Inicia sesión</h1>
  
      <input v-model="username" type="text" class="form-control" placeholder="Nombre de usuario" required>
  
      <input v-model="password" type="password" class="form-control" placeholder="Contraseña" required>
  
      <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
    </form>
  </template>
  
  <script>
  export default {
    name: "login",
    data() {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      async submit() {
        await fetch('http://localhost:8000/auth/login', {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          credentials:'include',
          body: JSON.stringify({
            username: this.username,
            password: this.password
          })
        });
  
        await this.$router.push('/');
      }
    }
  }
  </script>