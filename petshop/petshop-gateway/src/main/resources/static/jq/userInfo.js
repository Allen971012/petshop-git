//如果沒有登入,隱藏會員資料欄位
function hideUserInfo(){
    $.ajax({
        url:'/sys/v1/users/isLogin',
        method:'GET',
        success:function(r){
            if(r.code===OK){
                console.log('有登入');
                $(".hideUserInfo").attr("style","");
            }
        }
    });
}
hideUserInfo();


