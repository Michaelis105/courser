package com.michael.courser.service;

import com.michael.courser.dao.ClassDao;
import com.michael.courser.dao.CourseDao;
import com.michael.courser.dao.ScheduleDao;
import com.michael.courser.dao.StudentDao;
import com.michael.courser.model.*;
import com.michael.courser.model.Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final Logger _log = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Autowired
    ClassDao classDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public Schedule createSchedule(Schedule newCourse) {
        _log.trace("Enter...", newCourse);
        Schedule schedule = null;
        _log.trace("Exit...");
        return schedule;
    }

    private boolean satisfiesRules(Course c, List<Rule> rules) {
        for (Rule r : rules) {
            if (!r.doesCourseSatisfyRule(c)) return false;
        }
        return true;
    }

    private boolean satisfiesRules(Class c, List<Rule> rules) {
        for (Rule r : rules) {
            if (!r.doesClassSatisfyRule(c)) return false;
        }
        return true;
    }

    @Override
    public Schedule createScheduleByRules(Integer degreeId, Integer minCredit, Integer maxCredit, List<Rule> rules) {
        _log.trace("Enter...", degreeId);

        List<Course> courseList = scheduleDao.getCoursesByDegreeRequirements(degreeId);
        List<Grade> takenCourses = studentDao.getGradesByStudentId(1);

        Set<Integer> takenCourseIds = new HashSet<>();
        for (Grade g : takenCourses) {
            takenCourseIds.add(g.getCourseId());
        }

        // Filter out courses not applicable or eligible for scheduling.
        Iterator<Course> itrc = courseList.iterator();
        while (itrc.hasNext()) {

            Course c = itrc.next();

            // Filter out courses already taken.
            if (takenCourseIds.contains(c.getCourseId())) {
                itrc.remove();
                continue;
            }

            // Filter eligible courses per prerequisites.
            // If some degree required course A has prereq for some course B not yet credited, then remove course A.
            Set<Integer> preReqsLookup = new HashSet<>();
            preReqsLookup.addAll(c.getPrerequisiteIds());
            if (!takenCourseIds.containsAll(preReqsLookup)) {
                itrc.remove();
                continue;
            }

            if (!satisfiesRules(c, rules)) {
                itrc.remove();
                continue;
            }
        }

        List<Class> classesCart = new LinkedList<>();
        itrc = courseList.iterator();
        int totalCredit = 0;
        while (itrc.hasNext() && totalCredit < maxCredit) {
            Course c = itrc.next();
            if (totalCredit + c.getCreditCount() <= maxCredit) {
                continue;
            }
            List<Class> classList = classDao.getClassesByAttributes(String.valueOf(c.getNumber()), "", "", "", "", true);
            for (Class cl : classList) {
                if (satisfiesRules(cl, rules)) {
                    classesCart.add(cl);
                    totalCredit += c.getCreditCount();
                    break;
                }
            }
        }

        Schedule schedule = new Schedule(-1, -1, classesCart);

        _log.trace("Exit...");
        return schedule;
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        _log.trace("Enter...", id);
        // TODO: IMPLEMENT
        Schedule dummySchedule = null;
        _log.trace("Exit...");
        return dummySchedule;
    }

    @Override
    public Schedule updateScheduleById(Integer id, Schedule modifiedSchedule) {
        _log.trace("Enter...", id, modifiedSchedule);
        // TODO: IMPLEMENT
        Schedule dummySchedule = null;
        _log.trace("Exit...");
        return dummySchedule;
    }

    @Override
    public Schedule deleteScheduleById(Integer id) {
        _log.trace("Enter...", id);
        // TODO: IMPLEMENT
        Schedule dummySchedule = null;
        _log.trace("Exit...");
        return dummySchedule;
    }
}
