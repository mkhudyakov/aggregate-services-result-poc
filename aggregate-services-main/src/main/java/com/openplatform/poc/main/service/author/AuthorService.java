package com.openplatform.poc.main.service.author;

import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
public interface AuthorService {

   Author getById(UUID id);
}
