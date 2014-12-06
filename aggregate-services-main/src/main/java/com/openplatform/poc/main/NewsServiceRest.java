package com.openplatform.poc.main;

import com.google.inject.Inject;
import com.openplatform.poc.main.service.author.AuthorService;
import com.openplatform.poc.main.service.news.NewsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maksym Khudiakov
 */
@Path("/news")
public class NewsServiceRest {

    private NewsService newsService;
    private AuthorService authorService;

    @GET
    @Path("/")
    @Produces("application/json")
    public News getByUserId()
    {
        com.openplatform.poc.main.service.news.News news = newsService.getNews();

        News dto = new News();
        dto.setId(news.getId().toString());
        dto.setName(news.getName());

        News.Author author = new News.Author();
        author.setId(news.getAuthorId().toString());
        author.setName(authorService.getById(news.getAuthorId()).getName());
        dto.setAuthor(author);

        return dto;
    }

    @Inject
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Inject
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * @author Maksym Khudiakov
     */
    @XmlRootElement(name = "news")
    public static class News {

        public static class Author {

            private String id;
            private String name;

            @XmlElement
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            @XmlElement
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        private String id;
        private String name;
        private Author author;

        @XmlElement
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @XmlElement
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlElement
        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }
}
