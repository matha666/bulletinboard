package com.example.bulletinboard.mapper.Title;

import com.example.bulletinboard.model.Title;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TitleMapper {
    @Insert("INSERT INTO titles (title) VALUES (#{title})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTitle(Title title);

    @Select("SELECT * FROM titles")
    List<Title> getAllTitles();
}
