
  package com.app.factory;
  
  import com.app.dao.ActivityDao;
import com.app.dao.impl.ActivityImpl;

  
  public class ActivityFactory {
  
  public static ActivityDao getProject_ActivityDao() { return new
  ActivityImpl(); }
  
  }
 