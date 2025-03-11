package com.example.bulletinboard;

import com.example.bulletinboard.mapper.Content.ContentMapper;
import com.example.bulletinboard.model.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ContentMapperTest {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void testInsertContent() {
        Content content = new Content();
        content.setPost_Id(1);
        content.setContent("Test content");

        contentMapper.insertContent(content);

        List<Content> contents = contentMapper.getAllContents();
        assertTrue(contents.stream().anyMatch(c -> c.getContent().equals("Test content")), "Inserted content should be found");
    }

    @Test
    public void testGetAllContents() {
        List<Content> contents = contentMapper.getAllContents();
        assertNotNull(contents, "Contents should not be null");
        //assertFalse(contents.isEmpty(), "Contents should not be empty");
    }
}