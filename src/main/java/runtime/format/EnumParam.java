package runtime.format;

public class EnumParam implements FormatParam {
    private String[] options;

    public EnumParam(String[] options) {
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean validate(String value) {
        for(String s : options) {
            if(s.equals(value)) return true;
        }
        return false;
    }
}
