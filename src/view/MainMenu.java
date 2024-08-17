package view;

import input.Input;

public class MainMenu {
    ClazzMenu clazzMenu = new ClazzMenu();
    StudentMenu studentMenu = new StudentMenu();

    public void showMainMenu(){
        int choice;
        do {
            System.out.println("===== Menu chính =====");
            System.out.println("1.Quản lí sinh viên ");
            System.out.println("2.Quản lí lớp học");
            System.out.println("0.Thoát ");
            System.out.println("Nhập lựa chọn: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    studentMenu.showStudentMenu();
                    break;
                case 2:
                    clazzMenu.showClazzMenu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình! ");
                default:
                    System.out.println("Không có lư chọn phù hợp ");
                    break;
            }
        } while(choice != 0);
    }
}
