package com.san.amazon;

class Salary {
    int ta;
    int da;
    int hra;

    public Salary(int ta) {
        this.ta = ta;
    }

    public String toString() {
        return this.ta+"";
    }
}
class Employee {
    String name;
    Salary salary;

    public Employee(String name, Salary salary) {
        this.name = name;
        this.salary = salary;
    }
}
public class StringImmutability {

    public static void printSalary(Salary salary) {
        System.out.println(salary.ta);
        salary.ta = 100000;
    }

    public static void printEmployee(Employee e) {
        System.out.println(e.name + " "+e.salary);
        e.salary.ta = 3456;
    }

    public static void main(String[] args) {
        Employee e = new Employee("abcd", new Salary(1234));
        int[] arr = new int[5];
        System.out.println(arr.getClass().getCanonicalName());
        printEmployee(e);

        printSalary(e.salary);

        System.out.println(e.salary);
    }
}
