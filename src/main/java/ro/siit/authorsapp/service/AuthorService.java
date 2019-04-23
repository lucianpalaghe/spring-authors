package ro.siit.authorsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.authorsapp.model.Author;
import ro.siit.authorsapp.model.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepo;

    public Iterable<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    public Author saveAuthor(Author a){
        return authorRepo.save(a);
    }

    public void removeAuthorById(Integer id){
        authorRepo.deleteById(id);
    }
}
