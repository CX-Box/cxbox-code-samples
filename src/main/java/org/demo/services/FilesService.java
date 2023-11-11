package org.demo.services;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FilesService
{
    public static void unzip(String targetZipFilePath, String destinationFolderPath) throws ZipException {
        ZipFile zipFile = new ZipFile(targetZipFilePath);
        zipFile.extractAll(destinationFolderPath);
    }

    public static void zip(String targetDir,String sourceDir) throws ZipException {
        ZipFile zipFile = new ZipFile(targetDir);
        zipFile.addFolder(new File(sourceDir));
    }
    public static void saveFile(Resource zipFileContent, String sourceDir) throws IOException {
        try(InputStream inputStream = zipFileContent.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(sourceDir);)
        {
            byte[] buffer = new byte[1000];
            while (inputStream.available() > 0)
            {
                // read block byte in byffer
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
        }
    }
}
