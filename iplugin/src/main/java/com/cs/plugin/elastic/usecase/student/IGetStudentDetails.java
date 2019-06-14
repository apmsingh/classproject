package com.cs.plugin.elastic.usecase.student;

import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.plugin.elastic.base.IBaseElasticPlugin;

public interface IGetStudentDetails extends IBaseElasticPlugin<IGetStudentByIdModel, IGetStudentBasicDetailsModel> {
  
}
