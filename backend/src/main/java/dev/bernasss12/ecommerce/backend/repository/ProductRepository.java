package dev.bernasss12.ecommerce.backend.repository;

import dev.bernasss12.ecommerce.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}