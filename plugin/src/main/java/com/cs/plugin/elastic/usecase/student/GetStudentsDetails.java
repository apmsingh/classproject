package com.cs.plugin.elastic.usecase.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.database.base.execution.BaseExecutorElastic;
import com.cs.model.usecase.student.GetStudentsBasicDetailsModel;
import com.cs.model.usecase.student.IGetStudentByIdModel;
import com.cs.model.usecase.student.IGetStudentsBasicDetailsModel;
import com.cs.plugin.utils.dbutils.DbUtils;

@SuppressWarnings("rawtypes")
public class GetStudentsDetails extends BaseExecutorElastic implements IGetStudentsDetails {
  
  @Override
  public IGetStudentsBasicDetailsModel executeRequest(IGetStudentByIdModel requestModel) throws Exception
  {
    Map<String, Object> executePlugin = executePlugin("student/_search?sort=id", null, BaseExecutorElastic.METHOD_GET);
    Map<String, Object> outerHits = (Map<String, Object>) executePlugin.get("hits");
    List<Map<String, Object>> listOfHits = (List<Map<String, Object>>) outerHits.get("hits");
    
    List<Map<String, Object>> studentsListOfData = new ArrayList<>();
    for (Map<String, Object> dataOfEachStudent : listOfHits) {
      studentsListOfData.add(DbUtils.getSourceByRequest(dataOfEachStudent));
    }
    
    Map<String, Object> returnMap = new HashMap<>();
    returnMap.put(IGetStudentsBasicDetailsModel.STUDENTS, studentsListOfData);
    return mapper.convertValue(returnMap, GetStudentsBasicDetailsModel.class);
  }
  
}
