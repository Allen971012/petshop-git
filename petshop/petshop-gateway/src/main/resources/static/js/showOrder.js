let showOrderApp = new Vue({
    el:'#showOrderApp',
    data:{
        orderInfo:{},
        products:[],
        total:0
    },
    methods:{
        //查詢訂單資訊
        selectOrderDetail:function(){
            var url = location.href;
            if(url.includes('orderNum')) {
                console.log('selectOrderDetail() url包含orderNum');
                //取出參數orderNum
                if(url.indexOf('?')!=-1){
                    var orderNum = '';
                    var arr = url.split('?')[1].split('&');
                    for(i=0 ; i<=arr.length-1 ;i++){
                        if(arr[i].split('=')[0] == 'orderNum'){
                            orderNum = arr[i].split('=')[1];
                            console.log('orderNum:'+orderNum);
                        }
                    }
                }
            }else{
                console.log('selectOrderDetail() url不包含orderNum');
                var orderNum = location.search;
                if (!orderNum) {
                    return;
                }
                orderNum = orderNum.substring(1);
                console.log(orderNum);
            }
            $.ajax({
                url:'/order/v1/order/select/'+orderNum,
                method:'get',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        showOrderApp.orderInfo = r.data;
                        if(showOrderApp.orderInfo.payStatus===0){
                            showOrderApp.orderInfo.payStatus = '未付款';
                        }else{
                            showOrderApp.orderInfo.payStatus = '已付款';
                        }
                    }else{
                        console.log(r.message);
                    }
                }
            });
        },
        //查詢訂單商品內容
        selectOrderProduct:function(){
            var url = location.href;
            if(url.includes('orderNum')) {
                console.log('selectOrderProduct() url包含orderNum');
                //取出參數orderNum
                if(url.indexOf('?')!=-1){
                    var orderNum = '';
                    var arr = url.split('?')[1].split('&');
                    for(i=0 ; i<=arr.length-1 ;i++){
                        if(arr[i].split('=')[0] == 'orderNum'){
                            orderNum = arr[i].split('=')[1];
                            console.log('orderNum:'+orderNum);
                        }
                    }
                }
            }else{
                console.log('selectOrderProduct() url不包含orderNum');
                var orderNum = location.search;
                if (!orderNum) {
                    return;
                }
                orderNum = orderNum.substring(1);
                console.log(orderNum);
            }
            $.ajax({
                url:'/order/v1/order/selectOrderProduct/'+orderNum,
                method:'get',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        showOrderApp.products = r.data;
                        showOrderApp.totalPrice();
                    }else{
                        console.log(r.message);
                    }
                }
            });
        },
        //計算總價
        totalPrice:function(){
            var total = 0;
            showOrderApp.products.forEach(function(product,index){
                var temPrice = product.price*product.count;
                total += temPrice;
                Vue.set(product,'onePrice',temPrice);
            })
            showOrderApp.total = total;
        },
        //Paypal建立訂單
        payPalOrder:function(){
            var zipcode = showOrderApp.orderInfo.zipcode;
            var city = showOrderApp.orderInfo.city;
            var district = showOrderApp.orderInfo.district;
            var detail = showOrderApp.orderInfo.detail;
            var orderNum = showOrderApp.orderInfo.orderNum;
            var total = showOrderApp.total;
            console.log('zipcode:'+zipcode);
            console.log('city:'+city);
            console.log('district:'+district);
            console.log('detail:'+detail);
            console.log('orderNum:'+orderNum);
            console.log('total:'+total);
            if(!zipcode || !city || !district || !detail || !orderNum || !total){
                return;
            }
            $.ajax({
                url:'/paypal/v1/paypal/pay',
                method:'POST',
                data:{
                    zipcode,
                    city,
                    district,
                    detail,
                    orderNum,
                    total
                },
                success:function(r){
                    if(r.code===OK){
                        console.log("paypal建立訂單成功");
                        console.log(r.message);
                        location.href = r.message;
                    }else{
                        console.log("paypal建立訂單失敗");
                        console.log(r.message);
                    }
                }
            });
        },
        //捕獲訂單
        paypalCaptureOrder:function(){
            console.log('進入paypalCaptureOrder()');
            //http://localhost:8080/orderdetail.html?cada1a32-b0d3-44ea-91d4-d07650ddb560&token=95G81762SV6071706&PayerID=58ZMGF7YKE9YA
            var url = location.href;
            //取出參數token
            if(url.indexOf('?')!=-1){
                var orderId = '';
                var arr = url.split('?')[1].split('&');
                for(i=0 ; i<=arr.length-1 ;i++){
                    if(arr[i].split('=')[0] == 'token'){
                        orderId = arr[i].split('=')[1];
                        console.log('orderId:'+orderId);
                    }
                }
            }
            $.ajax({
                url:'/paypal/v1/paypal/capture',
                method:'get',
                data:{
                    orderId
                },
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        showOrderApp.updatePayStatus();
                        alert('Paypal付款成功');
                    }else{
                        console.log(r.message);
                    }
                }
            });
        },
        //判斷當前頁面是否包含token
        haveToken:function(){
            var url = location.href;
            console.log('當前網址:'+url);
            if(url.includes("token")){
                console.log('包含token');
                this.paypalCaptureOrder();
            }else{
                console.log('不包含token');
            }
        },
        //paypal付款成功後將付款狀態改成1(已付款)
        updatePayStatus:function(){
            var url = location.href;
            if(url.includes('orderNum')) {
                console.log('selectOrderProduct() url包含orderNum');
                //取出參數orderNum
                if(url.indexOf('?')!=-1){
                    var orderNum = '';
                    var arr = url.split('?')[1].split('&');
                    for(i=0 ; i<=arr.length-1 ;i++){
                        if(arr[i].split('=')[0] == 'orderNum'){
                            orderNum = arr[i].split('=')[1];
                            console.log('orderNum:'+orderNum);
                        }
                    }
                }
            }
            $.ajax({
                url:'/paypal/v1/paypal/updatePayStatus',
                method:'GET',
                data:{
                    orderNum
                },
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        showOrderApp.orderInfo.payStatus = '已付款';
                    }else{
                        console.log(r.message);
                    }
                }

            });
        }
    },
    created:function(){
        this.selectOrderDetail();
        this.selectOrderProduct();
    },
    mounted:function(){
        this.haveToken();
    }
});