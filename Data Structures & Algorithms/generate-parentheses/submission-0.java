class Solution {
    List<String> res;
    int open;
    int close;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder(), n);
        return res;
    }

    void backtrack(StringBuilder curr, int n){

        if(close > open) return;

        if(curr.length() == 2*n){
            if(open != close) return;
            res.add(new String(curr));
            return;
        }

            curr.append("(");
            open++;
            backtrack(curr, n);
            open--;
            curr.deleteCharAt(curr.length() - 1);
            curr.append(")");
            close++;
            backtrack(curr, n);
            close--;
            curr.deleteCharAt(curr.length() - 1);

    }
}
