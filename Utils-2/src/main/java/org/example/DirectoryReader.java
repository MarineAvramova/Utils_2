package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryReader {
    public static void readFolders(File root) {
        File[] files = root.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No elements in the current folder");
        } else {
            Arrays.sort(files, Comparator.comparing(File::getName));
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
    public static void listDirectoryTree(Path root) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Files.walk(root)
                .sorted(Comparator.comparing(Path::toString))
                .forEach(path -> {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                        String type = attrs.isDirectory() ? "D" : "F";
                        String lastModified = sdf.format(attrs.lastModifiedTime().toMillis());
                        System.out.println(String.format("%s %s %s", type, path.getFileName(), lastModified));
                    } catch (IOException e) {
                        System.err.println("Error reading attributes for " + path);
                    }
                });
    }
}

