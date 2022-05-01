package runtime.format;

public interface FormatParam{
    String[] getOptions();
    boolean validate(String value);
}
