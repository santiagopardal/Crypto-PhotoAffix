package com.example.cripto_photoaffix.Commands;

import android.content.Intent;
import com.example.cripto_photoaffix.Activities.MyActivity;
import com.example.cripto_photoaffix.Gallery.Media;
import java.io.File;

public class ImageShareCommand extends ShareCommand {

    public ImageShareCommand(MyActivity activity, Media media) {
        super(activity, media);
    }

    @Override
    public void execute() {
        //Preguntar si esto esta bien. No me gusta para nada castear. Podria crear
        //para cada tipo de datos un transferer.
        File file = media.share(activity.getCacheDir().getPath() + "/share/");

        Intent intent = createIntent(file);
        intent.setType("image/jpg");

        activity.startActivity(Intent.createChooser(intent, "Share via:"));
    }
}