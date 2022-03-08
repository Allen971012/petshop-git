let insertOrderApp = new Vue({
    el:'#insertOrderApp',
    data:{
        phone:'',
        city:'',
        district:'',
        detail:'',
    },
    methods:{
        addOrder:function(){
            var zipcode = document.getElementById("zipcode").value;
            console.log('zipcode:'+zipcode);
            let data = {
                phone:this.phone,
                city:this.city,
                district:this.district,
                detail:this.detail,
                zipcode:zipcode
            }
            console.log(data);
            $.ajax({
                url:'/order/v1/order/add',
                method:'POST',
                data:data,
                success:function(r){
                    if(r.code===OK){
                        console.log(r.message);
                        alert('訂單已成立,前往確認訂單');
                        location.href = '/orderdetail.html?'+r.message;
                    }else{
                        alert('訂單成立失敗');
                        console.log('訂單建立失敗');
                    }
                }
            });
        }
    }
});