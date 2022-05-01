package runtime.format;

public class IncrementParam implements FormatParam {
    private int next;

    public IncrementParam(int init) {
        next = init;
    }

    public String[] getOptions() {
        return new String[]{String.valueOf(next)};
    }

    public boolean validate(String param) {
        return param.equals(String.valueOf(next++));
    }
}
