package CodingTest.Programmers.고득점Kit.DFSBFS;

class Solution {
    static int result = 0;
    public static void dfs(int[] numbers, int i, int target, int sum){
        if(i == numbers.length){
            if(sum == target){
                result++;
            }
            return;
        }

        dfs(numbers, i+1, target, sum-numbers[i]);
        dfs(numbers, i+1, target, sum+numbers[i]);

    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0,target,0);
        return result;
    }
}
