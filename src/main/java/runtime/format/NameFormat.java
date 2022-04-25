package runtime.format;

public class NameFormat {
    FormatParam[] params;
    String fmt;

    public NameFormat(FormatParam[] params, String fmt){
        this.params = params;
        this.fmt = fmt;
    }

    public String getName(FormatParam[] valueParams){
        String result = new String(fmt);
        for(int i=0;i<valueParams.length;i++) {
            result = result.replaceAll("\\$"+i, valueParams[i].getValue());
        }
        return result;
    }
}
