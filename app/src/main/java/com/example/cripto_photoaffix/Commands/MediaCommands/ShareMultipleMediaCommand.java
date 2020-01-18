package com.example.cripto_photoaffix.Commands.MediaCommands;

import android.content.Intent;
import android.net.Uri;

import com.example.cripto_photoaffix.ActivityTransferer;
import com.example.cripto_photoaffix.Gallery.Media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShareMultipleMediaCommand implements MediaCommand {
    private Queue<Media> toShare;

    public ShareMultipleMediaCommand(List<Media> toShare) {
        this.toShare.addAll(toShare);
    }

    public void execute(Media media) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("*/*");

        ArrayList<Uri> list = new ArrayList<Uri>();

        Media m;
        while (!toShare.isEmpty()) {
            m = toShare.poll();

            File file = new File(m.getFullPath());
            Uri uri = Uri.fromFile(file);
            list.add(uri);
        }

        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, list);
        ActivityTransferer.getInstance().getActivity().startActivity(intent);
    }
}
