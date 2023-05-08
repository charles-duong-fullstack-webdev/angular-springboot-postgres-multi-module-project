package com.db.h2.console.repository;

import com.db.h2.console.domain.Login;
import com.db.h2.console.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginRepository extends CrudRepository<Login, Long> {
    List<Login> findAll();
}
