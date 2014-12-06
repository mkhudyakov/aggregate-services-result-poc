package com.openplatform.poc.main.service.news;

import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
public class News {

    private UUID id;
    private String name;
    private UUID authorId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
