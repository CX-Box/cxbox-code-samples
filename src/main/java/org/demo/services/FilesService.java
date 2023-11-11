package org.demo.services;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


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
        try
                (InputStream inputStream = zipFileContent.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(sourceDir);) {
            byte[] buffer = new byte[1000];
            while (inputStream.available() > 0) //пока есть еще непрочитанные байты
            {
                // прочитать очередной блок байт в переменную buffer и реальное количество в count
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
            }
        }
    }
    private ZipOutputStream toZipped(HashMap<String, byte[]> map) {
        Iterator<Map.Entry<String, byte[]>> iterator = map.entrySet().iterator();
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("output.zip"));
        ) {
            while (iterator.hasNext()) {
                Map.Entry<String, byte[]> entry = iterator.next();
                String filename = entry.getKey();
                byte[] buffer = entry.getValue();
                ZipEntry entry1 = new ZipEntry(filename);
                zout.putNextEntry(entry1);
                // добавляем содержимое к архиву
                zout.write(buffer);
                // закрываем текущую запись для новой записи
                zout.closeEntry();
            }
            return zout;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
