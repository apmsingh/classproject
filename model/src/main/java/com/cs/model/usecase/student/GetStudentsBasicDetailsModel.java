package com.cs.model.usecase.student;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GetStudentsBasicDetailsModel implements IGetStudentsBasicDetailsModel {
  
  private static final long                  serialVersionUID = 1L;
  private String                             id;
  private List<IGetStudentBasicDetailsModel> students;
  
  @Override
  public String getId()
  {
    return id;
  }
  
  @Override
  public void setId(String id)
  {
    this.id = id;
  }
  
  @JsonDeserialize(as = GetStudentBasicDetailsModel.class)
  @Override
  public List<IGetStudentBasicDetailsModel> getStudents()
  {
    return students;
  }
  
  @JsonDeserialize(contentAs = GetStudentBasicDetailsModel.class)
  @Override
  public void setStudents(List<IGetStudentBasicDetailsModel> students)
  {
    this.students = students;
  }
  
}
