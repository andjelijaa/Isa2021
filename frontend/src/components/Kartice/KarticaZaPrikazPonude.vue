<template>
   <div class="card" style="width: 18rem">
    <img class="card-img-top" src="https://www.slikomania.rs/fotky6509/fotos/XOBFB576E1.jpg" alt="Card image cap" />
    <div class="card-body">
      <h5 class="card-title">{{name}}</h5>
      <p class="card-text">
       {{text}}
      </p>
      <a href="#" class="btn btn-primary">Pogledaj ponudu</a>
    </div>
    </div>
</template>
<script>
  export default {
    props: ["name", "id", "text","src"]
  };
  </script>