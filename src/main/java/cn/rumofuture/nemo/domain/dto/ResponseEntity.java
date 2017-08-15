package cn.rumofuture.nemo.domain.dto;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public class ResponseEntity {

    private Integer code;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
