package com.openplatform.poc.author;

import com.google.inject.Inject;
import com.openplatform.poc.author.service.Author;
import com.openplatform.poc.author.service.AuthorService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * @author Maksym Khudiakov
 */
@Path("/author")
public class AuthorServiceRest {

    private AuthorService service;

    @GET
    @Path("/{authorId}")
    @Produces("application/json")
    public AuthorDTO getByUserId(@PathParam("authorId") String authorId)
    {
        Author author = service.getById(UUID.fromString(authorId));

        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId().toString());
        dto.setName(author.getName());

        return dto;
    }

    @Inject
    public void setService(AuthorService service) {
        this.service = service;
    }

    /**
     * @author Maksym Khudiakov
     */
    @XmlRootElement(name = "author")
    public static class AuthorDTO {

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
}
