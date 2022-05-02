/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

package frontend;

import runtime.RenamableFile;
import runtime.RenameRuntime;
import runtime.format.IncrementParam;
import runtime.format.NameFormat;

import java.io.IOException;
import java.util.Scanner;

public class CommandLineFrontend {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please provide the location of your config file!");
            String configLocation = scanner.nextLine();
            System.out.println("Please provide the directory to rename!");
            String directory = scanner.nextLine();
            try {
                RenameRuntime runtime = new RenameRuntime(directory, configLocation);
                System.out.println("Starting renaming process...");
                NameFormat format = runtime.getFormat();
                System.out.println("Format: " + format);

                RenamableFile currentFile = runtime.next();
                while (currentFile != null) {
                    System.out.println("Checking file " + currentFile.getName());
                    renameFile(currentFile, scanner, format);
                    System.out.println("Continue? y/n");
                    if (scanner.nextLine().equals("n")) break;
                    currentFile = runtime.next();
                }

                System.out.println("Done with all files!");
                System.out.println("closing application...");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    private static void renameFile(RenamableFile currentFile, Scanner scanner, NameFormat format) {
        String[] values = new String[format.getParams().length];
        for (int i = 0; i < values.length; i++) {
            if (format.getParams()[i].getClass() == IncrementParam.class) {
                values[i] = format.getParams()[i].getOptions()[0];
                format.getParams()[i].validate(values[i]);
                continue;
            }
            System.out.println("Please provide a value for parameter " + i + "! (" + format.getParamTypeName(format.getParams()[i]) + ")");
            String value;
            boolean success = false;
            do {
                value = scanner.nextLine();
                if (!format.getParams()[i].validate(value)) {
                    System.out.println("invalid value, please try again");
                } else {
                    success = true;
                }
            } while (!success);
            values[i] = value;
        }
        boolean success = false;
        while (!success) {
            try {
                currentFile.rename(values);
                success = true;
            } catch (Exception e) {
                System.out.println("File rename failed, please close file! (Press Enter to confirm)");
                scanner.nextLine();
            }
        }
    }
}
