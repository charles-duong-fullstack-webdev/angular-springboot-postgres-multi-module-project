package com.db.h2.console.repository;

import com.db.h2.console.domain.Login;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LoginRepository extends CrudRepository<Login, Long> {

    @Query("SELECT l from Login l order by l.id")
    List<Login> findAll();

    @Query("SELECT max(l.id) from Login l")
    Long getMaxLoginId();

    @Query("SELECT l from Login l where l.id = :loginId and l.userid = :userid")
    List<Login> find(@Param("loginId") String externalId, @Param("userid") String source);

    @Modifying
    @Transactional
    @Query("DELETE from Login l where l.id = :loginId and l.userid = :userid")
    int deleteNotification(
            @Param("loginId") String portalId,
            @Param("userid") String externalId
    );
}
