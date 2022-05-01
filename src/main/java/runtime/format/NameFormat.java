package runtime.format;

public class NameFormat {
    FormatParam[] params;
    String fmt;

    public NameFormat(FormatParam[] params, String fmt){
        this.params = params;
        this.fmt = fmt;
    }

    //TODO: ADD VALIDATION
    public String getName(String[] valueParams){
        String result = fmt;
        for(int i=0;i<valueParams.length;i++) {
            result = result.replaceAll("\\$"+i, valueParams[i]);
        }
        return result;
    }
}
