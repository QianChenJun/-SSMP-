package com.teng.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.teng.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetBookById() {
        System.out.println(bookService.getById(12));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("Java从入门到入土");
        book.setDescription("一本让你Java升华的书");
        book.setType("计算机理论");
        bookService.save(book);

    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(15);
        book.setName("Java从入门到入土123");
        book.setDescription("一本让你Java升华的书123");
        book.setType("计算机理论213");
        bookService.update(book);
    }

    @Test
    public void testDelete() {
        bookService.delete(15);
    }

    @Test
    public void testGetAll() {
        List<Book> books = bookService.getAll();
        books.forEach(book -> System.out.println(book));
    }

    @Test
    public void testGetPage() {
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println(page.getCurrent());        //当前页码值
        System.out.println(page.getSize());            //每页显示数
        System.out.println(page.getTotal());        //数据总量
        System.out.println(page.getPages());        //总页数
        page.getRecords().forEach(book -> System.out.println(book));
    }

}
