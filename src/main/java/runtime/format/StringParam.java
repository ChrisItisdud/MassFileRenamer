package runtime.format;

public class StringParam implements FormatParam {
    public StringParam() {
    }

    public String[] getOptions() {
        return new String[0];
    }

    public boolean validate(String value) {
        return true;
    }
}
