package com.td.tse.groupea;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;
    private String name;
    private List<String> nameList;
    private DataManager(){
        nameList = new ArrayList<>();
    }

    static public DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }


    public void addName(String name){
        this.nameList.add(name);
    }
}
