package runtime.format;

public class IncrementParam implements FormatParam {
    private static int next = -1;

    public IncrementParam(int init) {
        next = init;
    }

    public String[] getOptions() {
        return new String[]{String.valueOf(next)};
    }
}
