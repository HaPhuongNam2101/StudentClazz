package model;

public class Clazz {
    private int id;
    private String name;
    private String unit;
    private static int idIncrement = 1;

    public Clazz( String name, String unit) {
        this.id = idIncrement;
        this.name = name;
        this.unit = unit;
        idIncrement++;
    }

    public Clazz(int id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Lớp học "+ " | Mã lớp học " + id + " | Tên lớp " + name + " | Khối lớp  " + unit ;
    }
}
