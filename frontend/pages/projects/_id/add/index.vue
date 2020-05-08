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
      <span class="">Project {{ this.$route.params.id }}</span>
      <img src="~assets/arrow-right.svg" alt="">
      <span class="active">New measurment</span>
    </div>
    <div class="add-wrapper">
      <div class="add-title">
        <img src="~assets/edit_active.svg" alt="">
        <h1>New measurment</h1>
      </div>
      <div class="add-title-project">
        <span>Project {{ this.$route.params.id }}</span>
      </div>
      <div class="add-inputs-wrapper">
        <div class="col1"> 

          <div class="single-input">
            <span>Name</span>
            <div class="add-inputs">
              <input type="text" name="" placeholder="Name">
            </div>
          </div>

          <div class="single-input">
            <span>Value</span>
            <div class="add-inputs">
              <input type="text" name="" placeholder="Value">
            </div>
          </div>

          <div class="single-input">
            <span>Unit</span>
            <div class="add-inputs">
              <input type="text" name="" placeholder="Unit">
            </div>
          </div>
          
        </div>
        <div class="col2">
          <div class="single-input">
            <span>Description</span>
            <div class="add-inputs">
              <textarea name="" placeholder="Description"></textarea>
              <div class="button">
                <img src="~assets/add.svg" alt="">
                <span>Add</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="projects-wrapper">
      <h1 class="title">Project measurments</h1>
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
              <div class="remove" @click="alertDisplay">
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
      return {
        items: [{id:1},{id:2},{id:3}],
        deleted: 1,
        test: 10
        }
    },
    components: {
    },
    methods: {
      alertDisplay() {
        this.$swal({
          title: 'Are you sure?',
          text: 'You can\'t revert your action',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Yes Delete it!',
          cancelButtonText: 'No, Keep it!',
          showCloseButton: true
        }).then((result) => {
          console.log(result)
          if(result.value) {
            // this.$swal('Deleted', 'You successfully deleted this file', 'success')
            this.$swal({
              toast: true,
              position: 'top-end',
              showConfirmButton: false,
              timer: 3000,
              icon: 'success',
              title: 'Success',
            });
          } else {
            this.$swal('Cancelled', 'Your file is still intact', 'info')
          }
        })
      }
    }
  }
</script>

<style lang="sass" scoped>
@import './styles/style'
</style>
