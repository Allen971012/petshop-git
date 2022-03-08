//顯示熱門商品
let popularProductApp = new Vue({
    el:'#popularProductApp',
    data:{
        products:[]
    },
    methods:{
        loadPopularProduct:function(){
            $.ajax({
                url:'/product/v1/product/popular',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        popularProductApp.products = r.data;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadPopularProduct();
    }
});

//顯示特價商品
let promotionProductApp = new Vue({
    el:'#promotionProductApp',
    data:{
      promotions:[]
    },
    methods:{
        loadPromotionProduct:function(){
            $.ajax({
                url:'/product/v1/promotion',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        promotionProductApp.promotions = r.data;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadPromotionProduct();
    }
});

















