package tk.seayar.leetcode;

/**
 * @author wupeng
 * Create on 1/3/19.
 * @version 1.0
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int lastRes = 0;
        int lastTwoRes = 0;
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int tmpRes;
        for (int i = 0; i < chars.length; i++) {
            tmpRes = 0;
            if (i > 0) {
                if (chars[i] != '0') {
                    tmpRes += lastRes;
                }
                if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                    if (i == 1) {
                        tmpRes += 1;
                    } else {
                        tmpRes += lastTwoRes;
                    }
                }
            } else {
                tmpRes = 1;
            }
            lastTwoRes = lastRes;
            lastRes = tmpRes;
        }
        return lastRes;
    }

}
