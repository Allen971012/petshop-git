let tagsApp = new Vue({
    el:'#tagsApp',
    data:{
        tags:[]
    },
    methods:{
        loadTags:function(){
            $.ajax({
                url:'/product/v1/tag',
                method:'GET',
                success:function(r){
                    if(r.code===OK){
                        console.log(r.data);
                        tagsApp.tags = r.data;
                    }
                }
            });
        }
    },
    created:function(){
        this.loadTags();
    }
});