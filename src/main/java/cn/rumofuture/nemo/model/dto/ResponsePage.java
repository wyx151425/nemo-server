package cn.rumofuture.nemo.model.dto;

import cn.rumofuture.nemo.model.domain.Page;

public class ResponsePage {

    private static final int SUCCESS = 1;
    private static final int ERROR = 0;

    private int status;
    private String message;
    private Page page;

    public ResponsePage(boolean isSuccess, String message, Page page) {
        if (isSuccess) {
            this.status = SUCCESS;
        } else {
            this.status = ERROR;
        }
        this.message = message;
        this.page = page;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
