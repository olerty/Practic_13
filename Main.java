package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество студентов для 1 задачи:");
        int cnt = scan.nextInt();
        Test test1 = new Test(cnt);
        System.out.println("Введите количество 1 группы студентов для 2 задачи:");
        int cnt1 = scan.nextInt();
        System.out.println("Введите количество 2 группы студентов для 2 задачи:");
        int cnt2 = scan.nextInt();
        SortingStudentsByGPA sortStud = new SortingStudentsByGPA(cnt1, cnt2);
    }
}
