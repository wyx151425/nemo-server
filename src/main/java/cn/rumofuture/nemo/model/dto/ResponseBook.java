package cn.rumofuture.nemo.model.dto;

import cn.rumofuture.nemo.model.domain.Book;
import cn.rumofuture.nemo.model.domain.Page;

public class ResponseBook {

    private static final int SUCCESS = 1;
    private static final int ERROR = 0;

    private int status;
    private String message;
    private Book book;

    public ResponseBook(boolean isSuccess, String message, Book book) {
        if (isSuccess) {
            this.status = SUCCESS;
        } else {
            this.status = ERROR;
        }
        this.message = message;
        this.book = book;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
