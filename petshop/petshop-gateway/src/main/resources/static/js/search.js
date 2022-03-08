let searchProductApp = new Vue({
    el:'#searchProductApp',
    data:{
        products:[],
        pageInfo:{}
    },
    methods:{
        loadProductBySearch:function(pageNum){
            if(!pageNum){
                pageNum = 1;
            }
            let title = location.search;
            if(!title){
                return;
            }
            if(!title.startsWith("?title=")){
                return;
            }
            title = decodeURI(title.substring("?title=".length));
            console.log('title:'+title);
            $.ajax({
                url:'/search/v1/commodity',
                method:'POST',
                data:{
                    title:title,
                    pageNum:pageNum
                },
                success:function(r){
                    if(r.code===OK){
                        console.log("搜尋結果加載成功");
                        console.log(r.data.list);
                        searchProductApp.products = r.data.list;
                        searchProductApp.pageInfo = r.data;
                    }else{
                        console.log('搜尋結果加載失敗');
                    }
                }
            });
        }
    },
    mounted:function(){
        this.loadProductBySearch(1);
    }
});