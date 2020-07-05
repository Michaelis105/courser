package com.michael.courser.service;

import com.michael.courser.model.Class;

import java.util.List;

public interface ClassService {

    Class createClass(Class newClass);
    Class getClassById(Integer id);
    Class updateClassById(Integer id, Class modifiedClass);
    Class deleteClassById(Integer id);

    Class registerClassById(Integer id);
    Class deregisterClassById(Integer id);

    List<Class> getClassesByAttributes();
}
