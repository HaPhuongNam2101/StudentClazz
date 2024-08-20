package view;

import input.Input;
import manager.ClazzManager;
import model.Clazz;

import java.util.List;

public class ClazzMenu {
    private ClazzManager clazzManager = new ClazzManager();
    public void showClazzMenu() {
        int choice;
        do {
            System.out.println("===== Quản lý lớp =====");
            System.out.println("1. Thêm mới lớp ");
            System.out.println("2. Sửa thông tin  lớp ");
            System.out.println("3. Xóa lớp ");
            System.out.println("4. Hiển thị danh sách lớp");
            System.out.println("0. Thoát chương trình ");
            System.out.println("Vui lòng nhập lựa chọn ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showAddClazzMenu();
                    break;
                case 2:
                    showEditClazzMenu();
                    break;
                case 3:
                    showDeleteClazzMenu();
                    break;
                case 4:
                    showAllClazzMenu();
            }
        } while (choice != 0);
    }

    private void showAddClazzMenu() {
        System.out.println("===== Thêm mới lớp =====");
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        System.out.println("Nhập khối: ");
        String unit = Input.inputString();
        Clazz clazz = new Clazz(name, unit);
        clazzManager.add(clazz);
        System.out.println("Thêm thành công ");
    }
    public void showAllClazzMenu() {
        System.out.println("===== Danh sách lớp =====");
        List<Clazz> classList = clazzManager.getAll();
        for (Clazz clazz : classList) {
            System.out.println(clazz);
        }
    }
    public void showEditClazzMenu() {
        System.out.println("===== Sửa thông tin lớp ===== ");
        System.out.println("Nhập id muốn sửa: ");
        int idEdit = Input.inputNumber();
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        System.out.println("Nhập khối: ");
        String unit = Input.inputString();
        Clazz clazz = new Clazz(idEdit,name, unit);
        clazzManager.update(idEdit, clazz);
        System.out.println("Sửa thành công ");
    }
    public void showDeleteClazzMenu() {
        System.out.println("===== Xóa lớp =====");
        int idDelete = Input.inputNumber();
        clazzManager.delete(idDelete);
        System.out.println("Xóa thành công ");
    }
}
