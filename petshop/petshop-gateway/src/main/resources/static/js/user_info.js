let userInfoApp = new Vue({
    el:'#userInfoApp',
    data:{
      username:''
    },
    methods:{
        //顯示當前用戶名
        loadCurrentName:function(){
            $.ajax({
                url:'/sys/v1/users/getname',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        userInfoApp.username = r.message;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadCurrentName();
    }
});