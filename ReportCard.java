package com.casii.droid.reportcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReportCard {

    private enum Course {Math, Science, Technology}

    private HashMap<Course, Integer> courseIndex;
    private List[] grades;
    private int year;

    public ReportCard(int year) {
        this.year = year;

        courseIndex = new HashMap<>();
        courseIndex.put(Course.Math, 0);
        courseIndex.put(Course.Science, 1);
        courseIndex.put(Course.Technology, 2);

        grades = new ArrayList[Course.values().length];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = new ArrayList<>();
        }
    }

    public int getYear() {
        return year;
    }

    public void addGrade(Course course, Double grade) {
	if(grade > 0)
	{
       	     grades[courseIndex.get(course)].add(grade);
	}
    }

    public void removeGrade(Course course, int position) {
        grades[courseIndex.get(course)].remove(position);
    }

    public List getCourseGrades(Course course) {
        return grades[courseIndex.get(course)];
    }

    public List[] getGrades() {
        return grades;
    }

    public void setGrades(List[] grades) {
        this.grades = grades;
    }

    public Double getLastCourseGrade(Course course) {
        return (Double) grades[courseIndex.get(course)].get(grades[courseIndex.get(course)].size() - 1);
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "year=" + year +
                ", courseIndex=" + courseIndex +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }
}
