package com.example.cripto_photoaffix.Factories.ButtonFactories.GalleryButtons;

import android.view.View;
import com.example.cripto_photoaffix.Commands.Command;
import com.example.cripto_photoaffix.Commands.StoreCommand;
import com.example.cripto_photoaffix.Gallery.Media;
import com.example.cripto_photoaffix.MyImageButton;
import java.util.Map;

public class GalleryStoreButtonFactory extends GalleryButtonFactory {
    public GalleryStoreButtonFactory(View layout, int layoutID) {//, Map<Media, MyImageButton> mediaButtons) {
        super(layout, layoutID);//, mediaButtons);
    }

    protected Command command() {
        return new StoreCommand();
    }
}
