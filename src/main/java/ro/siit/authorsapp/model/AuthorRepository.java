package ro.siit.authorsapp.model;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Author findByName(String name);
}
