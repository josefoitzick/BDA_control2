<template>
    <form @submit.prevent="submit">
      <h1 class="h3 mb-3 fw-normal">Crea tu cuenta!</h1>
  
      
      <input v-model="username" class="form-control" placeholder="Apodo" required>
      <input v-model="firstname" class="form-control" placeholder="Nombre" required>
      <input v-model="lastname" class="form-control" placeholder="Apellido" required>
      <input v-model="password" type="password" class="form-control" placeholder="Contraseña" required>

      
  
      <button class="w-100 btn btn-lg btn-primary" type="submit">Crear cuenta</button>
    </form>
  </template>
  
  <script>
  export default {
    name: "register",
    data() {
      return {
        username: '',
        firstname:'',
        lastname: '',
        password: '',
        country:'Chile'
      }
    },
    methods: {
      async submit() {
        await fetch('http://localhost:8080/auth/register', {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify({
            username:this.username,
            firstname:this.firstname,
            lastname:this.lastname,
            password:this.password,
            country:this.country
          })
        });
  
        await this.$router.push('/login');
      }
    }
  }
  </script>