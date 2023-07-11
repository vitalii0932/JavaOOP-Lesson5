package AdvanchedLevel;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        /* from cmd

        if (args.length < 2) {
            System.out.println("Input 2 arguments please");
            return;
        }
        String filePath1 = args[0];
        String filePath2 = args[1];

        FileService fileService = new FileService();
        fileService.compareFiles(new File(filePath1), new File(filePath2));
         */

        fileService.compareFiles(new File("group1.txt"), new File("group11.txt"));
        fileService.compareFiles(new File("group1.txt"), new File("group12.txt"));
        fileService.compareFiles(new File("group1.txt"), new File("group2.txt"));
    }
}
