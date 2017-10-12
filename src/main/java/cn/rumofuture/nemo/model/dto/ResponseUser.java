package cn.rumofuture.nemo.model.dto;

import cn.rumofuture.nemo.model.domain.User;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public class ResponseUser {

    private static final int SUCCESS = 1;
    private static final int ERROR = 0;

    private int status;
    private String message;
    private User user;

    public ResponseUser(boolean isSuccess, String message, User user) {
        if (isSuccess) {
            this.status = SUCCESS;
        } else {
            this.status = ERROR;
        }
        this.message = message;
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
