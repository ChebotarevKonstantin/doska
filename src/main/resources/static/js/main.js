
var messageApi = Vue.resource('announcements{/id}');



//Vue.component('message-form', {
//props: ['messages'],
//data: function() {
//return {
//text: ''
////name: ''
//
//}
//},
//template:
//'<div>' +
//        '<input type="text" placeholder="Write text" v-model="text" />' +
////          '<input type="name" placeholder="Write name" v-model="name" />' +
//        '<input type="button" value="Save" v-on:click="save" />' +
// '</div>',
// methods: {
// save: function(){
// var message = { text: this.text };
////  var message = { name: this.name };
//
//
// messageApi.save({}, message).then(result =>
// result.json().then(data =>{
// this.messages.push(data);
// this.text = ''
////  this.name = ''
//
// })
// )
// }
// }
//});


Vue.component('message-form', {
props: ['messages'],
data: function() {
return {
//text: ''
name: ''

}
},
template:
'<div>' +
//        '<input type="text" placeholder="Write something" v-model="text" />' +
          '<input type="name" placeholder="Write name" v-model="name" />' +
        '<input type="button" value="Save" v-on:click="save" />' +
 '</div>',
 methods: {
 save: function(){
// var message = { text: this.text };
  var message = { name: this.name };


 messageApi.save({}, message).then(result =>
 result.json().then(data =>{
 this.messages.push(data);
// this.text = ''
  this.name = ''

 })
 )
 }
 }
});










Vue.component('message-row', {
props: ['message'],
template:'<div><i>({{ message.id }})</i> {{ message.name}}</div>'
});

Vue.component('messages-list', {
props: ['messages'],
template:
'<div>' +
    '<message-form :messages="messages" />' +
    '<message-row v-for="message in messages" :key="message.id" :message="message"' +
'/></div>',
created: function(){
messageApi.get().then(result =>
    result.json().then(data =>
    data.forEach(message => this.messages.push(message))
    )

)
}
});

var app = new Vue({
      el: '#app',
      template: '<messages-list :messages="messages" />',
      data: {
        messages: []
      }
    });



