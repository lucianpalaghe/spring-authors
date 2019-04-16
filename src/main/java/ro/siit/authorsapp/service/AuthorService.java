package ro.siit.authorsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.authorsapp.model.Author;
import ro.siit.authorsapp.model.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
