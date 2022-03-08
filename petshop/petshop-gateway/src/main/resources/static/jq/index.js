/*
* 輪播圖
*/
var imgw = 850;
$(".ads_img>img").each(function(i){
    $(this).css("left",i*imgw+"px");
});

//計時器:圖片移動速度
function change() {
    var timer = setInterval(function () {
        $(".ads_img>img").each(function () {
            //獲得原本的left
            var oldleft = parseInt($(this).css("left"));
            oldleft -= 10;
            //圖片到-imgw移動到2*imgw
            if (oldleft <= -imgw) {
                oldleft = 2 * imgw;
                clearInterval(timer);
            }
            $(this).css("left", oldleft + "px");
        });
    }, 10);
}

//每隔2秒調用換圖片
var changeimg = setInterval(change,5000);

//鼠標移入移出事件
$(".ads_img>img").each(function(){
    $(this).hover(function(){
        clearInterval(changeimg);
    },function(){
        clearInterval(changeimg);
        changeimg = setInterval(change,5000);
    });
});

//聚焦失焦事件
onblur = function(){
    clearInterval(changeimg);
}
onfocus = function(){
    clearInterval(changeimg);
    changeimg = setInterval(change,5000);
}

//點擊首頁查看更多轉到對應網頁
function goPP(num){
    switch(num){
        case 1:
            location.href = '/product.html?populars';
            break;
        case 2:
            location.href = '/promotion_product.html';
            break;
    }
}


































