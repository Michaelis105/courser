package com.michael.courser.dao;

import com.michael.courser.model.Class;

import java.util.List;

public interface ClassDao {

    Integer createClass(Class newClass);
    Class getClassById(Integer id);
    List<Class> getClassesByAttributes(String courseId, String instructor, List<Character> days, String beginTime, String endTime, Boolean isAvailable);
    void updateClassById(Integer id, Class modifiedClass);
    void deleteClassById(Integer id);

}
