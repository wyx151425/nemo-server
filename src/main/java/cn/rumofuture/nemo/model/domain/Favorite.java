package cn.rumofuture.nemo.model.domain;

import java.io.Serializable;

/**
 * Created by WangZhenqi on 2017/4/18.
 */

public class Favorite implements Serializable {

    private Book book;
    private User favor;

    public Favorite(Book book, User favor) {
        this.book = book;
        this.favor = favor;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getFavor() {
        return favor;
    }

    public void setFavor(User favor) {
        this.favor = favor;
    }
}
