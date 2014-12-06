package com.openplatform.poc.main.service.author;

import com.google.inject.Singleton;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
@Singleton
public class AuthorServiceDelegate implements AuthorService {

    private Client client;
    private WebResource webResource;

    private synchronized void init() {
        client = Client.create();
        webResource = client
                .resource("http://localhost:8080/aggregate-services-author/api/author/");
    }

    @Override
    public Author getById(UUID id)
    {
        synchronized(this) {
            if (client == null) {
                init();
            }
        }

        Author author = null;
        try {
            ClientResponse response = webResource.path(id.toString()).accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            AuthorDTO dto = response.getEntity(AuthorDTO.class);
            author = new Author();
            author.setId(UUID.fromString(dto.getId()));
            author.setName(dto.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }

    @XmlRootElement(name = "author")
    public static class AuthorDTO {

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
