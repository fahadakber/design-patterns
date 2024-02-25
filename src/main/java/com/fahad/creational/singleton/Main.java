package com.fahad.creational.singleton;

public class Main {
    public static void main(String[] args) {
//Class singleton

        ClassBasedSingleton classSingleton1 = ClassBasedSingleton.getInstance();
        //OurSingleton object1 = new OurSingleton(); // The constructor OurSingleton() is not visible

        System.out.println(classSingleton1.getInfo()); //Initial class info

        ClassBasedSingleton classSingleton2 = ClassBasedSingleton.getInstance();
        classSingleton2.setInfo("New class info");

        System.out.println(classSingleton1.getInfo()); //New class info
        System.out.println(classSingleton2.getInfo()); //New class info

        //Enum singleton

        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();

        System.out.println(enumSingleton1.getInfo()); //Initial enum info

        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");

        System.out.println(enumSingleton1.getInfo()); //New enum info
        System.out.println(enumSingleton2.getInfo()); //New enum info
    }
}
