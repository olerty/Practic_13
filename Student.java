package com.company;

public class Student{
   private  String name;
   private  double marks;
   private  int id;

    public Student(String name, double marks, int id) {
        this.name = name;
        this.marks = marks;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", id=" + id +
                '}';
    }
}
