package cn.rumofuture.nemo.model.domain;

import java.io.Serializable;

/**
 * Created by WangZhenqi on 2017/8/31.
 */

public class Album implements Serializable {

    private Integer imageId;  // 专辑封面图片id

    private String style;  // 专辑的风格
    private String note;  // 专辑的注释

    private Integer number;
    private Integer bookTotal;  // 专辑漫画册总数

    public Album() {
    }

    public Album(Integer imageId, String style, String note) {
        this.imageId = imageId;
        this.style = style;
        this.note = note;
    }


}
