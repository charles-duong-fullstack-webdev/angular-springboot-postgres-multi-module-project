package com.radinfodesign.fboace04a.service;

import com.radinfodesign.exception.InvalidEntityIdException;
import com.radinfodesign.fboace04a.dto.DtoAircraftType;
import java.util.List;
import java.util.Optional;

public interface AircraftTypeService {

  List<? extends DtoAircraftType> getAll();

  Optional<? extends DtoAircraftType> getInstance (Integer aircraftTypeId) throws InvalidEntityIdException;

  DtoAircraftType putInstance (DtoAircraftType dtoAircraftType) throws Exception;

  long deleteInstance(Integer aircraftTypeId);

}
