/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

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
            int lineNumber = 1;
            String fmt = br.readLine();
            fileEnding = br.readLine();
            lineNumber++;
            List<FormatParam> params = new ArrayList<>();
            String line;
            line = br.readLine();
            lineNumber++;
            int paramIndex = 0;
            while (line != null) {
                if (!line.startsWith("$"+paramIndex + ": ")) throw new IOException("invalid config file");
                String line2 = br.readLine();
                switch (line.substring(4)) {
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
                    case "string":
                        params.add(new StringParam());
                        break;
                    case "date":
                        params.add(new DateParam());
                        break;
                    default:
                        throw new IOException("invalid config file: error at line "+lineNumber);
                }
                line = br.readLine();
                lineNumber+=2;
                paramIndex++;
            }
            format = new NameFormat(paramListToArray(params), fmt);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("illegal config");
        }
    }

    public String getFileEnding() {
        return fileEnding;
    }

    public NameFormat getFormat() {
        return format;
    }

    private FormatParam[] paramListToArray(List<FormatParam> params) {
        FormatParam[] result = new FormatParam[params.size()];
        for(int i=0;i<result.length;i++) {
            result[i]=params.get(i);
        }
        return result;
    }
}
