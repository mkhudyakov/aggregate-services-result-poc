package com.openplatform.poc.author.config;

import com.openplatform.poc.author.AuthorServiceRest;
import com.openplatform.poc.author.service.AuthorService;
import com.openplatform.poc.author.service.AuthorServiceImpl;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * @author Maksym Khudiakov
 */
public class ServiceBindingModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {

        /* Bind the REST resources */
        bind(AuthorServiceRest.class);

        /* Bind jackson converters for JAXB/JSON serialization */
        bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
        bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);

        bind(AuthorService.class).to(AuthorServiceImpl.class);

        serve("/api/*").with(GuiceContainer.class);
    }
}