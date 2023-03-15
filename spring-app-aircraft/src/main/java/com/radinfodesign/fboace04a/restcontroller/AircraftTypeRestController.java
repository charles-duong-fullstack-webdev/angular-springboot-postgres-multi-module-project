package com.radinfodesign.fboace04a.restcontroller;

import com.radinfodesign.fboace04a.*;
import com.radinfodesign.fboace04a.dto.DtoAircraftType;
import com.radinfodesign.fboace04a.util.*;
import com.radinfodesign.exception.InvalidEntityIdException;
import com.radinfodesign.fboace04a.service.AircraftTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(AircraftTypeRestController.APP_URL+AircraftTypeRestController.ENTITY_URL)
public class AircraftTypeRestController {

  private final Logger log = LoggerFactory.getLogger(AircraftTypeRestController.class);

  public static final String APP_URL = FBOAce04aApplication.APP_NAME;
  public static final String ENTITY_URL = "/AircraftType";
  public static final String BUSINESS_ENTITY = "Aircraft Type";
  public static final String ALL_INSTANCES_URL = "";
  public static final String ID_PARAM = "/{id}";
  public static final String THIS_CONTROLLER = "AircraftTypeRestController";
  public static final String DOT = ".";
  public static final String ANGULAR_CLIENT = "http://localhost:4200";

  @Autowired
  private AircraftTypeService service;

  @CrossOrigin(origins = ANGULAR_CLIENT)
  @GetMapping(value=ALL_INSTANCES_URL)
  public List<? extends DtoAircraftType> listSimpleInstances() {
    return service.getAll();
  }

  @CrossOrigin(origins = ANGULAR_CLIENT)
  @GetMapping(value=ID_PARAM)
  public ResponseEntity<DtoAircraftType> getInstance(@PathVariable Integer id) throws InvalidEntityIdException {
    log.info(THIS_CONTROLLER+DOT+"getInstance()");
    DtoAircraftType simpleAircraftType = service.getInstance(id).orElseThrow(InvalidEntityIdException::new);
    return ResponseEntity.ok().body(simpleAircraftType);
  }

  @CrossOrigin(origins = ANGULAR_CLIENT)
  @PutMapping()
  ResponseEntity<DtoAircraftType> updateAircraftType(@RequestBody DtoAircraftType aircraftType) throws Exception{
    log.info(THIS_CONTROLLER+DOT+"updateAircraftType()");
    DtoAircraftType result = service.putInstance(aircraftType);
    return ResponseEntity.ok().body(result);
  }

  @CrossOrigin(origins = ANGULAR_CLIENT)
  @PostMapping()
  ResponseEntity<DtoAircraftType> createAircraftType(@RequestBody DtoAircraftType aircraftType) throws Exception{
    log.info(THIS_CONTROLLER+DOT+"createAircraftType()");
    aircraftType.setAircraftTypeId(null);
    DtoAircraftType result = service.putInstance(aircraftType);
    return ResponseEntity.ok().body(result);
  }

  @CrossOrigin(origins = ANGULAR_CLIENT)
  @DeleteMapping(value=ID_PARAM)
  public ResponseEntity<?> deleteInstance(@PathVariable Integer id) throws InvalidEntityIdException {
    log.info(THIS_CONTROLLER+DOT+"deleteInstance()");
    String message = BUSINESS_ENTITY + Constants.RECORD_DELETED;
    try {
      long deleteResult = service.deleteInstance(id);
      if (deleteResult != 1) throw new Exception();
    } catch (Exception e) {
      message = Constants.RECORD_NOT_DELETED_MESSAGE;
      return new ResponseEntity<>(message+": " + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

}
