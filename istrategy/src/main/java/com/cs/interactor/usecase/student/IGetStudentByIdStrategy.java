package com.cs.interactor.usecase.student;

import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.strategy.base.IRuntimeBaseStrategy;

public interface IGetStudentByIdStrategy extends IRuntimeBaseStrategy<IGetStudentByIdModel, IGetStudentBasicDetailsModel>{
  
}
