package com.example.demo.service;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getArtistList() {
        return artistRepository.findAll();
    }
}
