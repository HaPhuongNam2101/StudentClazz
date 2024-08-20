package view;

import input.Input;
import manager.ClazzManager;
import manager.StudentManager;
import model.Clazz;
import model.Student;
import validate.Regex;

import java.util.List;

public class StudentMenu {
    private StudentManager studentManager = new StudentManager();
    private ClazzManager clazzManager = new ClazzManager();

    public void showStudentMenu() {
        int choice;
        do{
            System.out.println("===== Quản lý sinh viên =====");
            System.out.println("1. Thêm mới sinh viên ");
            System.out.println("2. Sửa thông tin sinh viên ");
            System.out.println("3. Xóa sinh viên ");
            System.out.println("4. Hiển thị danh sách sinh viên ");
            System.out.println("5. Tìm kiếm theo khoảng điểm");
            System.out.println("6. Tìm kiếm theo hạnh kiểm");
            System.out.println("7. Tìm kiếm theo lớp");
            System.out.println("8. Tìm sinh viên có điểm cao nhất");
            System.out.println("9. Sắp xếp danh sách sinh viên");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Input.inputNumber();
            switch(choice) {
                case 1:
                    showAddStudentMenu();
                    break;
                case 2:
                    showEditStudentMenu();
                    break;
                case 3:
                    showDeleteStudentMenu();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    showSearchByScoreMenu();
                    break;
                case 6:
                    showSearchByConductMenu();
                    break;
                case 7:
                    showSearchByClazzMenu();
                    break;
                case 8:
                    showSearchTopStudentMenu();
                    break;
                case 9:
                    showSortStudentsMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn! ");
            }
        } while(choice != 0);
    }

    public void showAddStudentMenu() {
        System.out.println("===== Thêm mới sinh viên ===== ");
        String name = Regex.validateName();
        System.out.println("Nhập điểm sinh viên ");
        double score = Input.inputNumber();
        System.out.println("Nhập giới tính sinh viên: ");
        String gender = Input.inputString();
        System.out.println("Nhập hạnh kiểm sinh viên: ");
        String conduct = Input.inputString();
        System.out.println("Nhập mã lớp: ");
        int clazzId = Input.inputNumber();
        Student student = new Student(name, score, gender, conduct, clazzId);
        studentManager.add(student);
        System.out.println("Thêm sinh viên thành công ");
    }
    public void showEditStudentMenu() {
        System.out.println("===== Sửa thông tin sinh viên =====");
        System.out.println("Nhập id muỗn sửa: ");
        int idEdit = Input.inputNumber();
        int index = studentManager.findIndexById(idEdit);
        if(index == -1) {
            System.out.println("Sinh viên không tồn tại!");
            return;
        }
        System.out.println("Nhập tên mới: ");
        String name = Regex.validateName();
        System.out.println("Nhập điểm mới: ");
        double score = Input.inputNumber();
        System.out.println("Nhập giới tính mới: ");
        String gender = Input.inputString();
        System.out.println("Nhập hạnh kiểm mới: ");
        String conduct = Input.inputString();
        System.out.println("Nhập mã lớp mới: ");
        int clazzId = Input.inputNumber();
        Student student = new Student(name, score, gender, conduct, clazzId);
        studentManager.update(idEdit, student);
        System.out.println("Sửa thành công ");
    }
    public void showDeleteStudentMenu() {
        System.out.println("===== Xóa sinh viên =====");
        System.out.println("Nhập id sinh viên: ");
        int id = Input.inputNumber();
        studentManager.delete(id);
        System.out.println("Xóa sinh viên thành công.");
    }
    public void displayAllStudents() {
        System.out.println("===== Danh sách sinh viên =====");
        List<Student> students = studentManager.getAll();
        for(Student student : students) {
            System.out.println(student);
        }
    }
    public void showSearchByScoreMenu() {
        System.out.println("===== Tìm kiếm sinh viên theo khoảng điểm =====");
        System.out.println("Nhập điểm tối thiểu: ");
        double minScore = Input.inputNumber();
        System.out.println("Nhập điểm tối đa: ");
        double maxScore = Input.inputNumber();
        List<Student> students = studentManager.searchByScoreRange(minScore, maxScore);
        students.forEach(System.out::println);
    }
    public void showSearchByConductMenu() {
        System.out.println("===== Tìm kiếm sinh viên theo hạnh kiểm =====");
        System.out.println("Nhập hạnh kiểm: ");
        String conduct = Input.inputString();
        List<Student> students = studentManager.searchByConduct(conduct);
        if (students.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên với hạnh kiểm này.");
        } else {
            students.forEach(System.out::println);
        }
    }
    public void showSearchByClazzMenu() {
        System.out.println("===== Tìm kiếm sinh viên theo lớp =====");
        System.out.println("Danh sách các lớp: ");
        List<Clazz> clazzList = clazzManager.getAll(); // Assuming ClazzManager has a method to get all classes
        for (Clazz clazz : clazzList) {
            System.out.println("Mã lớp: " + clazz.getId() + ", Tên lớp: " + clazz.getName());
        }
        System.out.println("Nhập mã lớp: ");
        int clazzId = Input.inputNumber();
        List<Student> students = studentManager.searchByClazz(clazzId);
        students.forEach(System.out::println);
    }
    public void showSearchTopStudentMenu() {
        System.out.println("===== Tìm sinh viên có điểm cao nhất =====");
        Student topStudent = studentManager.findTopStudent();
        if (topStudent != null) {
            System.out.println(topStudent);
        } else {
            System.out.println("Không có sinh viên nào.");
        }
    }
    public void showSortStudentsMenu() {
        System.out.println("===== Sắp xếp danh sách sinh viên =====");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo điểm");
        System.out.println("Nhập lựa chọn: ");
        int sortChoice = Input.inputNumber();
        switch (sortChoice) {
            case 1:
                studentManager.sortByName();
                break;
            case 2:
                studentManager.sortByScore();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        displayAllStudents();
    }
}
