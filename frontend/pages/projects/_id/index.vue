<template>
  <div class="container">
    <div class="nav-bar">
      <div class="icons">
        <div class="user-icon">
          <div class="user">
            <img src="~assets/comp.svg" alt="">
            <span>User</span>
          </div>
          <div class="projects">
            <img src="~assets/edit_active.svg" alt="">
            <span>Projects</span>
          </div>
        </div>
      </div>
      <div class="logged-in">
        <span class="login">User</span>
        <div class="down_arrow">
          <img src="~assets/arrow_down.svg" alt="">
        </div>
      </div>
    </div>
    <div class="route-history">
      <nuxt-link to="/projects"><span>Projects</span></nuxt-link>
      <img src="~assets/arrow-right.svg" alt="">
      <span class="active">Project 1</span>
    </div>
    <div class="search-wrapper">
      <h1 class="search-title">Search</h1>
      <div class="search-inputs">
        <input type="text" name="" id="" placeholder="Search">
        <button>Search</button>
      </div>
    </div>
    <div class="projects-wrapper">
      <h1>Project {{ this.$route.params.id }} measurments</h1>
      <div class="list-wrapper">
        <ul class="list">
          <li class="element" v-for="item in items" v-bind:key="item.id">
            <div class="project-data">
              <span class="id">1</span>
              <span class="name">Measurment 1</span>
            </div>
            <div class="buttons">
              <div class="edit">
                <img src="~assets/edit_active.svg" alt="">
                <span>Edit</span>
              </div>
              <div class="remove">
                <img src="~assets/delete.svg" alt="">
                <span>Remove</span>
              </div>
            </div>
          </li>
        </ul>
      </div>
      <div class="button-add-wrapper">
        <nuxt-link to="/projects/add">
        <div class="button">
          <img src="~assets/add.svg" alt="">
          <span>Add</span>
        </div>
        </nuxt-link>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  data () {
    return { items: [{id:1},{id:2},{id:3},{id:4},{id:5},{id:6}] }
  },
  components: {
  }
}
</script>

<style lang="sass" scoped>
@import './styles/style'
</style>
