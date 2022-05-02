/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

package runtime;

import org.apache.commons.io.FileUtils;
import runtime.format.NameFormat;

import java.io.File;
import java.io.IOException;

public class RenamableFile {
    private File oldFile;
    private NameFormat format;
    private String fileEnding;

    public RenamableFile(File oldFile, NameFormat format, String fileEnding) {
        this.oldFile = oldFile;
        this.format = format;
        this.fileEnding = fileEnding;
    }

    public void rename(String[] params) throws IOException {
        String result = oldFile.getParentFile().getAbsolutePath() + "\\" + format.getName(params) + "." + fileEnding;
        File target = new File(result);
        System.out.println(target.getAbsolutePath());
        if (target.exists()) throw new IOException("file exists");
        FileUtils.moveFile(oldFile, target);
    }

    public String getName() {
        return oldFile.getName();
    }
}
