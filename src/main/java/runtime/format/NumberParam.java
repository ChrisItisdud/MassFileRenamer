/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

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
