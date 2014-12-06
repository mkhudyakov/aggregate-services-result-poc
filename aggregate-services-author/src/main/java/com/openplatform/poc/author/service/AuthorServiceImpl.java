package com.openplatform.poc.author.service;

import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
public class AuthorServiceImpl implements AuthorService {

    @Override
    public Author getById(UUID id)
    {
        Author author = new Author();
        author.setId(id);
        author.setName("Viktor");

        return author;
    }
}
