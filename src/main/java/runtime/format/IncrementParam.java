package runtime.format;

public class IncrementParam implements FormatParam {
    private static int next = -1;
    private int value;

    public IncrementParam() {
        value = next;
        next++;
    }

    public IncrementParam(int init) {
        next = init;
    }

    public String[] getOptions() {
        return new String[]{String.valueOf(next)};
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
