//右側熱門商品
let rightPopularProductApp = new Vue({
    el:'#rightPopularProductApp',
    data:{
        products:[]
    },
    methods:{
        loadRightPopular:function(){
            $.ajax({
                url:'/product/v1/product/popular/right',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        rightPopularProductApp.products = r.data;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadRightPopular();
    }
});

//右側特價商品
let rightPromotionApp = new Vue({
    el:'#rightPromotionApp',
    data:{
        products:[]
    },
    methods:{
        loadRightPromotion:function(){
            $.ajax({
                url:'/product/v1/promotion/right',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        rightPromotionApp.products = r.data;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadRightPromotion();
    }
});

















