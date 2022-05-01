package runtime.format;

public class DateParam implements FormatParam {
    public DateParam(){}

    public String[] getOptions() {
        return new String[0];
    }

    public boolean validate(String value) {
        return value.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d");
    }
}
