package com.michael.courser.dao;

import com.michael.courser.model.Class;

import java.util.List;

public interface ClassDao {

    Integer createClass(Class newClass);
    Class getClassById(Integer id);
    List<Class> getClassesByAttributes(String courseId, String instructor, String days, String beginTime, String endTime, Boolean isAvailable);
    List<Class> getClassesByCourseNumber(String courseNumber);
    void updateClassById(Integer id, Class modifiedClass);
    void deleteClassById(Integer id);

}
