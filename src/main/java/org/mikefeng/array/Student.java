package org.mikefeng.array;

public class Student {
    private String name;

    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student(name=" + name + ", score=" + score + ")";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("jack", 90));
        arr.addLast(new Student("rose", 95));
        arr.addLast(new Student("lucy", 88));
        arr.addLast(new Student("tom", 99));
        System.out.println(arr);
    }
}
