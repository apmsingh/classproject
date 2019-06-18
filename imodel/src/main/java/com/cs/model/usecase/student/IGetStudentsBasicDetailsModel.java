package com.cs.model.usecase.student;

import java.util.List;

import com.cs.model.base.IRuntimeModel;

public interface IGetStudentsBasicDetailsModel extends IRuntimeModel {
  
  public static final String STUDENTS = "students";
  
  public List<IGetStudentBasicDetailsModel> getStudents();
  public void setStudents(List<IGetStudentBasicDetailsModel> students);
  
}
