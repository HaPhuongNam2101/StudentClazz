package model;

public class Student {
    private int id;
    private String name;
    private double score;
    private String gender;
    private String conduct;
    private int clazzId;
    private static int  idIncrement = 1;

    public Student(String name, double score, String gender, String conduct, int clazzId) {
        this.id = idIncrement++;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.conduct = conduct;
        this.clazzId = clazzId;
    }

    public Student(int id, String name, double score, String gender, String conduct, int clazzId) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.conduct = conduct;
        this.clazzId = clazzId;
    }

    public Student(int id, String datum, String datum1, String datum2, String datum3, int clazzId) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public String toString() {
        return " Sinh viên " + " | Mã sinh viên " + id + " | Tên sinh viên " + name + " | Điểm sinh viên " + score + " | Giới tính " + gender + " | Hạnh kiểm  " + conduct;
    }
}
