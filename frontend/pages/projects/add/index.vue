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
      <span>Projects</span>
      <img src="~assets/arrow-right.svg" alt="">
      <span class="active">New project</span>
    </div>
    <div class="add-wrapper">
      <div class="add-title">
        <img src="~assets/edit_active.svg" alt="">
        <h1>New project</h1>
      </div>
      <div class="add-inputs-wrapper">
        <span>Name</span>
        <div class="add-inputs">
          <input type="text" name="" id="" placeholder="Name">
          <div class="button">
            <img src="~assets/add.svg" alt="">
            <span>Add</span>
          </div>
        </div>
      </div>
    </div>
    <div class="projects-wrapper">
      <h1 class="title">Your projects</h1>
      <div class="list-wrapper">
        <ul class="list">
          <li class="element" v-for="item in items" v-bind:key="item.id">
            <div class="project-data">
              <span class="id">{{ item.id }}</span>
              <span class="name">Project 1</span>
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

<style lang="sass">
  @import 'styles/style'
</style>
