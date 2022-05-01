package runtime.format;

public class StringParam implements FormatParam {
    private String value;

    public StringParam() {
    }

    public StringParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String[] getOptions() {
        return new String[0];
    }
}
