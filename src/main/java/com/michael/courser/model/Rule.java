package com.michael.courser.model;

import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Rule {

    String want;
    String[] subject;
    String course;
    String[] day;
    String timeRel;
    Integer time;
    Integer beforeTime;
    Integer afterTime;

    public Rule(String want, String[] subject, String course, String[] day, String timeRel, Integer time, Integer beforeTime, Integer afterTime) {
        this.want = want;
        this.subject = subject;
        this.course = course;
        this.day = day;
        this.timeRel = timeRel;
        this.time = time;
        this.beforeTime = beforeTime;
        this.afterTime = afterTime;
    }

    public String getWant() { return want; }

    public void setWant(String want) { this.want = want; }

    public String[] getSubject() { return subject; }

    public void setSubject(String[] subject) { this.subject = subject; }

    public String getCourse() { return course; }

    public void setCourse(String course) { this.course = course; }

    public String[] getDay() { return day; }

    public void setDay(String[] day) { this.day = day; }

    public String getTimeRel() { return timeRel; }

    public void setTimeRel(String timeRel) { this.timeRel = timeRel; }

    public Integer getTime() { return time; }

    public void setTime(Integer time) { this.time = time; }

    public Integer getBeforeTime() { return beforeTime; }

    public void setBeforeTime(Integer beforeTime) { this.beforeTime = beforeTime; }

    public Integer getAfterTime() { return afterTime; }

    public void setAfterTime(Integer afterTime) { this.afterTime = afterTime; }

    public boolean doesClassSatisfyRule(Class c) {
        String sub = c.getAttributes().get("subject");
        for (String subj : subject) {
            if (sub.equals(subj) || sub.equals("any")) {
                for (ClassTime ct : c.getClassTimes()) {
                    for (String da : day) {
                        if (da.equals(ct.getDay().getDisplayName(TextStyle.FULL, Locale.getDefault()))) {

                            LocalTime st = ct.getStartTime();
                            LocalTime et = ct.getEndTime();
                            int stc = st.getHour()*100 + st.getMinute();
                            int etc = et.getHour()*100 + et.getMinute();

                            switch (timeRel) {
                                case "any":
                                    return true;
                                case "b":
                                    if (stc <= time && etc <= time) return true;
                                    break;
                                case "a":
                                    if (stc >= time && etc >= time) return true;
                                    break;
                                case "tr":
                                    if (stc >= beforeTime && etc <= afterTime) return true;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean doesCourseSatisfyRule(Course c) {
        boolean meets = false;
        for (String s : subject) {
            if (s == c.getSubject() || s == "any") {
                meets = true;
                break;
            }
        }

        meets &= Integer.getInteger(course) == c.getNumber();

        return meets;
    }


}
