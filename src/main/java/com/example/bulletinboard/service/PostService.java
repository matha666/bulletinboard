package com.example.bulletinboard.service;


import com.example.bulletinboard.mapper.Content.ContentMapper;
import com.example.bulletinboard.mapper.Title.TitleMapper;
import com.example.bulletinboard.model.Content;
import com.example.bulletinboard.model.Post;
import com.example.bulletinboard.model.Title;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private ContentMapper contentMapper;

    @Transactional
    public void registerPost(String title, String content) {
        Title titleObj = new Title();
        titleObj.setTitle(title);
        titleMapper.insertTitle(titleObj);

        Content contentObj = new Content();
        contentObj.setPostId(titleObj.getId());
        contentObj.setContent(content);
        contentMapper.insertContent(contentObj);
    }

    public List<Post> getAllPosts() {
        List<Title> titles = titleMapper.getAllTitles();
        List<Content> contents = contentMapper.getAllContents();


        Map<Integer, String> contentMap = contents.stream()
                .collect(Collectors.toMap(Content::getPostId, Content::getContent));

        return titles.stream()
                .map(t -> new Post(t.getId(), t.getTitle(), contentMap.get(t.getId())))
                .collect(Collectors.toList());
    }
}
