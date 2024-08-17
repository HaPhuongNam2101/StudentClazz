package manager;

import model.Student;
import saveData.ReadAndWriteClazz;
import saveData.ReadAndWriteStudent;

import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IManager<Student> {
    List<Student> studentsList;
    ReadAndWriteStudent readAndWriteStudent = new ReadAndWriteStudent();

    public StudentManager() {
        this.studentsList = this.readAndWriteStudent.ReadStudent();
    }
    @Override
    public void add(Student student) {
        studentsList.add(student);
        readAndWriteStudent.WriteStudent(studentsList);
    }

    @Override
    public void update(int id, Student student) {
        int index = findIndexById(id);
        studentsList.set(index, student);
        readAndWriteStudent.WriteStudent(studentsList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        studentsList.remove(index);
        readAndWriteStudent.WriteStudent(studentsList);
    }

    @Override
    public List<Student> getAll() {
        this.studentsList = this.readAndWriteStudent.ReadStudent();
        return this.studentsList;
    }

    @Override
    public int findIndexById(int id) {
       for (int i = 0; i < this.studentsList.size(); i++) {
           if (this.studentsList.get(i).getId() == id) {
               return i;
           }
       }
       return -1;
    }
    public List<Student> searchByScoreRange(double minScore, double maxScore) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.getScore() >= minScore && student.getScore() <= maxScore) {
                result.add(student);
            }
        }
        return result;
    }
}
