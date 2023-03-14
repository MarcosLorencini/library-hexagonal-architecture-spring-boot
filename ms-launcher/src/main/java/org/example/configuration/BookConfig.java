package org.example.configuration;

//We also need to do some manual configuration. As we said before, we have a domain module
// that is completely isolated from spring boot, so in order for spring to instantiate our
// domain and inject it, we have to declare our beans manually.

import org.example.adapters.BookJpaAdapter;
import org.exemple.ports.api.BookServicePort;
import org.exemple.ports.spi.BookPersistencePort;
import org.exemple.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistence() {
        return new BookJpaAdapter();
    }

    @Bean
    public BookServicePort bookService() {
        return new BookServiceImpl(bookPersistence());
    }
}
