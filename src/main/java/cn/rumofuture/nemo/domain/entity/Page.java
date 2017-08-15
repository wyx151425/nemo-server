package cn.rumofuture.nemo.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public final class Page implements Serializable {

    private Integer id;

    private Book book;
    private String image;
    private Integer number;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        if (id != null ? !id.equals(page.id) : page.id != null) return false;
        return createDate != null ? createDate.equals(page.createDate) : page.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", book=" + book +
                ", image='" + image + '\'' +
                ", number=" + number +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
