package cn.rumofuture.nemo.model.dao;

import cn.rumofuture.nemo.model.domain.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

@Mapper
public interface PageDao {
    int savePage(Page page);
    int updatePage(Page page);
    int deletePage(Integer id);
    Page findPageById(Integer id);
    List<Page> findPageListByBookId(Integer bookId);
}
