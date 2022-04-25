package runtime;

import runtime.format.FormatParam;
import runtime.format.NameFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigParser {
    String fileEnding;
    NameFormat format;

    public ConfigParser(String fname) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fname))){
            String fmt = br.readLine();
            fileEnding = br.readLine();
            List<FormatParam> params = new ArrayList<>();
            String line;
            line = br.readLine();
            int paramIndex = 0;
            while(line!=null) {
                if (!line.startsWith(paramIndex + ": ")) throw new IOException("invalid config file");
                String line2 = br.readLine();
                switch (line.substring(3)) {
                    case "enum":
                        break;
                    case "number":
                        break;
                    case "inc":
                        break;
                    case "str":
                        break;
                    case "date":
                        break;
                    default:
                        throw new IOException("invalid config file");
                }
                line = br.readLine();
            }
        }
    }
}
