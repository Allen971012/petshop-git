var x = 0;
var y = 0;

//獲得鼠標位置
$(document).mousemove(function(e){
    x = e.pageX;
    y = e.pageY;
})

function shoppingCartTrigger(){

    if(detectMousePosition(x,y)){   //將鼠標xy傳給detectMousePosition方法,範圍內返回true,結束此方法
        return;
    }
    $(".shoppinglist").css("display","none");  //若返回false 表示超出範圍 隱藏購物車

}

var shoppingCartTimer = window.setInterval(shoppingCartTrigger,3000);

window. addEventListener('popstate', function (event) {

    clearInterval(shoppingCartTimer);
});


