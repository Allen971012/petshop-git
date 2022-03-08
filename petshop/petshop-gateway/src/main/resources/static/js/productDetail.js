let productDetailApp = new Vue({
    el:'#productDetailApp',
    data:{
        product:{}
    },
    methods:{
      loadProductDetail:function(){
          var id = location.search;
          if(!id){
              return;
          }
          id = id.substring(1);
          console.log(id);
          $.ajax({
              url:'/product/v1/product/detail/'+id,
              method:'GET',
              success:function (r){
                  if(r.code===OK){
                      console.log(r.data);
                      productDetailApp.product = r.data;
                  }
              }
          });
      },
      isLogin:function(){
          $.ajax({
              url:'/sys/v1/users/isLogin',
              method:'GET',
              success:function(r){
                  if(r.code===OK){
                      alert('已經登入');
                  }else{
                      alert('請先登入會員');
                      location.href = '/login.html';
                  }
              }
          });
      },
      isLoginForAdd:function(){
          $.ajax({
              url:'/sys/v1/users/isLogin',
              method:'GET',
              success:function(r){
                  if(r.code===OK){
                      productDetailApp.addShoppingCart();
                  }else{
                      alert('請先登入會員');
                      location.href = '/login.html';
                  }
              }
          });
      },
      //加入購物車
      addShoppingCart:function(){
          //獲得商品id
          var productId = location.search;
          if(!productId){
              return;
          }
          productId = productId.substring(1);
          console.log(productId);
          //獲得商品數量
          var count = $(".counttext").val();
          //數據對象
          var data ={
              productId:productId,
              count:count
          }
          $.ajax({
              url: '/product/v1/userCart/add',
              method: 'GET',
              data: data,
              success: function (r) {
                  if (r.code === OK) {
                      console.log(r.message);
                      //加載購物車清單並彈出
                      shoppingListApp.loadShoppingList();
                  } else {
                      alert(r.message);
                  }
              }
          });
      },
      addClickCount:function(){
          var id = location.search;
          if(!id){
              return;
          }
          id = id.substring(1);
          $.ajax({
              url:'/product/v1/product/addClickCount/'+id,
              method:'GET',
              success:function(r){
                  if(r.code===OK){
                      console.log(r.message);
                  }else{
                      console.log(r.message);
                  }
              }
          });
      }
    },
    created:function(){
        this.loadProductDetail();
        this.addClickCount();
    }
});