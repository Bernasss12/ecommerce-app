package dev.bernasss12.ecommerce.backend.config;

import dev.bernasss12.ecommerce.backend.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions));

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions));
    }

}
