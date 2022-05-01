package runtime.format;

public class NumberParam implements FormatParam {
    private int range;
    private String value;

    public NumberParam(int range) {
        this.range = range;
    }

    public NumberParam(String value) {
        this.value = value;
    }

    public String[] getOptions() {
        return new String[]{String.valueOf(range)};
    }

    public String getValue() {
        return value;
    }
}
