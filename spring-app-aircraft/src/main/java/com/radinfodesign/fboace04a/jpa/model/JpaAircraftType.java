package com.radinfodesign.fboace04a.jpa.model;

import com.radinfodesign.fboace04a.dto.DtoAircraftType;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = JpaAircraftType.DB_OBJECT_NAME)
public class
JpaAircraftType extends DtoAircraftType implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String DB_OBJECT_NAME = "AIRCRAFT_TYPE";

  public static final String DB_COLUMN_AIRCRAFT_TYPE_ID = "AIRCRAFT_TYPE_ID";
  public static final String DB_COLUMN_SHORT_NAME       = "SHORT_NAME";
  public static final String DB_COLUMN_LONG_NAME        = "LONG_NAME";
  public static final String DB_COLUMN_DESCRIPTION      = "DESCRIPTION";
  public static final String DB_COLUMN_NOTES            = "NOTES";
  public static final String DB_SEQUENCE_NAME           = "AIRCRTYP_PK_SEQ";
  public static final String SEQUENCE_GENERATOR_NAME    = "SeqAircraftType";

  @Id
  @Basic(optional = false)
  @Column(name = DB_COLUMN_AIRCRAFT_TYPE_ID)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SEQUENCE_GENERATOR_NAME)
  @SequenceGenerator(name=SEQUENCE_GENERATOR_NAME, sequenceName=DB_SEQUENCE_NAME, allocationSize=1)
  private Integer aircraftTypeId;

  @Basic(optional = false)
  @Column(name = DB_COLUMN_SHORT_NAME)
  private String shortName;

  @Basic(optional = false)
  @Column(name = DB_COLUMN_LONG_NAME)
  private String longName;

  // @Basic(optional = false)
  // @Column(name = DB_COLUMN_NAME, insertable = false, updatable = false)
  // private String name;

  @Column(name = DB_COLUMN_DESCRIPTION)
  private String description;

  @Column(name = DB_COLUMN_NOTES)
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
  public int hashCode() {
    int hash = 0;
    hash += (aircraftTypeId != null ? aircraftTypeId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof JpaAircraftType)) {
      return false;
    }
    JpaAircraftType other = (JpaAircraftType) object;
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
