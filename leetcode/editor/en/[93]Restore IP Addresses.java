class Solution {
    private boolean isIP(String str) {
        String[] parts = str.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            int number;
            if (part.length() > 1 && part.charAt(0) == '0') return false;
            try {
                number = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }

            if (number < 0 || number > 255) {
                return false;
            }
        }

        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtracking("", ans, s, 0, s.length());
        return ans;
    }

    private void backtracking(String str, List<String> ans, String s, int idx, int n) {
        if (idx == s.length()) {
            str = str.substring(0, str.length() - 1);
            if (isIP(str)) ans.add(str);
            return;
        }
        if (idx < n) {
            str += s.charAt(idx++);
            backtracking(str + ".", ans, s, idx, n);
            if (idx < n) {
                str += s.charAt(idx++);
                backtracking(str + ".", ans, s, idx, n);
            }
            if (idx < n) {
                str += s.charAt(idx++);
                backtracking(str + ".", ans, s, idx, n);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
