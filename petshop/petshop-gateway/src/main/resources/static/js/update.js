let updateApp = new Vue({
    el:'#updateApp',
    data:{
        username:'',
        password:'',
        confirm:'',
        email:'',
        phone:'',
        type:0,
        message:''
    },
    methods:{
        update:function(){
            let data = {
                username:this.username,
                password:this.password,
                confirm:this.confirm,
                email:this.email,
                phone:this.phone,
            }
            console.log(data);
            if(data.password!==data.confirm){
                this.message='確認密碼不一致';
                this.type = 1;
                return;
            }
            let _this = this;
            $.ajax({
                url:'/sys/v1/users/update',
                method:'POST',
                data:data,
                success:function(r){
                    if(r.code===OK) {
                        console.log(r.message);
                        location.href = '/login.html';
                    }else{
                        console.log(r.message);
                        _this.type = 1;
                        _this.message = r.message;
                    }
                }
            });
        }
    }
});