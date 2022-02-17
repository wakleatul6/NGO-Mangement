package com.app.dao;

import java.util.List;

import com.app.bean.Activity;

public interface ActivityDao {
int updateData(Activity emp);
int insertData(Activity emp);
int deleteData(int id);
List<Activity>listActivity();
List<Activity> getActivity(int id);
}
