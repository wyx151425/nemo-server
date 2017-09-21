package cn.rumofuture.nemo.model.dao;

import cn.rumofuture.nemo.domain.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WangZhenqi on 2017/8/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)  // spring的单元测试
@ContextConfiguration({"classpath:spring/spring-*.xml"})  //上下文配置
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void saveBookTest() {
        Book book = null;
    }

    @Test
    public void deleteBookTest() {
        int result;
        try {
            result = bookDao.deleteBook(1);
        } catch (Exception e) {
            result = 0;
            System.out.println("*****Exception*****");
        }
        System.out.println(result);
    }

    @Test
    public void findBooksByAuthorIdTest() {
        Book book = null;
        try {
            book = bookDao.findBooksByAuthorId(1).get(0);
        } catch (Exception e) {
            System.out.println("");
        }
        System.out.println(book);
    }
}
