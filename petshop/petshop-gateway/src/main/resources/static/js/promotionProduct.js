let promotionProductApp = new Vue({
    el:'#promotionProductApp',
    data:{
        products:[],
        pageInfo:{}
    },
    methods:{
        loadAllPromotionProducts(pageNum){
            if(pageNum==null){
                pageNum = 1;
            }
            $.ajax({
                url:'/product/v1/promotion/all',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        promotionProductApp.products = r.data.list;
                        promotionProductApp.pageInfo = r.data;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadAllPromotionProducts(1);
    }
});