package com.cs.interactor.usecase.student;

import org.springframework.stereotype.Component;

import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.plugin.elastic.usecase.student.GetStudentDetails;
import com.cs.plugin.elastic.usecase.student.IGetStudentDetails;

@Component
public class GetStudentByIdStrategy implements IGetStudentByIdStrategy {

  @Override
  public IGetStudentBasicDetailsModel executeStrategy(IGetStudentByIdModel requestModel) throws Exception
  {
    IGetStudentDetails getStudentDetails = new GetStudentDetails();
    return getStudentDetails.executeRequest(requestModel);
  }

  
}
