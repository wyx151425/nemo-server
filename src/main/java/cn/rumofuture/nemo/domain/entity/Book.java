package cn.rumofuture.nemo.domain.entity;

import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public final class Book implements Serializable {

    private Integer id;

    private User author;

    private String name;
    private String cover;
    private String category;
    private String style;
    private String introduction;

    private Integer pageNumber;
    private Integer collectorNumber;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(Integer collectorNumber) {
        this.collectorNumber = collectorNumber;
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

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        return createDate != null ? createDate.equals(book.createDate) : book.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", category='" + category + '\'' +
                ", style='" + style + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pageNumber=" + pageNumber +
                ", collectorNumber=" + collectorNumber +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
