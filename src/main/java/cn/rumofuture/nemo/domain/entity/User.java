package cn.rumofuture.nemo.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public final class User implements Serializable {

    private Integer id;

    private String name;
    private String mobilePhoneNumber;
    private String password;

    private String avatar;
    private String portrait;

    private String motto;
    private String email;
    private String location;
    private String occupation;
    private String introduction;

    private String sex;

    private Integer age;
    private Integer bookNumber;

    private Integer followedNumber;
    private Integer followerNumber;
    private Integer collectedNumber;

    @JSONField(format = "yyyy-MM-dd")
    private LocalDate birthday;
    // @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    // 如果不添加上方已注释的语句，则前端无法提交日期格式数据
    // 此处注释掉，可以防止前端提交数据修改创建日期
    private LocalDateTime createDate;
    // @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Integer getFollowedNumber() {
        return followedNumber;
    }

    public void setFollowedNumber(Integer followedNumber) {
        this.followedNumber = followedNumber;
    }

    public Integer getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(Integer followerNumber) {
        this.followerNumber = followerNumber;
    }

    public Integer getCollectedNumber() {
        return collectedNumber;
    }

    public void setCollectedNumber(Integer collectedNumber) {
        this.collectedNumber = collectedNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return createDate != null ? createDate.equals(user.createDate) : user.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", portrait='" + portrait + '\'' +
                ", motto='" + motto + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", occupation='" + occupation + '\'' +
                ", introduction='" + introduction + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", bookNumber=" + bookNumber +
                ", followedNumber=" + followedNumber +
                ", followerNumber=" + followerNumber +
                ", collectedNumber=" + collectedNumber +
                ", birthday=" + birthday +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
