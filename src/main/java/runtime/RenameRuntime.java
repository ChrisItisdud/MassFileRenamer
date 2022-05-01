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

    /**
     * creates a new RenameRuntime
     * @param fname directory of files to rename
     * @param configLocation location of config file
     * @throws IOException if config file is invalid or cannot be found.
     */
    public RenameRuntime(String fname, String configLocation) throws IOException {
        File directory = new File(fname);
        this.files = directory.listFiles();
        this.index = -1;
        ConfigParser cfgParser = new ConfigParser(configLocation);
        format = cfgParser.getFormat();
        fileEnding = cfgParser.getFileEnding();
    }

    /**
     * returns a RenamableFile that will allow to rename the next file.
     * returns null if end of directory is reached.
     */
    public RenamableFile next() throws IOException {
        if (incrementIndex()) {
            return null;
        }
        Desktop.getDesktop().open(files[index]);
        return new RenamableFile(files[index], format, fileEnding);
    }

    private boolean incrementIndex() {
        do {
            index++;
            if (index >= files.length) {
                return true;
            }
        } while (!files[index].getName().contains(fileEnding));
        return false;
    }

    public NameFormat getFormat() {
        return format;
    }
}