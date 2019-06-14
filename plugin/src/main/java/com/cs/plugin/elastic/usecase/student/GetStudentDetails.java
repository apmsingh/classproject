package com.cs.plugin.elastic.usecase.student;

import java.util.Map;

import com.cs.database.base.execution.BaseExecutorElastic;
import com.cs.model.usecase.student.GetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.plugin.utils.dbutils.DbUtils;

@SuppressWarnings("rawtypes")
public class GetStudentDetails extends BaseExecutorElastic implements IGetStudentDetails {
  
  @Override
  public IGetStudentBasicDetailsModel executeRequest(IGetStudentByIdModel requestModel) throws Exception
  {
    Map<String, Object> executePlugin = executePlugin("student/" + requestModel.getId(), null, BaseExecutorElastic.METHOD_GET);
    Map<String, Object> sourceByRequest = DbUtils.getSourceByRequest(executePlugin);
     
    return mapper.convertValue(sourceByRequest, GetStudentBasicDetailsModel.class);
  }
  
}
