package runtime.format;

public class EnumParam implements FormatParam {
    private String value;
    private String[] options;

    public EnumParam(String[] options) {
        this.options = options;
    }

    public EnumParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String[] getOptions() {
        return options;
    }
}
