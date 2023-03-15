package com.radinfodesign.fboace04a.jpa.service;

import com.radinfodesign.exception.InvalidEntityIdException;
import com.radinfodesign.fboace04a.dto.DtoAircraftType;
import com.radinfodesign.fboace04a.jpa.dao.AircraftTypeRepository;
import com.radinfodesign.fboace04a.jpa.model.JpaAircraftType;
import com.radinfodesign.fboace04a.service.AircraftTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@Service
@Qualifier("aircraftTypeJpaService")
public class JpaAircraftTypeService implements AircraftTypeService {

  public static final String THIS_CLASS = "JpaAircraftTypeService";

  @Autowired
  AircraftTypeRepository repository;

  @Override
  public List<? extends DtoAircraftType> getAll() {
    return repository.findAllInDefaultOrder();
  }

  @Override
  public Optional<? extends DtoAircraftType> getInstance (Integer aircraftTypeId) throws InvalidEntityIdException {
    return repository.findById(aircraftTypeId);
  }

  @Override
  @Transactional
  public DtoAircraftType putInstance (DtoAircraftType dtoAircraftType) throws Exception {
    JpaAircraftType jpaAircraftType = new JpaAircraftType();
    BeanUtils.copyProperties(dtoAircraftType, jpaAircraftType);
    return repository.save(jpaAircraftType);
  }

  @Override
  @Transactional
  public long deleteInstance(Integer aircraftTypeId) {
    try {
      repository.deleteById(aircraftTypeId);
      return 1;
    } catch (Exception e) {
      out.println(THIS_CLASS + " threw Exception: " + e.getMessage());
      e.printStackTrace();
      return -1;
    }
  }

}

