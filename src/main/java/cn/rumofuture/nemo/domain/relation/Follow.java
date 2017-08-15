package cn.rumofuture.nemo.domain.relation;

import cn.rumofuture.nemo.domain.entity.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by WangZhenqi on 2017/8/12.
 */

public final class Follow implements Serializable {

    private Integer id;
    private User author;
    private User follower;
    private Date createDate;

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

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
