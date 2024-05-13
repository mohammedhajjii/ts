package ma.enset.backend;

import ma.enset.backend.entities.Category;
import ma.enset.backend.entities.Product;
import ma.enset.backend.repositories.CategoryRepository;
import ma.enset.backend.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {

            List<Category> categoryList = Stream.of("beauty", "electronics")
                    .map(name -> Category.builder().name(name).build())
                    .toList();


            categoryRepository.saveAll(categoryList);

            Stream.of("p1", "p2", "p3", "p4")
                    .map(name -> Product.builder()
                            .name(name)
                            .price(Math.random() * 150)
                            .category(categoryList.get((Math.random() > 0.5) ? 1: 0))
                            .build()
                    )
                    .forEach(productRepository::save);

        };
    }

}
