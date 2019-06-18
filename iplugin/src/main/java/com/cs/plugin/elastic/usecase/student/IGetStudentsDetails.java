package com.cs.plugin.elastic.usecase.student;

import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentsBasicDetailsModel;
import com.cs.plugin.elastic.base.IBaseElasticPlugin;

public interface IGetStudentsDetails extends IBaseElasticPlugin<IGetStudentByIdModel, IGetStudentsBasicDetailsModel> {
  
}
