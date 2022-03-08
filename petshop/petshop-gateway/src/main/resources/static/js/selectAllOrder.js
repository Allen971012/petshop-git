let selectAllOrderApp = new Vue({
    el:'#selectAllOrderApp',
    data:{
        username:'',
        phone:'',
        message:'',
        type:0,
        table:0,
        orderNums:[]
    },
    methods:{
        //查出所有訂單編號
        selectAllOrder:function() {
            let data = {
                username:this.username,
                phone:this.phone
            }
            console.log(data);
            $.ajax({
                url:'/order/v1/order/selectAllOrder',
                method:'post',
                data:data,
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        console.log(r.data);
                        selectAllOrderApp.table = 1;
                        selectAllOrderApp.orderNums = r.data;
                    }else{
                        console.log(r.message);
                        selectAllOrderApp.type = 1;
                        selectAllOrderApp.message = r.message;
                    }
                }
            });
        },
        //根據訂單編號刪除訂單
        deleteOrder:function(orderNum){
            var b = confirm('確認刪除訂單('+orderNum+')');
            if(b===false){
                return;
            }
            $.ajax({
                url:'/order/v1/order/delete/'+orderNum,
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        selectAllOrderApp.orderNums.forEach(function(num,index){
                            if(orderNum===num){
                                selectAllOrderApp.orderNums.splice(index,1);
                            }
                        })
                    }else{
                        console.log(r.message);
                    }
                }
            });
        }
    }
});