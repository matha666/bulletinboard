package com.example.bulletinboard.mapper.Content;

import com.example.bulletinboard.model.Content;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContentMapper {
    @Insert("INSERT INTO contents (post_id, content) VALUES (#{post_Id}, #{content})")
    void insertContent(Content content);

    @Select("SELECT * FROM contents")
    List<Content> getAllContents();
}
