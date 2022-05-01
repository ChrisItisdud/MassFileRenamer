package runtime.format;

public class EnumParam implements FormatParam {
    private String[] options;

    public EnumParam(String[] options) {
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }
}
