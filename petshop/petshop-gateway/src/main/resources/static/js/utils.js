/*
通用Code
 */

let OK = 200;
let CREATED = 201;
let ACCEPTED = 202;
let NO_CONTENT = 204;
let INVALID_REQUEST = 400;
let UNAUTHORIZED = 401;
let FORBIDDEN = 403;
let NOT_FOUND = 404;
let GONE = 410;
let UNPROCESABLE_ENTITY = 422;
let INTERNAL_SERVER_ERROR = 500;

/*
持續時間方法
 */
function addDuration(item){
    if(!item || !item.createtime){
        return;
    }
    //取出問題創建時間(毫秒)
    let createtime = new Date(item.createtime).getTime();
    //取出瀏覽器當前時間(毫秒)
    let now = new Date().getTime();
    //算出時間差
    let duration = now-createtime;
    //計算各時間顯示
    if(duration<1000*60){
        item.duration = '剛剛';
    }else if(duration<1000*60*60){
        item.duration = (duration/1000/60).toFixed(0)+'分鐘前';
    }else if(duration<1000*60*60*24){
        item.duration = (duration/1000/60/60).toFixed(0)+'小時前';
    }else{
        item.duration = (duration/1000/60/60/24).toFixed(0)+'天前';
    }
}