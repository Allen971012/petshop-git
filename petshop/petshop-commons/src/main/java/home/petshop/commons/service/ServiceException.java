package home.petshop.commons.service;

import home.petshop.commons.vo.R;

public class ServiceException extends RuntimeException{

    private int code = R.INTERNAL_SERVER_ERROR;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(int code) {
        this.code = code;
    }

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public static ServiceException invalidRequest(String message){
        return new ServiceException(message,R.INVALID_REQUEST);
    }

    public static ServiceException notFound(String message){
        return new ServiceException(message,R.NOT_FOUND);
    }

    public static ServiceException gone(String message){
        return new ServiceException(message,R.GONE);
    }

    public static ServiceException unAuthorized(String message){
        return new ServiceException(message,R.UNAUTHORIZED);
    }
    /*
    收到的表單數據,無法進行保存處理
     */
    public static ServiceException unprocesableEntity(String message){
        return new ServiceException(message,R.UNPROCESABLE_ENTITY);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
