package com.mic.pro.service.admin;

import com.mic.pro.service.admin.domain.model.News;
import com.mic.pro.service.admin.domain.service.NewsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminWebApplicationTests {

    @Autowired
    private NewsService service;

    @Test
    void save() {
        News news = new News(Long.valueOf(1),"new test","new context test");
        service.insert(news);
    }

}
