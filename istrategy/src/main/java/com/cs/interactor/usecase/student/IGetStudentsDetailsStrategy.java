package com.cs.interactor.usecase.student;

import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentsBasicDetailsModel;
import com.cs.strategy.base.IRuntimeBaseStrategy;

public interface IGetStudentsDetailsStrategy extends IRuntimeBaseStrategy<IGetStudentByIdModel, IGetStudentsBasicDetailsModel>{
  
}
