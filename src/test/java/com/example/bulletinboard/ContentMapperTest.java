package com.example.bulletinboard;

import com.example.bulletinboard.mapper.Content.ContentMapper;
import com.example.bulletinboard.model.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ContentMapperTest {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void testGetAllContents() {
        List<Content> contents = contentMapper.getAllContents();
        //assertFalse(contents.isEmpty(), "Contents should not be empty");
    }
}