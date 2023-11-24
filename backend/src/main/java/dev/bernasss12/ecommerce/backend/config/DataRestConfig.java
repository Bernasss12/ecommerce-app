package dev.bernasss12.ecommerce.backend.config;

import java.util.stream.Collectors;

import dev.bernasss12.ecommerce.backend.entity.Product;
import dev.bernasss12.ecommerce.backend.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((unused, httpMethods) -> httpMethods.disable(unsupportedActions));

        config.exposeIdsFor(
                entityManager
                        .getMetamodel()
                        .getEntities()
                        .stream()
                        .map(EntityType::getJavaType)
                        .toList()
                        .toArray(new Class[0])
        );
    }
}