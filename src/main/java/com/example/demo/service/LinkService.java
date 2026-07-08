package com.example.demo.service;
import com.example.demo.model.Link;
import com.example.demo.repository.LinkRepository;
import com.example.demo.util.Base62Encoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private static final long ID_OFFSET = 1000000L; 
    public LinkService(LinkRepository linkRepository) { this.linkRepository = linkRepository; }
    @Transactional
    public String shortenUrl(String originalUrl) {
        Optional<Link> existingLink = linkRepository.findByOriginalUrl(originalUrl);
        if (existingLink.isPresent()) return existingLink.get().getShortCode();
        Link link = new Link(originalUrl);
        link = linkRepository.save(link);
        String shortCode = Base62Encoder.encode(link.getId() + ID_OFFSET);
        link.setShortCode(shortCode);
        linkRepository.save(link);
        return shortCode;
    }
    public Optional<Link> getOriginalUrl(String shortCode) { return linkRepository.findByShortCode(shortCode); }
}
