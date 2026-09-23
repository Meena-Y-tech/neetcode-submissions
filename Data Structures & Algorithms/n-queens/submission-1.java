class Solution {
    
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> posDg = new HashSet<>();
        HashSet<Integer> negDg = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        char[][] board;
        int n;

        public List<List<String>> solveNQueens(int n){
            this.n = n;

            board = new char[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(board[i], '.');
            }

            backtrack(0);
            return result;
        }

        void backtrack(int r){
            if(r==n){
                List<String> curr = new ArrayList<>();
                for(int i=0;i<n;i++){
                    curr.add(new String(board[i]));
                }

                result.add(curr);
                return;
            }

            for(int col=0;col<n;col++){
                if(isSafe(r, col)){
                    board[r][col] = 'Q';

                    cols.add(col);
                    posDg.add(r + col);
                    negDg.add(r - col);

                    backtrack(r + 1);

                    board[r][col] = '.';
                    cols.remove(col);
                    posDg.remove(r + col);
                    negDg.remove(r - col);
                }
            }
        }

        boolean isSafe(int r, int col){
            if(cols.contains(col)){
                return false;
            }
            if(posDg.contains(r+col)){
                return false;
            }
            if(negDg.contains(r-col)){
                return false;
            }
        
        return true;
    }
}

