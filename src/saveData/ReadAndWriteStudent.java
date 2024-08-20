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
                data += student.getId() + "," + student.getName() + "," + student.getScore() + "," + student.getGender() + "," + student.getConduct() + "," + student.getClazzId() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Student> ReadStudent() {
        List<Student> studentsList = new ArrayList<Student>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String name = data[1];
                        double score = Double.parseDouble(data[2]);
                        String gender = data[3];
                        String conduct = data[4];
                        int classId = Integer.parseInt(data[5]);
                        Student student = new Student(id, name, score, gender, conduct, classId);
                        studentsList.add(student);
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println(line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return studentsList;
    }
}
