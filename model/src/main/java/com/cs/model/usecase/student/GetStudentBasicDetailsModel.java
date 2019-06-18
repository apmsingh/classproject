package com.cs.model.usecase.student;

import java.util.List;

public class GetStudentBasicDetailsModel extends GetStudentByIdModel
    implements IGetStudentBasicDetailsModel {
  
  private static final long serialVersionUID = 1L;
  private String            email;
  private String            phoneNumber;
  private String            fatherName;
  private String            address;
  private String            gender;
  private String            joiningDate;
  private String            birthDate;
  private String            country;
  private String            state;
  private String            city;
  private String            pinCode;
  private List<String>      courses;
  private String            standard;
  private String            name;
  
  @Override
  public String getEmail()
  {
    return email;
  }
  
  @Override
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  @Override
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  
  @Override
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }
  
  @Override
  public String getFatherName()
  {
    return fatherName;
  }
  
  @Override
  public void setFatherName(String fatherName)
  {
    this.fatherName = fatherName;
  }
  
  @Override
  public String getAddress()
  {
    return address;
  }
  
  @Override
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  @Override
  public String getGender()
  {
    return gender;
  }
  
  @Override
  public void setGender(String gender)
  {
    this.gender = gender;
  }
  
  @Override
  public String getJoiningDate()
  {
    return joiningDate;
  }
  
  @Override
  public void setJoiningDate(String joiningDate)
  {
    this.joiningDate = joiningDate;
  }
  
  @Override
  public String getBirthDate()
  {
    return birthDate;
  }
  
  @Override
  public void setBirthDate(String birthDate)
  {
    this.birthDate = birthDate;
  }
  
  @Override
  public String getCountry()
  {
    return country;
  }
  
  @Override
  public void setCountry(String country)
  {
    this.country = country;
  }
  
  @Override
  public String getState()
  {
    return state;
  }
  
  @Override
  public void setState(String state)
  {
    this.state = state;
  }
  
  @Override
  public String getCity()
  {
    return city;
  }
  
  @Override
  public void setCity(String city)
  {
    this.city = city;
  }
  
  @Override
  public String getPinCode()
  {
    return pinCode;
  }
  
  @Override
  public void setPinCode(String pinCode)
  {
    this.pinCode = pinCode;
  }

  @Override
  public String getName()
  {
    return name;
  }

  @Override
  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String getStandard()
  {
    return standard;
  }

  @Override
  public void setStandard(String standard)
  {
    this.standard = standard;
  }

  @Override
  public List<String> getCourses()
  {
    return courses;
  }

  @Override
  public void setCourses(List<String> courses)
  {
    this.courses = courses;
  }
}
