package BasicLevel.FindFilesByExtension;

import java.io.*;

public class FileService {

    public FileService() {
    }

    public static long copyFile(File fileIn, File fileOut) throws IOException {

        try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
            return is.transferTo(os);
        }
    }

    public static long copyFolder(File folderIn, File folderOut, String fileExtension) throws IOException {
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(fileExtension);
            }
        };

        long fileCopy = 0;

        File[] files = folderIn.listFiles(filter);
        for (File file : files) {
            if (file.isFile()) {
                File fileOut = new File(folderOut, file.getName());
                copyFile(file, fileOut);
                fileCopy += 1;
            }
        }
        return fileCopy;
    }

    @Override
    public String toString() {
        return "FileService{}";
    }
}
