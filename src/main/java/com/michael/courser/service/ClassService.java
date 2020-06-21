package com.michael.courser.service;

import com.michael.courser.model.Class;

import java.util.List;

public interface ClassService {

    Class createClass(Class newClass);
    Class getClassById(String id);
    Class updateClassById(String id, Class modifiedClass);
    Class deleteClassById(String id);

    Class registerClassById(String id);
    Class deregisterClassById(String id);

    List<Class> getClassesByAttributes();
}
