package runtime.format;

public class IncrementParam implements FormatParam {
    private int next;

    public IncrementParam(int init) {
        next = init;
    }

    public String[] getOptions() {
        return new String[]{String.valueOf(next)};
    }
}
