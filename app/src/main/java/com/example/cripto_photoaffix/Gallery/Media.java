package com.example.cripto_photoaffix.Gallery;

import android.graphics.Bitmap;

import com.example.cripto_photoaffix.Commands.Command;
import com.example.cripto_photoaffix.Visitors.MediaVisitors.MediaVisitor;
import java.io.File;

public abstract class Media {
    protected Bitmap preview;
    protected String path;

    public Bitmap getPreview() {
        return preview;
    }

    public abstract void accept(MediaVisitor visitor);

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract File share(String sharingPath);
}
