package cn.rumofuture.nemo.model.domain;

import java.io.Serializable;

/**
 * Created by WangZhenqi on 2016/12/24.
 */

public class Book implements Serializable {

    private User author;  // 所属漫画作者

    private String name;  // 名称
    private String style;  // 风格
    private String introduction;  // 简介

    private Integer pageTotal;  // 漫画册漫画分页数
    private Integer favorTotal;  // 收藏此漫画的用户数

    private String coverUrl;  // 漫画册封面

    private Boolean approve;
    private Boolean show;


}
