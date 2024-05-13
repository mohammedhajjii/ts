package ma.enset.backend.repositories;

import ma.enset.backend.entities.Category;
import ma.enset.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {


    List<Product> findByCategoryId(Long categoryId);
}
