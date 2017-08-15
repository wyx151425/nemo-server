package cn.rumofuture.nemo.domain.relation;

import cn.rumofuture.nemo.domain.entity.Book;
import cn.rumofuture.nemo.domain.entity.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by WangZhenqi on 2017/8/12.
 */

public final class Collect implements Serializable {

    private Integer id;
    private Book book;
    private User collector;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getCollector() {
        return collector;
    }

    public void setCollector(User collector) {
        this.collector = collector;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
