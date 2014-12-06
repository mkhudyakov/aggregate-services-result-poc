package com.openplatform.poc.main.config;

import com.openplatform.poc.main.NewsServiceRest;
import com.openplatform.poc.main.service.author.AuthorService;
import com.openplatform.poc.main.service.author.AuthorServiceDelegate;
import com.openplatform.poc.main.service.news.NewsService;
import com.openplatform.poc.main.service.news.NewsServiceImpl;
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
        bind(NewsServiceRest.class);

        /* Bind jackson converters for JAXB/JSON serialization */
        bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
        bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);

        bind(NewsService.class).to(NewsServiceImpl.class);
        bind(AuthorService.class).to(AuthorServiceDelegate.class);

        serve("/api/*").with(GuiceContainer.class);
    }
}