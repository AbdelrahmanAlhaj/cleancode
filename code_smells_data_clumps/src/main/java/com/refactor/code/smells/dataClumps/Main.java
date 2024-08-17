package com.refactor.code.smells.dataClumps;

public class Main {
    public static void main(String args[]){
        int foo = 13;
        System.out.println(foo); // this will print "13"

        setFoo(foo);
        System.out.println(foo); // this will still print "13"
    }

    public static void setFoo(int bar){
        bar = 2;
    }
}
