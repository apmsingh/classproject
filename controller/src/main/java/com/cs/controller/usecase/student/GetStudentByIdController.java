package com.cs.controller.usecase.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.interactor.usecase.student.IGetStudentById;
import com.cs.model.usecase.student.GetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;

@RestController
public class GetStudentByIdController {
  
  @Autowired
  IGetStudentById getStudentById;
  
  @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
  IGetStudentBasicDetailsModel initializeDatabase(@PathVariable String studentId) throws Exception
  {
    GetStudentByIdModel requestModel = new GetStudentByIdModel();
    requestModel.setId(studentId);
    return getStudentById.executeInteractor(requestModel);
  }
  
}
