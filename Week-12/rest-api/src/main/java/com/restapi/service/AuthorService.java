package com.restapi.service;

import com.restapi.dto.request.AuthorRequest;
import com.restapi.dto.response.AuthorResponse;
import com.restapi.entitiy.Author;
import com.restapi.mapper.AuthorMapper;
import com.restapi.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    public List<AuthorResponse> findAll() {
        return authorMapper.asOutput(authorRepository.findAll());
    }

    public AuthorResponse getById(Long id) {
        return authorMapper.asOutput(authorRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "Id sahibi yazar bulunamadı.")));
    }

    public AuthorResponse create(AuthorRequest request) {
        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(request.getName(), request.getBirthDate(), request.getCountry());

        if (isAuthorExist.isEmpty()) {
            Author authorSaved = authorRepository.save(authorMapper.asEntity(request));
            return authorMapper.asOutput(authorSaved);
        }
        throw new RuntimeException("Önceden Kaydedilmiş Yazar.");
    }

    public AuthorResponse update(Long id, AuthorRequest request) {

        Optional<Author> authorFromDb = authorRepository.findById(id);

        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(request.getName(), request.getBirthDate(), request.getCountry());

        if (authorFromDb.isEmpty()) {
            throw new RuntimeException(id + " Güncelleme Başarısız: Yazar Kaydı Mevcut Değil.");
        }

        if (isAuthorExist.isPresent()) {
            throw new RuntimeException("Sisteme kayıtlı yazar.");
        }
        Author author = authorFromDb.get();
        authorMapper.update(author, request);
        return authorMapper.asOutput(authorRepository.save(author));
    }

    public void deleteById(Long id) {
        Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isPresent()) {
            authorRepository.delete(authorFromDb.get());
        } else {
            throw new RuntimeException(id + "Id Sahibi Yazar Bulunamadı.");
        }
    }


}
