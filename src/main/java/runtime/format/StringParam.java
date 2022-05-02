/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

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
