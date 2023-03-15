package com.radinfodesign.fboace04a.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.radinfodesign.fboace04a.jpa.model.JpaAircraftType;

public interface AircraftTypeRepository extends CrudRepository<JpaAircraftType, Integer> {
  
  JpaAircraftType findByShortName(String name);

  List<JpaAircraftType> findAllByOrderByShortName();

  default List<JpaAircraftType> findAllInDefaultOrder () {
    return findAllByOrderByShortName();
  }

  @SuppressWarnings("unchecked")
  default <T extends JpaAircraftType> T getBlankInstance(){
    return (T) new JpaAircraftType();
  }

}
