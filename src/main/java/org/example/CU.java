package org.example;


import java.util.ArrayList;

public class CU {
    private String nameCU;
    private ArrayList<Mark> marks;
    private int totalStudents;

    public CU(String nameCU,int totalStudents) {
        this.nameCU = nameCU;
        this.marks = new ArrayList<>();
        this.totalStudents = totalStudents;
    }

    public void insertMarkCU(int numStudent, double mark) {
        if (marks.size() < totalStudents) {
            Mark newMark = new Mark(numStudent, mark);
            marks.add(newMark);
        }
    }

    public double averageCU() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Mark mark : marks) {
            sum += mark.getMark();
        }
        return sum / marks.size();
    }

    public boolean isApproved(int numStudent) {
        for (Mark mark : marks) {
            if (mark.getNumStudent() == numStudent) {
                return mark.getMark() >= 9.5;
            }
        }
        return false;
    }



    public double searchStudent(int numStudent) {
        for (Mark mark : marks) {
            if (mark.getNumStudent() == numStudent) {
                return mark.getMark();
            }
        }
        return -1;
    }
}