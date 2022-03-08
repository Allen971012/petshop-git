let registerApp = new Vue({
    el:'#registerApp',
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
        register:function(){
            let data = {
                username:this.username,
                password:this.password,
                confirm:this.confirm,
                email:this.email,
                phone:this.phone
            }
            console.log(data);
            if(data.password!==data.confirm){
                this.message='確認密碼不一致';
                this.type = 1;
                return;
            }
            let _this = this;
            $.ajax({
                url:'/sys/v1/users/register',
                method:'POST',
                data:data,
                success:function(r){
                    if(r.code === CREATED){
                        console.log(r.message);
                        _this.type = 0;
                        location.href = '/register.html?register';
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