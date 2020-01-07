package com.example.cripto_photoaffix.Gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.cripto_photoaffix.FileManagement.FilesManager;
import com.example.cripto_photoaffix.Visitors.MediaVisitors.MediaVisitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Picture extends Media {
    public Picture(String path) {
        this.path = path;

        System.out.println("Path: " + path + ".jpg");
        preview = BitmapFactory.decodeFile(path + ".jpg");
        preview = Bitmap.createScaledBitmap(preview, (int)(preview.getWidth()*0.3), (int)(preview.getHeight()*0.3), false);
    }

  /*  public Bitmap getImage() {
        return preview;
    }*/

    public void accept(MediaVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public File share(String sharingPath) {
        File path = new File(sharingPath);
        if (!path.exists())
            path.mkdir();

        File file = new File(sharingPath, "sharing.jpg");

        int i = 0;

        while (file.exists()) {
            file = new File(sharingPath, "sharing" + i + ".jpg");
            i++;
        }

        try {
            FileOutputStream out = new FileOutputStream(file);
            preview.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    @Override
    public File store(String path) {
        File myDir = new File(path);

        String fname = "Image-" + "storing";
        File file = new File(myDir, fname + ".jpg");

        int i = 0;
        while (file.exists()) {
            file = new File(myDir, fname + i + ".jpg");
            i++;
        }

        FilesManager.copy(this.path + ".jpg", file.getPath());

        return file;
    }
}
