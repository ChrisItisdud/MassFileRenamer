package runtime.format;

public class NumberParam implements FormatParam {
    private int range;

    public NumberParam(int range) {
        this.range = range;
    }

    public String[] getOptions() {
        return new String[]{String.valueOf(range)};
    }

    public boolean validate(String value) {
        try {
            return Integer.parseInt(value)<=range;
        } catch (Exception e) {
            return false;
        }
    }
}
