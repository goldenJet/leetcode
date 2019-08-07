/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
    public static int reverse(int x) {
        String result = x >= 0 ? "" : "-";
        String xx = String.valueOf(Math.abs(Long.valueOf(x+"")));
        String reverse = result + new StringBuilder(xx).reverse().toString();
        Long resultLong = Long.parseLong(reverse);
        return resultLong > Integer.MAX_VALUE || resultLong < Integer.MIN_VALUE ? 0 : resultLong.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));;
    }
}

