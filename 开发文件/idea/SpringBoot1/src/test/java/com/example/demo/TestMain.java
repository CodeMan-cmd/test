package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) {
        List list = new ArrayList();
        Random ra = new Random();
        for (int i = 1; i <= 30; i++) {
            System.out.println(ra.nextInt(10));
            list.add(1);
        }
            System.out.println(list.get(2));
    }
}
