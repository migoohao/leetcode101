class Solution {
    private static Set<String> codes = new HashSet<>();
    static {
        for (int i = 1; i <= 26; i++) {
            codes.add(String.valueOf(i));
        }
    }
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int beforePrevious = 0;
        int previous = 1;
        int current = 0;
        for (int i = 0; i < chars.length; i++) {
            current = 0;
            String code = String.valueOf(chars[i]);
            String preCode = code;
            if (i > 0) {
                preCode = String.valueOf(chars[i - 1]) + code;
            }
            if (!codes.contains(preCode) && !codes.contains(code)) {
                return 0;
            }
            if (codes.contains(code)) {
                current += previous;
            }
            if (i > 0 && codes.contains(preCode)) {
                current += beforePrevious;
            }
            beforePrevious = previous;
            previous = current;
        }
        return current;
    }
}
