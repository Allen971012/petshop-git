/*
根據不同物種傳遞不同參數
 */
function goto(_this){
    var text = $($(_this)).text();
    if(text==="狗狗商品"){
        location.href = '/products.html?dog';
    }else if(text==="貓貓商品"){
        location.href = '/products.html?cat';
    }
}

/*
點擊首頁時判斷用戶是否登入轉發不同index
 */
function gotoIndex(){
    $.ajax({
        url:'/sys/v1/users/isLogin',
        method:'GET',
        success:function(r){
            if(r.code===OK){
                console.log('已登入,轉到index_user');
                location.href='/index_user.html';
            }else{
                console.log('已登入,轉到index');
                location.href='/index.html';
            }
        }
    });
}



/*
根據不同標籤傳遞不同參數
 */
function go(_this){
    var btext = $($(_this).children()).text();
    if(btext==="飼料"){
        location.href = '/product.html?food';
    }else if(btext==="零食"){
        location.href = '/product.html?snack';
    }else if(btext==="罐罐"){
        location.href = '/product.html?can';
    }else if(btext==="玩具"){
        location.href = '/product.html?toy';
    }else if(btext==="美容護理"){
        location.href = '/product.html?pretty';
    }else if(btext==="外出用品"){
        location.href = '/product.html?outdoor';
    }
}

/*
判斷是否登入,若已經登入隱藏"登入"和"註冊"
 */
function hide(){
    $.ajax({
        url:'/sys/v1/users/isLogin',
        method:'GET',
        success:function(r){
            if(r.code===OK){
                console.log('已登入,隱藏登入按鈕');
                $(".hideRL").attr("style","display:none");
            }else{
                console.log('尚未登入,顯示登入按鈕');
            }
        }
    });
}
hide();


