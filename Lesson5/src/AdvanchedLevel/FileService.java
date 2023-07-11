package AdvanchedLevel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileService {
    public FileService() {
    }

    public void compareFiles(File file1, File file2) {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] bytes1 = fis1.readAllBytes();
            byte[] bytes2 = fis2.readAllBytes();
            int pos = 0;

            if(bytes1.length == bytes2.length) {
                for(int i = 0; i < bytes1.length; i++) {
                    if(bytes1[i] != bytes2[i]) {
                        System.out.printf("Position :%d.\nFiles not equals\n", pos);
                        return;
                    }
                    pos++;
                }
            } else {
                System.out.println("Files lengths not equals");
                return;
            }

            System.out.println("Files equals");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "FileService{}";
    }
}
