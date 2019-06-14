package com.cs.interactor.usecase.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentByIdModel;

@Component
public class GetStudentById implements IGetStudentById {

  @Autowired
  IGetStudentByIdStrategy getStudentByIdStrategy;
  
  @Override
  public IGetStudentBasicDetailsModel executeInteractor(IGetStudentByIdModel requestModel) throws Exception
  {
    return getStudentByIdStrategy.executeStrategy(requestModel);
  }
  
}
