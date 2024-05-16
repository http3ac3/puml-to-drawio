package com.converter;

import com.converter.puml.PumlFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите путь до файла .puml: ");
        String path = new Scanner(System.in).nextLine();
        PumlFile pumlFile = new PumlFile(path);
        pumlFile.parse();
    }
}