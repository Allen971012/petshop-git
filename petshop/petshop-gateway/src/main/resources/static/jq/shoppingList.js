// -號算法
$(".span1").click(function(){
    var count = $(".count input").val();
    if(count==1){
        count = 1;
    }else{
        count--;
    }
    $(".count input").val(count);
});

//加號算法
$(".span2").click(function(){
    var count = $(".count input").val();
    count++;
    $(".count input").val(count);
});

// -號算法
$(".span3").click(function(){
    var count = $(".count_big input").val();
    if(count==1){
        count = 1;
    }else{
        count--;
    }
    $(".count_big input").val(count);
});

//加號算法
$(".span4").click(function(){
    var count = $(".count_big input").val();
    count++;
    $(".count_big input").val(count);
});

//鼠標懸停顯示購物清單
$(".header_right>a").mouseover(function(){
    $(".shoppinglist").css("display","block");
    shoppingListApp.loadShoppingList();
});


function detectMousePosition(x,y){
    var div = $(".shoppinglist");
    var y1 = div.offset().top;  //div上面兩個的點的y值
    var y2 = y1 + div.height();//div下面兩個點的y值
    var x1 = div.offset().left;  //div左邊兩個的點的x值
    var x2 = x1 + div.width();  //div右邊兩個點的x的值
    if( x < x1 || x > x2 || y<y1-60 || y > y2){
        return false;
    }
    return true;
}
//鼠標移入用戶把購物清單隱藏
$("#userInfoApp").mouseover(function(){
    console.log("into user div,display=none");
    $(".shoppinglist").css("display","none");
});







