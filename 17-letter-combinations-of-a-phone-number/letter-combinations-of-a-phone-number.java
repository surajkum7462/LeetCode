class Solution {
   public void backtrack(String digits, int index, StringBuilder current, List<String> combinations, String[] mapping) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, combinations, mapping);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), combinations, mapping);
        return combinations;
        
    }
}