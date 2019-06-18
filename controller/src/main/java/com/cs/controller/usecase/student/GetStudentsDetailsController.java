package com.cs.controller.usecase.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.interactor.usecase.student.IGetStudentsDetails;
import com.cs.model.usecase.student.GetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentsBasicDetailsModel;

@RestController
public class GetStudentsDetailsController {
  
  @Autowired
  IGetStudentsDetails getStudentsDetails;
  
  @RequestMapping(value = "/student/load", method = RequestMethod.GET)
  IGetStudentsBasicDetailsModel initializeDatabase() throws Exception
  {
    GetStudentByIdModel requestModel = new GetStudentByIdModel();
    return getStudentsDetails.executeInteractor(requestModel);
  }
  
}
