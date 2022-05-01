package frontend;

import runtime.RenamableFile;
import runtime.RenameRuntime;
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
                while(currentFile!=null) {
                    System.out.println("Checking file "+currentFile.getName());
                    renameFile(currentFile, scanner);
                    currentFile = runtime.next();
                }

                System.out.println("Done with all files!");
                System.out.println("closing application...");
            } catch (IOException e) {
                System.out.println("Invalid file name or directory.");
            }
        }
    }

    private static void renameFile(RenamableFile currentFile, Scanner scanner){
        //TODO
    }
}
