let selectOrderApp = new Vue({
    el:'#selectOrderApp',
    data:{
        orderNum:'',
        message:''
    },
    methods:{
        //查詢是否有此訂單,有的話重定向至訂單詳情
        selectOrderDetail:function(){
            console.log('執行selectOrderDetail()');
            let data = {
                orderNum:this.orderNum
            }
            console.log(data);
            $.ajax({
                url:'/order/v1/order/select',
                method:'POST',
                data:data,
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        selectOrderApp.orderNum = r.data.orderNum;
                        location.href='/orderdetail.html?'+selectOrderApp.orderNum;
                    }else{
                        console.log(r.message);
                        selectOrderApp.message = r.message;
                    }
                }
            });
            return false;
        }
    }
});

