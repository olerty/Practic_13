package com.company;

import java.net.IDN;
import java.util.*;

public class SortingStudentsByGPA {
    public ArrayList<Student> IDNumber1 = new ArrayList<>();
    public ArrayList<Student> IDNumber2 = new ArrayList<>();
    private StudentComparator comparator = new StudentComparator();

    SortingStudentsByGPA(int cnt1, int cnt2) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите данные 1 группы студентов для 2 задачи:");
        for (int i = 0; i < cnt1; i++) {
            IDNumber1.add(new Student(scan.next(), scan.nextDouble(), scan.nextInt()));
        }
        System.out.println("Введите данные 2 группы студентов для 2 задачи:");
        for (int i = 0; i < cnt2; i++) {
            IDNumber2.add(new Student(scan.next(), scan.nextDouble(), scan.nextInt()));
        }

        System.out.println("1 массив:");
        out(IDNumber1);
        System.out.println("2 массив:");
        out(IDNumber2);

        Collections.sort(IDNumber1, new StudentComparator());
        System.out.println("1 отсортированный массив:");
        out(IDNumber1);

        if (IDNumber2.size() == 2) {
            if (comparator.compare(IDNumber2.get(0), IDNumber2.get(1)) == 1) {
                Student def = IDNumber2.get(0);
                IDNumber2.set(0, IDNumber2.get(1));
                IDNumber2.set(1, def);
            }
        }
        else {
            mergeSort(IDNumber2, IDNumber2.size() - 1);
        }
        System.out.println("2 отсортированный массив:");
        out(IDNumber2);

        for (int i = 0; i < IDNumber2.size(); i++) {
            IDNumber1.add(IDNumber2.get(i));
        }
        Collections.sort(IDNumber1, new StudentComparator());
        System.out.println("Итоговый отсортированный массив:");
        out(IDNumber1);
    }

    public void mergeSort(ArrayList<Student> a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        ArrayList<Student> l = new ArrayList<>();
        ArrayList<Student> r = new ArrayList<>();
        for (int i = 0; i < mid + 1; i++) {
            l.add(a.get(i));
        }
        for (int i = n - mid; i < n; i++) {
            r.add(a.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public void merge(ArrayList<Student> a, ArrayList<Student> l, ArrayList<Student>r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l.get(i), r.get(j)) == 1) {
                a.set(k++,r.get(j++));
            }
            else {
                a.set(k++, l.get(i++));
            }
        }
        while (i < left) {
            a.set(k++, l.get(i++));
        }
        while (j < right) {
            a.set(k++,r.get(j++));
        }
    }

    public void out(ArrayList<Student> array) {
        for (Student student:array){
            System.out.println(student.toString());
        }
    }
}
