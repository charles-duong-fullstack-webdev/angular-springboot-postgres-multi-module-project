package com.db.h2.console.repository;

import java.util.List;

import com.db.h2.console.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	List<Author> findAllByOrderByLastNameAscFirstNameAsc();

}
