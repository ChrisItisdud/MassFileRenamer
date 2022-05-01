package runtime;

import runtime.format.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigParser {
    private String fileEnding;
    private NameFormat format;

    public ConfigParser(String fname) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            String fmt = br.readLine();
            fileEnding = br.readLine();
            List<FormatParam> params = new ArrayList<>();
            String line;
            line = br.readLine();
            int paramIndex = 0;
            while (line != null) {
                if (!line.startsWith(paramIndex + ": ")) throw new IOException("invalid config file");
                String line2 = br.readLine();
                switch (line.substring(3)) {
                    case "enum":
                        String[] values = line2.split(",");
                        params.add(new EnumParam(values));
                        break;
                    case "number":
                        int range = Integer.parseInt(line2);
                        params.add(new NumberParam(range));
                        break;
                    case "inc":
                        int init = Integer.parseInt(line2);
                        params.add(new IncrementParam(init));
                        break;
                    case "str":
                        params.add(new StringParam());
                        break;
                    case "date":
                        params.add(new DateParam());
                        break;
                    default:
                        throw new IOException("invalid config file");
                }
                line = br.readLine();
            }
            format = new NameFormat((FormatParam[]) params.toArray(), fmt);
        } catch (Exception e) {
            throw new IOException("illegal config");
        }
    }

    public String getFileEnding() {
        return fileEnding;
    }

    public NameFormat getFormat() {
        return format;
    }
}
