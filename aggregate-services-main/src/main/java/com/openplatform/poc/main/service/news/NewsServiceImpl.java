package com.openplatform.poc.main.service.news;

import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
public class NewsServiceImpl implements NewsService {

    @Override
    public News getNews()
    {
        News news = new News();
        news.setId(UUID.randomUUID());
        news.setName("New Year Celebration");
        news.setAuthorId(UUID.randomUUID());

        return news;
    }
}
