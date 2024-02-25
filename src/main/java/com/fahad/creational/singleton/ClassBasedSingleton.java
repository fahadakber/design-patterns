package com.fahad.creational.singleton;

public class ClassBasedSingleton {
    private static ClassBasedSingleton instance;
    private String info = "Initial class info";

    private ClassBasedSingleton(){
    }

    public synchronized static ClassBasedSingleton getInstance(){
        if(instance == null){
            instance = new ClassBasedSingleton();
        }

        return instance;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
