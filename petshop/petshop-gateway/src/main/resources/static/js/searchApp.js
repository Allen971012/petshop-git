let searchApp = new Vue({
    el:'#searchApp',
    data:{
        title:''
    },
    methods:{
        search:function(){
            location.href='/search.html?title='+encodeURI(this.title);
        }
    }
});