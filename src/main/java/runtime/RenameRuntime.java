package runtime;

import runtime.format.NameFormat;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RenameRuntime {
    private String fileEnding;
    private final File[] files;
    private int index;
    private NameFormat format;

    public RenameRuntime(String fname) {
        File directory = new File(fname);
        this.files = directory.listFiles();
        this.index = -1;

    }

    /**
     * returns a RenamableFile that will allow to rename the next file.
     * returns null if end of directory is reached.
     */
    public RenamableFile next() throws IOException {
        //TODO: limit to files with specific ending
        if (incrementIndex()) {
            return null;
        }
        Desktop.getDesktop().open(files[index]);
        return new RenamableFile(files[index], format);
    }

    private boolean incrementIndex() {
        do {
            index++;
            if (index >= files.length) {
                return true;
            }
            if (files[index].getName().equals("config.txt")) continue;
        } while (!files[index].getName().contains(fileEnding));
        return false;
    }

    public NameFormat getFormat() {
        return format;
    }
}
