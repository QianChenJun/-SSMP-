package com.teng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teng.dao.BookDao;
import com.teng.domain.Book;
import com.teng.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 保存图书
     * @param book
     * @return Boolean
     */
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    /**
     * 更新图书
     * @param book
     * @return Boolean
     */
    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    /**
     * 根据ID删除图书
     * @param id
     * @return Boolean
     */
    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    /**
     * 根据ID查询图书
     * @param id
     * @return Book
     */
    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    /**
     * 获取全部图书
     * @return List<Book> 图书列表
     */
    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    /**
     * 获取分页信息
     * @param currentPage 当前页
     * @param pageSize 每页显示条数
     * @return IPage<Book> 封装的分页信息
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null); // 结果封装到page中
        return page;
    }

    /**
     * 获取分页信息
     * @param currentPage 当前页
     * @param pageSize 每页显示条数
     * @param book 封装的图书信息
     * @return IPage<Book> 封装的分页信息
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, lqw); // 结果封装到page中
        return page;
    }
}
