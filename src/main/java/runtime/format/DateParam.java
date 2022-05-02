/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

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
