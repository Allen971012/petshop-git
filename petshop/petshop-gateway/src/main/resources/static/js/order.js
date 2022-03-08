let orderApp = new Vue({
    el:'#orderApp',
    data:{
        products:[],
        total:0
    },
    methods:{
        //加載該用戶購物車內商品
        loadShoppingList:function(){
            $.ajax({
                url:'/product/v1/userCart/select',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        orderApp.products = r.data;
                        orderApp.totalPrice();
                    }
                }
            });
        },
        //計算總價
        totalPrice:function(){
            var total = 0;
            var i = 0;
            orderApp.products.forEach(function(product,index){
                var temPrice = product.price == null ? product.oprice : product.price;
                total += temPrice*product.count;
                Vue.set(product,'onePrice',temPrice*product.count);
            })
            orderApp.total = total;
        }
    },
    created:function(){
        this.loadShoppingList();
    }
});