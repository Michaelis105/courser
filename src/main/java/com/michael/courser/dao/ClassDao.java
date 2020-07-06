package com.michael.courser.dao;

import com.michael.courser.model.Class;

import java.util.List;

public interface ClassDao {

    Integer createClass(Class newClass);
    Class getClassById(Integer id);
    List<Class> getClassesByAttributes(Integer id);
    void updateClassById(Integer id, Class modifiedClass);
    void deleteClassById(Integer id);

}
