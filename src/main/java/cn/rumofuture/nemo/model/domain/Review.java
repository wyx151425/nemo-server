package cn.rumofuture.nemo.model.domain;

import java.io.Serializable;

/**
 * Created by WangZhenqi on 2017/4/18.
 */

public class Review implements Serializable {

    private Book book;
    private User reviewer;
    private String content;


}
