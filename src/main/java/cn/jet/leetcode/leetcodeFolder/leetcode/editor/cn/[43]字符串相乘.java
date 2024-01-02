//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1312 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        // 123 * 23
        // 123 * 3 + 123 * 2 * 10
        // [0, 0, 0, 0, 0]
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        // 创建一个用于接收结果集的数组
        int[] rst = new int[num1.length() + num2.length()];

        // 优化：不用每次都进位
        /*for (int x = num2.length() - 1, i = num1.length() + num2.length() - 1; x >= 0; x--, i--) {
            int b = num2.charAt(x) - '0';
            for (int y = num1.length() - 1, ii = i; y >= 0; y--, ii--) {
                int a = (num1.charAt(y) - '0') * b;
                int iii = ii;
                while (a > 0) {
                    a += rst[iii];
                    rst[iii] = a % 10;
                    --iii;
                    a /= 10;
                }
            }
        }*/
        // 每一位挨个运算
        for (int x = num2.length() - 1, i = num1.length() + num2.length() - 1; x >= 0; x--, i--) {
            int b = num2.charAt(x) - '0';
            for (int y = num1.length() - 1, ii = i; y >= 0; y--, ii--) {
                int a = (num1.charAt(y) - '0') * b;
                rst[ii] += a;
            }
        }
        // 进位
        for (int i = rst.length - 1; i > 0; i--) {
            rst[i - 1] += rst[i] / 10;
            rst[i] %= 10;
        }

        // 找到第一个不为0的位置
        int index = 0;
        while (index < rst.length && rst[index] == 0) {
            index++;
        }
        // 返回值拼装
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < rst.length; i++) {
            sb.append(rst[i]);
        }
        return sb.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
