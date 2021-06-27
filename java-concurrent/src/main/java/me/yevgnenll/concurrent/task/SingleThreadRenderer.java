package me.yevgnenll.concurrent.task;

import java.util.ArrayList;
import java.util.List;

public class SingleThreadRenderer {
    void renderPage(CharSequence source) {
        renderText(source);
        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageInfo imageInfo : scanForImageInfo(source))
            imageData.add(imageInfo.downloadImage());
        for (ImageData data : imageData)
            renderImage(data);
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    void renderText(CharSequence s) {

    }
    List<ImageInfo> scanForImageInfo(CharSequence s) {
        return null;
    }
    void renderImage(ImageData i) {

    }
}
