package runtime;

import org.apache.commons.io.FileUtils;
import runtime.format.NameFormat;

import java.io.File;
import java.io.IOException;

public class RenamableFile {
    private File oldFile;
    private NameFormat format;

    public RenamableFile(File oldFile, NameFormat format) {
        this.oldFile = oldFile;
        this.format = format;
    }

    public void rename(String[] params) throws IOException {
        String result = format.getName(params);
        File target = new File(oldFile.getParentFile().getName(), result);
        if (target.exists()) throw new IOException("file exists");
        FileUtils.moveFile(oldFile, target);
    }

    public String getName() {
        return oldFile.getName();
    }
}
