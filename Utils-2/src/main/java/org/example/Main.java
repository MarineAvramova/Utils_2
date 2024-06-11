package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to read:");
        String path = scanner.nextLine();

        File directory = new File(path);

        System.out.println("Choose an option:");
        System.out.println("1. List files in the directory");
        System.out.println("2. List directory tree");

        int choice = scanner.nextInt();

        try {
            if (choice == 1) {
                DirectoryReader.readFolders(directory);
            } else if (choice == 2) {
                DirectoryReader.listDirectoryTree(directory.toPath());
            } else {
                System.out.println("Invalid choice");
            }
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}
