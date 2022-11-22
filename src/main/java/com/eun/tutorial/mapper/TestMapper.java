package com.eun.tutorial.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eun.tutorial.dto.Book;

@Mapper
public interface TestMapper {
    List<Book> getBookLists();
}