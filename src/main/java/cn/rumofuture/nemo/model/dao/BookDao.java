package cn.rumofuture.nemo.model.dao;

import cn.rumofuture.nemo.model.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

@Mapper
public interface BookDao {
    int saveBook(Book book) throws Exception;
    int updateBookCover(Book book) throws Exception;
    int updateBookInfo(Book book) throws Exception;
    int deleteBook(Integer id) throws Exception;
    Book findBookById(Integer id) throws Exception;
    List<Book> findBookListByAuthor(Integer authorId) throws Exception;
}
