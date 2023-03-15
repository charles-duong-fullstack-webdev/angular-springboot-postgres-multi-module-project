package com.radinfodesign.fboace04a.dto;

import java.io.Serializable;

public class DtoAircraftType implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer aircraftTypeId;
  private String shortName;
  private String longName;
  private String description;
  private String notes;

  public Integer getAircraftTypeId() {
    return aircraftTypeId;
  }
  public void setAircraftTypeId(Integer aircraftTypeId) {
    this.aircraftTypeId = aircraftTypeId;
  }
  public String getShortName() {
    return shortName;
  }
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
  public String getLongName() {
    return longName;
  }
  public void setLongName(String longName) {
    this.longName = longName;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof DtoAircraftType)) {
      return false;
    }
    DtoAircraftType other = (DtoAircraftType) object;
    if ((this.shortName==null) || (other.shortName==null)
      || (this.aircraftTypeId==null) || (other.aircraftTypeId==null))
      return false;
    else
      return ((this.aircraftTypeId.equals(other.aircraftTypeId))
        && (this.shortName.equalsIgnoreCase(other.shortName))
      );
  }

  @Override
  public String toString() {
    return this.getShortName();
  }
}
