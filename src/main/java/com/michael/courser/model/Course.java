package com.michael.courser.model;

import java.util.List;

/**
 * A course is a subject, area, or field of study as part of a curriculum or degree program.
 */
public class Course {

    private Integer courseId;
    private String subject;
    private Integer number;

    private String courseTitle;

    private Integer creditCount;

    private List<String> attributes;

    private String description;
    private String url;

    public Course(Integer courseId) {
        this(courseId, "SUBJ", 12345, "Some Title", 6, null, "No Description", "");
    }

    public Course(Integer courseId, String subject, Integer number, String courseTitle, int creditCount,
                  List<String> attributes) {
        this(courseId, subject, number, courseTitle, creditCount, attributes, "", "");
    }

    public Course(String subject, Integer number, String courseTitle, int creditCount,
                  List<String> attributes) {
        this(1234, subject, number, courseTitle, creditCount, attributes, "", "");
    }

    public Course(Integer courseId, String subject, Integer number, String courseTitle, int creditCount,
                  List<String> attributes, String description, String url) {
        this.courseId = courseId;
        this.subject = subject;
        this.number = number;
        this.courseTitle = courseTitle;
        this.creditCount = creditCount;
        this.attributes = attributes;
        this.description = description;
        this.url = url;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", subject='" + subject + '\'' +
                ", number='" + number + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", creditCount=" + creditCount +
                ", attributes=" + attributes +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
