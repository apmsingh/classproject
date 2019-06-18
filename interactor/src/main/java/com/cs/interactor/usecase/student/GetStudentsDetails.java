package com.cs.interactor.usecase.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentsBasicDetailsModel;

@Component
public class GetStudentsDetails implements IGetStudentsDetails {

  @Autowired
  IGetStudentsDetailsStrategy getStudentsDetailsStrategy;
  
  @Override
  public IGetStudentsBasicDetailsModel executeInteractor(IGetStudentByIdModel requestModel) throws Exception
  {
    return getStudentsDetailsStrategy.executeStrategy(requestModel);
  }
  
}
