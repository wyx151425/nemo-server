package cn.rumofuture.nemo.service;

import cn.rumofuture.nemo.dao.BookDao;
import cn.rumofuture.nemo.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public int saveBook(Book book) {
        int result;
        try {
            result = bookDao.saveBook(book);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public int updateBookInformation(Book book) {
        int result;
        try {
            result = bookDao.updateBookInformation(book);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public int deleteBook(Integer id) {
        int result;
        try {
            result = bookDao.deleteBook(id);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Book findBookById(Integer id) {
        Book book = null;
        try {
            book = bookDao.findBookById(id);
        } catch (Exception e) {
            book = null;
        }
        return book;
    }
}
