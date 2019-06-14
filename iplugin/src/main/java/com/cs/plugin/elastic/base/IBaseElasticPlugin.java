package com.cs.plugin.elastic.base;

import com.cs.model.base.IModel;

public interface IBaseElasticPlugin<P extends IModel, R extends IModel> {
  
  public R executeRequest(P requestModel) throws Exception;
}
