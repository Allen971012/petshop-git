package home.petshop.commons.vo;

import home.petshop.commons.service.ServiceException;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int NO_CONTENT = 204;
    public static final int INVALID_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int GONE = 410;
    public static final int UNPROCESABLE_ENTITY = 422;
    public static final int INTERNAL_SERVER_ERROR = 500;

    private int code;
    private String message;
    private T data;

    public static R ok(String message){
        return new R().setMessage(message).setCode(OK);
    }

    public static R ok(Object data){
        return new R().setMessage("OK").setCode(OK).setData(data);
    }

    public static R created(String message){
        return new R().setMessage(message).setCode(CREATED);
    }

    public static R accepted(String message){
        return new R().setMessage(message).setCode(ACCEPTED);
    }

    public static R noContent(String message){
        return new R().setMessage(message).setCode(NO_CONTENT);
    }

    public static R invalidRequest(String message){
        return new R().setMessage(message).setCode(INVALID_REQUEST);
    }

    public static R unauthorized(String message){
        return new R().setMessage(message).setCode(UNAUTHORIZED);
    }

    public static R forbidden(String message){
        return new R().setMessage(message).setCode(FORBIDDEN);
    }

    public static R notFound(String message){
        return new R().setMessage(message).setCode(NOT_FOUND);
    }

    public static R gone(String message){
        return new R().setMessage(message).setCode(GONE);
    }

    public static R unprocesableEntity(String message){
        return new R().setMessage(message).setCode(UNPROCESABLE_ENTITY);
    }

    public static R failed(Throwable e){
        return new R().setCode(INTERNAL_SERVER_ERROR).setMessage(e.getMessage());
    }

    public static R failed(ServiceException e){
        return new R().setCode(e.getCode()).setMessage(e.getMessage());
    }
}
