package com.cs.model.usecase.student;

import java.util.List;

public interface IGetStudentBasicDetailsModel extends IGetStudentByIdModel {
  
  public static final String NAME         = "name";
  public static final String EMAIL        = "email";
  public static final String PHONE_NUMBER = "phoneNumber";
  public static final String FATHER_NAME  = "fatherName";
  public static final String ADDRESS      = "address";
  public static final String GENDER       = "gender";
  public static final String JOINING_DATE = "joiningDate";
  public static final String BIRTH_DATE   = "birthDate";
  public static final String COUNTRY      = "country";
  public static final String STATE        = "state";
  public static final String CITY         = "city";
  public static final String PIN_CODE     = "pinCode";
  public static final String STANDARD     = "standard";
  public static final String COURSES      = "courses";
  
  public String getId();
  public void setId(String id);
  
  public String getEmail();
  public void setEmail(String email);
  
  public String getPhoneNumber();
  public void setPhoneNumber(String phoneNumber);
  
  public String getFatherName();
  public void setFatherName(String fatherName);
  
  public String getAddress();
  public void setAddress(String address);
  
  public String getGender();
  public void setGender(String gender);
  
  public String getJoiningDate();
  public void setJoiningDate(String joiningDate);
  
  public String getBirthDate();
  public void setBirthDate(String birthDate);
  
  public String getCountry();
  public void setCountry(String country);
  
  public String getState();
  public void setState(String state);
  
  public String getCity();
  public void setCity(String city);

  public String getPinCode();
  public void setPinCode(String pinCode);

  public String getName();
  public void setName(String name);

  public String getStandard();
  public void setStandard(String standard);

  public List<String> getCourses();
  public void setCourses(List<String> courses);
}
