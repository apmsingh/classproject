package com.cs.controller.usecase.student;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.model.usecase.student.GetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;

@RestController
public class CreateStudentController {
  
  @RequestMapping(value = "/student/create", method = RequestMethod.POST)
  IGetStudentBasicDetailsModel initializeDatabase(@RequestBody GetStudentBasicDetailsModel requestModel) throws Exception
  {
    System.out.println("Request Deatils of Student");
    return requestModel;
  }
  
}
