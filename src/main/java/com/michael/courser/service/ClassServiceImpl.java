package com.michael.courser.service;

import com.michael.courser.model.Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final Logger _log = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Override
    public Class createClass(Class newClass) {
        _log.trace("Enter...", newClass);
        // TODO: IMPLEMENT
        Class dummyClass = new Class("CREATE" + newClass.getClassId());
        _log.trace("Exit...");
        return dummyClass;
    }

    @Override
    public Class getClassById(String id) {
        _log.trace("Enter...", id);
        // TODO: IMPLEMENT
        Class dummyClass = new Class("GET" + id);
        _log.trace("Exit...");
        return dummyClass;
    }

    @Override
    public Class updateClassById(String id, Class modifiedClass) {
        _log.trace("Enter...", id, modifiedClass);
        // TODO: IMPLEMENT
        Class dummyClass = new Class("UPDATE" + id);
        _log.trace("Exit...");
        return dummyClass;
    }

    @Override
    public Class deleteClassById(String id) {
        _log.trace("Enter...", id);
        // TODO: IMPLEMENT
        Class dummyClass = new Class("DELETE" + id);
        _log.trace("Exit...");
        return dummyClass;
    }

    @Override
    public Class registerClassById(String id) {
        _log.trace("Enter...", id);
        // TODO: IMPLEMENT
        Class dummyClass = new Class("REG" + id);
        _log.trace("Exit...");
        return dummyClass;
    }

    @Override
    public Class deregisterClassById(String id) {
        _log.trace("Enter...", id);
        // TODO: IMPLEMENT
        Class dummyClass = new Class("UNREG" + id);
        _log.trace("Exit...");
        return dummyClass;
    }

    @Override
    public List<Class> getClassesByAttributes() {
        _log.trace("Enter...");
        List<Class> classList = new LinkedList<>();
        classList.add(new Class("1"));
        classList.add(new Class("2"));
        classList.add(new Class("3"));
        _log.trace("Exit...");
        return classList;
    }
}
