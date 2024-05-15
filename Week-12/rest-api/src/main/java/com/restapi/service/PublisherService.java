package com.restapi.service;

import com.restapi.dto.response.PublisherResponse;
import com.restapi.entitiy.Publisher;
import com.restapi.mapper.PublisherMapper;
import com.restapi.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public List<PublisherResponse> findAll() {
        return publisherMapper.asOutput(publisherRepository.findAll());
    }

    public PublisherResponse getById(Long id) {
        Publisher p = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "Id Sahibi Yayın evi bulunamadı."));
        return publisherMapper.asOutput(p);
    }

    public Publisher create(Publisher request) {

        Optional<Publisher> isPublisherExist = publisherRepository.findByNameAndEstablishmentYear(request.getName(), request.getEstablishmentYear());

        if (isPublisherExist.isEmpty()) {
            return publisherRepository.save(request);
        }
        throw new RuntimeException("Daha Önce Kaydolmuş Yayın Evi.");
    }

    public Publisher update(Long id, Publisher request) {

        Optional<Publisher> publisherFromDb = publisherRepository.findById(id);

        Optional<Publisher> isPublisherExist = publisherRepository.findByNameAndEstablishmentYear(request.getName(), request.getEstablishmentYear());

        if (publisherFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncelleme Yapılamadı: Yayın Evi Kayıtlı Değil.");
        }

        if (isPublisherExist.isPresent()) {
            throw new RuntimeException("Daha Önce Sisteme Kayıt olmuş Yayın Evi.");
        }

        request.setId(id);
        return publisherRepository.save(request);
    }

    public void deleteById(Long id) {
        Optional<Publisher> publisherFromDb = publisherRepository.findById(id);
        if (publisherFromDb.isPresent()) {
            publisherRepository.delete(publisherFromDb.get());
        } else {
            throw new RuntimeException(id + "Id Sahibi Yayın Evi Sistemde Bulunamadı.");
        }
    }
}
