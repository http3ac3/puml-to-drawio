package com.converter.puml;

import com.converter.puml.element.Element;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PumlFile {
    private final List<Element> elements = new ArrayList<>();
    private String data;
    public PumlFile(String filePath) {
        try {
            this.data = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Unable to read puml file by path: " + filePath);
        }
    }
    public void parse() {}
}
