package cn.rumofuture.nemo.model.dto;

import cn.rumofuture.nemo.model.domain.User;

import java.util.List;

public class ResponseUserList {

    private int status;
    private String message;
    private List<User> user;

    public ResponseUserList(boolean isSuccess, String message, List<User> user) {
        if (isSuccess) {
            this.status = SUCCESS;
        } else {
            this.status = ERROR;
        }
        this.message = message;
        this.user = user;
    }

    private static final int SUCCESS = 1;
    private static final int ERROR = 0;

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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
