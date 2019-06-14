package com.cs.interactor.base;

import com.cs.model.base.IModel;

public interface IBaseInteractor<P extends IModel, R extends IModel> {
  
  public R executeInteractor(P requestModel) throws Exception;
  
}
