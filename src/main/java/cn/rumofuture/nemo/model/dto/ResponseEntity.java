package cn.rumofuture.nemo.model.dto;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public class ResponseEntity<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponseEntity(boolean success, String message, T data) {
        if (success)
            this.code = SUCCESS;
        else
            this.code = FAILED;
        this.message = message;
        this.data = data;
    }

    public static final Integer SUCCESS = 1;
    public static final Integer FAILED = 0;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
