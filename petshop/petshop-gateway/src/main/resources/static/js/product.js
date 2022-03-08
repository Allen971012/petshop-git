let productTypeApp = new Vue({
    el:'#productTypeApp',
    data:{
        products:[],
        pageInfo:{}
    },
    methods:{
        loadProductByType:function(pageNum){
            if(pageNum==null){
                pageNum = 1;
            }
            let type = location.search;
            if(!type){
                console.log('必須指定type');
                return;
            }
            type = type.substring(1);
            console.log(type);
            $.ajax({
                url:'/product/v1/product/'+type,
                method:'GET',
                data:{
                    pageNum:pageNum
                },
                success:function(r){
                    if(r.code===OK){
                        console.log("product執行了");
                        console.log(r.data);
                        console.log(r.data.list);
                        productTypeApp.products = r.data.list;
                        productTypeApp.pageInfo = r.data;
                    }
                }
            });
        },
        hideOprice:function(){
            var p = location.search;
            if(p === "?promotion"){
                console.log("顯示");
                $(".hideOprice").show();
            }
        }
    },
    updated(){
      if($(".hideOprice".length != 0)){
        productTypeApp.hideOprice();
      }
    },
    created:function(){
        this.loadProductByType(1);
    }
});