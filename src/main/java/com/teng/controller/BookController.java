package com.teng.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.teng.domain.Book;
import com.teng.service.BookService;
import com.teng.controller.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.getAll());
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {
        Boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        Boolean flag = bookService.update(book);
        return new Result(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(bookService.delete(id));
    }

    @GetMapping("{id}")
    public Result getBookById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果当前页码值大于总页码值, 那么重新执行操作查询, 使用最大是页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new Result(true, page);
    }

}
