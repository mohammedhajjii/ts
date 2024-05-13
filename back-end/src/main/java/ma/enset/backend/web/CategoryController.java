package ma.enset.backend.web;

import lombok.AllArgsConstructor;
import ma.enset.backend.entities.Category;
import ma.enset.backend.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ctg")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryRepository categoryRepository;


    @GetMapping("/all")
    public List<Category> getAllCategoris(){
        return categoryRepository.findAll();
    }

    @GetMapping("/categor/{id}")
    public Category getCategory(@PathVariable("id") Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    @PostMapping("/add/{name}")
    public Category addCategory(@PathVariable("name") String name){
        Category category = Category.builder()
                .name(name)
                .build();

        return categoryRepository.save(category);
    }
}
