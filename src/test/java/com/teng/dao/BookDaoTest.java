package com.teng.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teng.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetById() {
        bookDao.selectById(4);
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("Java从入门到入土");
        book.setDescription("一本让你Java升华的书");
        book.setType("计算机理论");
        bookDao.insert(book);

    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(14);
        book.setName("Java从入门到入土123");
        book.setDescription("一本让你Java升华的书123");
        book.setType("计算机理论213");
        bookDao.updateById(book);
    }

    @Test
    public void testDelete() {
        bookDao.deleteById(14);
    }

    @Test
    public void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    public void testGetPage() {
        IPage page = new Page(2, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());		//当前页码值
        System.out.println(page.getSize());			//每页显示数
        System.out.println(page.getTotal());		//数据总量
        System.out.println(page.getPages());		//总页数
        page.getRecords().forEach(book -> System.out.println(book));
    }

    @Test
    public void testGroupBy() {
        String name = "Spring";
        IPage page = new Page(1, 5);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(name != null, Book::getName, name); // 当名字不为空的时候才做模糊查询
        bookDao.selectPage(page, lqw);
    }

}
