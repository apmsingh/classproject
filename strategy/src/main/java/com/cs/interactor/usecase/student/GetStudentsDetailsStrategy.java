package com.cs.interactor.usecase.student;

import org.springframework.stereotype.Component;

import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentsBasicDetailsModel;
import com.cs.plugin.elastic.usecase.student.GetStudentsDetails;
import com.cs.plugin.elastic.usecase.student.IGetStudentsDetails;

@Component
public class GetStudentsDetailsStrategy implements IGetStudentsDetailsStrategy {

  @Override
  public IGetStudentsBasicDetailsModel executeStrategy(IGetStudentByIdModel requestModel) throws Exception
  {
    IGetStudentsDetails getStudentDetails = new GetStudentsDetails();
    return getStudentDetails.executeRequest(requestModel);
  }

  
}
