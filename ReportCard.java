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
        grades[courseIndex.get(course)].add(grade);
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

    public String toString() {
        return "ReportCard{" +
                "year=" + year +
                ", courseIndex=" + courseIndex +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }

    public static void main() {
        // Test
        List[] list = new ArrayList[3];
        List mathList = new ArrayList();
        List scienceList = new ArrayList();
        List technologyList = new ArrayList();

        mathList.add(9.3);
        scienceList.add(5.0);
        technologyList.add(4.4);
        technologyList.add(8.4);

        list[0] = (mathList);
        list[1] = (scienceList);
        list[2] = (technologyList);

        ReportCard reportCard = new ReportCard(0);
        reportCard.setGrades(list);
        reportCard.addGrade(Course.Science, 6.7);
        reportCard.addGrade(Course.Math, 8.7);
        reportCard.addGrade(Course.Math, 9.9);
        reportCard.addGrade(Course.Math, 5.0);
        reportCard.addGrade(Course.Math, 10.0);
        reportCard.removeGrade(Course.Math, 2);

        System.out.println(reportCard.toString());
        System.out.println("last math grade: " + reportCard.getLastCourseGrade(Course.Math));
        System.out.println("math grades: " + reportCard.getCourseGrades(Course.Math));
        System.out.println("year: " + reportCard.getYear());

    }
}
