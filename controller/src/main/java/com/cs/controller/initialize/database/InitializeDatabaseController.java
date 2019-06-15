package com.cs.controller.initialize.database;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.model.initialize.database.InitializeDatabaseModel;

@RestController
public class InitializeDatabaseController {
  
  @RequestMapping(value = "/initialize", method = RequestMethod.POST)
  void initializeDatabase(@RequestBody InitializeDatabaseModel model)
  {
    
  }
  
}
