package com.openplatform.poc.author.service;

import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
public interface AuthorService {

   Author getById(UUID id);
}
