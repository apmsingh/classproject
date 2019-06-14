package com.cs.strategy.base;

import com.cs.model.base.IModel;

public interface IBaseStrategy<P extends IModel, R extends IModel> {
  
  public R executeStrategy(P requestModel) throws Exception;
  
}
