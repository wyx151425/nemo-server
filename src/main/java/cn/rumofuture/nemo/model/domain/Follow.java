package cn.rumofuture.nemo.model.domain;

import java.io.Serializable;

/**
 * Created by WangZhenqi on 2017/4/18.
 */

public class Follow implements Serializable {

    private User author;
    private User follower;

    public Follow(User author, User follower) {
        this.author = author;
        this.follower = follower;
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
}
