package com.restapi.service;

import com.restapi.entitiy.Book;
import com.restapi.entitiy.Category;
import com.restapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final BookService bookService;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "id li Kategori Bulunamadı !!!"));
    }

    public Category create(Category request) {
        Optional<Category> isCategoryExist = categoryRepository.findByName(request.getName());

        if (isCategoryExist.isEmpty()) {
            return categoryRepository.save(request);
        }
        throw new RuntimeException("Bu kategori daha önce sisteme kayıt olmuştur !!!");
    }

    public Category update(Long id, Category request) {

        Optional<Category> categoryFromDb = categoryRepository.findById(id);

        Optional<Category> isCategoryExist = categoryRepository.findByName(request.getName());

        if (categoryFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız kategori sistemde bulunamadı. !!!.");
        }

        if (isCategoryExist.isPresent()) {
            throw new RuntimeException("Bu kategori daha önce sisteme kayıt olmuştur !!!");
        }
        request.setId(id);
        return categoryRepository.save(request);
    }

    public String deleteById(Long id) {
        Optional<Category> categoryFromDb = categoryRepository.findById(id);
        List<Book> booksInCategory = bookService.findByCategoryId(id);

        if (!categoryFromDb.isPresent()) {
            return id + " id li Kategori sistemde bulunamadı!!!";
        } else if (!booksInCategory.isEmpty()) {
            return id + " id li Kategoriye ait sistemde kayıtlı kitap mevcut! Silme işlemi yapılamadı.";
        } else {
            categoryRepository.delete(categoryFromDb.get());
            return "Kategori silme işlemi başarılı";
        }
    }
}
