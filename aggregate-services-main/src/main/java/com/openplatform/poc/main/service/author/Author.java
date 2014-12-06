package com.openplatform.poc.main.service.author;

import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
public class Author {

    private UUID id;
    private String name;

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
}
