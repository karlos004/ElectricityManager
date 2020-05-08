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
      <nuxt-link :to="{ path: `/projects/${this.$route.params.id}` }"><span class="">Project {{ this.$route.params.id }}</span></nuxt-link>
      <img src="~assets/arrow-right.svg" alt="">
      <span class="active">Measurment {{ this.$route.params.mesid}}</span>
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
  </div>
</template>

<script>

  export default {
    validate ({ params }) {
    // Must be a number
    return /^\d+$/.test(params.mesid)
    },
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
