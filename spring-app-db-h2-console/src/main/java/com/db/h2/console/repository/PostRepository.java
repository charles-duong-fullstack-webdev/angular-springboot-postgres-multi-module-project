package com.db.h2.console.repository;

import java.util.List;
import java.util.Optional;

import com.db.h2.console.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	Post findFirstByOrderByPostedOnDesc();
	
	List<Post> findAllByOrderByPostedOnDesc();

	Post findBySlug(String slug);

	Optional<Post> findById(Long id);

	List<Post> findAllByAuthorIdOrderByPostedOnDesc(Long id);

}
