package com.creat.people.controller;

import com.creat.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
public class HistoryController<E> {

    public void saveHistory(E history,String path) throws IOException {
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        if(!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        ObjectOutputStream objectOut = null;
        if(file.length() < 1){
            objectOut = new ObjectOutputStream(new FileOutputStream(file,true));
        }else {
            objectOut = new MyObjectOutputStream(new FileOutputStream(file,true));
        }
        objectOut.writeObject(history);
        objectOut.flush();
        objectOut.close();
    }

    public List<E> readAllHistories(String path) throws IOException, ClassNotFoundException {
        List<E> list = new ArrayList<E>();
        File file = new File(path);
        if(!file.exists()){
            return list;
        }
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));
        Object o= null;
        try {
            while((o=objectInput.readObject()) != null){
                list.add((E) o);
            }
        }catch (Exception e){
            //e.printStackTrace();
            //不做任何处理
        }finally {
            objectInput.close();
        }
        return list;
    }

}
