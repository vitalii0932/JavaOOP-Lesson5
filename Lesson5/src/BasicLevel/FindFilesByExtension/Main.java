package BasicLevel.FindFilesByExtension;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File folderIn = new File("C:\\Users\\User\\Documents");

        File folderOut = new File("documents");
        folderOut.mkdirs();

        try {
            System.out.println(FileService.copyFolder(folderIn, folderOut, ".docx"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}