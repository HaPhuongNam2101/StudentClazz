package manager;

import model.Clazz;
import saveData.ReadAndWriteClazz;

import java.util.ArrayList;
import java.util.List;

public class ClazzManager implements IManager<Clazz> {
    private List<Clazz> clazzList;
    private ReadAndWriteClazz readAndWriteClazz = new ReadAndWriteClazz();
    public ClazzManager() {
        this.clazzList = readAndWriteClazz.ReadClazz();
    }
    @Override
    public void add(Clazz clazz) {
        clazzList.add(clazz);
        readAndWriteClazz.WriteClazz(clazzList);
    }

    @Override
    public void update(int id, Clazz clazz) {
            int index = findIndexById(id);
            clazzList.set(index, clazz);
            readAndWriteClazz.WriteClazz(clazzList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        clazzList.remove(index);
        readAndWriteClazz.WriteClazz(clazzList);
    }

    @Override
    public List<Clazz> getAll() {
        this.clazzList = readAndWriteClazz.ReadClazz();
        return this.clazzList;
    }

    @Override
    public int findIndexById(int id) {
       for (int i = 0; i < clazzList.size(); i++) {
           if (clazzList.get(i).getId() == id) {
               return i;
           }
       }
       return -1;
    }
    public Clazz findClazzById (int id) {
        int index = findIndexById(id);
        return clazzList.get(index);
    }


    public int getIdClazz(int index) {
        List<Clazz> clazzList = getAll();
        Clazz clazz = clazzList.get(index);
        return clazz.getId();
    }
}
