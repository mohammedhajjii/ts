package ma.enset.backend.web;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.crypto.impl.ECDSA;
import lombok.AllArgsConstructor;
import ma.enset.backend.dto.ProductDTORequest;
import ma.enset.backend.entities.Category;
import ma.enset.backend.entities.Product;
import ma.enset.backend.repositories.CategoryRepository;
import ma.enset.backend.repositories.ProductRepository;
import org.springframework.security.oauth2.jose.JwaAlgorithm;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    @GetMapping("/item/{id}")
    public Product getProductById(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/bycategory/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") Long id){
        return productRepository.findByCategoryId(id);
    }



    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductDTORequest productDto){

        Category category = categoryRepository.findById(productDto.categoryId())
                .orElse(null);

        Product product = Product.builder()
                .name(productDto.name())
                .category(category)
                .build();



        return productRepository.save(product);
    }


}
