package runtime.format;

public class DateParam implements FormatParam {
    private String value;

    public DateParam(){}

    public DateParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String[] getOptions() {
        return new String[0];
    }
}
