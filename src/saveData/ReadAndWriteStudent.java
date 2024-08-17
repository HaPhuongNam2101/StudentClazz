package saveData;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStudent {
    private File file = new File("database/student.csv");

    public void WriteStudent(List<Student> studentsList) {
        try {
            String data = "";
            for (Student student : studentsList) {
                data += student.getId() + "," + student.getName() + "," + student.getScore()  + "," + student.getGender() + "," + student.getConduct() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Student> ReadStudent() {
        List<Student> studentsList = new ArrayList<Student>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                Student student = new Student(Integer.parseInt(data[0]),data[1],(data[2]),data[3],data[4],Integer.parseInt(data[5]));
                studentsList.add(student);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return studentsList;
    }
}
