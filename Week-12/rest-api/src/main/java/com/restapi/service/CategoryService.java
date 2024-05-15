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
        throw new RuntimeException("Daha Önce Kaydı Yapılmış Kategori!");
    }

    public Category update(Long id, Category request) {

        Optional<Category> categoryFromDb = categoryRepository.findById(id);

        Optional<Category> isCategoryExist = categoryRepository.findByName(request.getName());

        if (categoryFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncelleme Hatası: Kategori Sistemde Mevcut Değil");
        }

        if (isCategoryExist.isPresent()) {
            throw new RuntimeException("Sistemde Kaydı Olan Kategori.");
        }
        request.setId(id);
        return categoryRepository.save(request);
    }

    public String deleteById(Long id) {
        Optional<Category> categoryFromDb = categoryRepository.findById(id);
        List<Book> booksInCategory = bookService.findByCategoryId(id);

        if (!categoryFromDb.isPresent()) {
            return id + " Id Sahibi Kategori Bulunamadı.";
        } else if (!booksInCategory.isEmpty()) {
            return id + "Silme Başarısız:  Id Sahibi Kategoriye ait kayıtlı kitap(lar) mevcut.";
        } else {
            categoryRepository.delete(categoryFromDb.get());
            return "Başarı ile Silindi: Kategori";
        }
    }
}
