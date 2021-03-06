package com.example.cripto_photoaffix.Commands;

import com.example.cripto_photoaffix.FileManagement.FilesManager;
import java.util.List;

public class RemoveDecryptedMediaCommand extends Command {
    @Override
    public void execute() {
        FilesManager manager = FilesManager.getInstance();
        List<String> media = manager.getMedia();
        System.out.println("Executing removal.");
        String file;
        int size = media.size();

        for (int i = 0; i < size; i++) {
            file = media.get(i);

            if (file.endsWith(".mp4") || file.endsWith(".jpg")) {
                System.out.println("Removing: " + file);
                manager.removeFile(file);
            }
        }
    }
}
