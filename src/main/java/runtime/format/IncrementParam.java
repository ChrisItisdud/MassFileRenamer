/*
    COPYRIGHT 2022 Chris Samira Reichel
    This software is published under the MIT license.
    The license text can be found at https://opensource.org/licenses/MIT
 */

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
        boolean result = param.equals(String.valueOf(next));
        next++;
        return result;
    }
}
