package runtime.format;

public class NameFormat {
    FormatParam[] params;
    String fmt;

    public NameFormat(FormatParam[] params, String fmt) {
        this.params = params;
        this.fmt = fmt;
    }

    //TODO: ADD VALIDATION
    public String getName(String[] valueParams) {
        String result = fmt;
        for (int i = 0; i < valueParams.length; i++) {
            result = result.replaceAll("\\$" + i, valueParams[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        String result = fmt;
        for (int i = 0; i < params.length; i++) {
            result = result.replaceAll("\\$" + i, getParamTypeName(params[i]));
        }
        return result;
    }

    private String getParamTypeName(FormatParam param) {
        if (param.getClass() == DateParam.class) {
            return "Date";
        } else if (param.getClass() == EnumParam.class) {
            StringBuilder result = new StringBuilder("Enum(");
            for (String s : param.getOptions()) {
                result.append(s).append("|");
            }
            result.append(")");
            return result.toString();
        } else if (param.getClass() == IncrementParam.class) {
            return "Increment" + param.getOptions()[0];
        } else if (param.getClass() == NumberParam.class) {
            return "Number";
        } else if (param.getClass() == StringParam.class) {
            return "String";
        }
        return "UnknownType";
    }
}
