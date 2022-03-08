
let productSpeciesApp = new Vue({
    el:'#productSpeciesApp',
    data:{
        foods:[],
        snacks:[],
        cans:[],
        toys:[],
        pretties:[],
        outdoors:[]
    },
    methods:{
        toPromise:function(){
            let species = location.search;
            if(!species){
                console.log('必須指定species');
                return;
            }
            species = species.substring(1);
            console.log(species);
            var f1 = new Promise(function(resolve, reject) {
                $.ajax({
                    url:'/product/v1/product/food/'+species,
                    method:'GET',
                    success:function(r){
                        if(r.code===OK){
                            productSpeciesApp.foods = r.data;
                        }
                    }
                });
            });
            var f2 = new Promise(function(resolve, reject) {
                $.ajax({
                    url:'/product/v1/product/snack/'+species,
                    method:'GET',
                    success:function(r){
                        if(r.code===OK){
                            productSpeciesApp.snacks = r.data;
                        }
                    }
                });
            });
            var f3 = new Promise(function(resolve, reject) {
                $.ajax({
                    url:'/product/v1/product/can/'+species,
                    method:'GET',
                    success:function(r){
                        if(r.code===OK){
                            productSpeciesApp.cans = r.data;
                        }
                    }
                });
            });
            var f4 = new Promise(function(resolve, reject) {
                $.ajax({
                    url:'/product/v1/product/toy/'+species,
                    method:'GET',
                    success:function(r){
                        if(r.code===OK){
                            productSpeciesApp.toys = r.data;
                        }
                    }
                });
            });
            var f5 = new Promise(function(resolve, reject) {
                $.ajax({
                    url:'/product/v1/product/pretty/'+species,
                    method:'GET',
                    success:function(r){
                        if(r.code===OK){
                            productSpeciesApp.pretties = r.data;
                        }
                    }
                });
            });
            var f6 = new Promise(function(resolve, reject) {
                $.ajax({
                    url:'/product/v1/product/outdoor/'+species,
                    method:'GET',
                    success:function(r){
                        if(r.code===OK){
                            productSpeciesApp.outdoors = r.data;
                        }
                    }
                });
            });
            Promise.all([f1,f2,f3,f4,f5,f6]);
        }
    },
    created:function(){
        this.toPromise();
    }
});
