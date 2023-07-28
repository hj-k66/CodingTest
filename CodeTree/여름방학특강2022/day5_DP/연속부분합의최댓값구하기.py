'''
dp 3단계

1. dp[i]: 마지막으로 방문한 수열위치를 i라 했을 때, 얻을 수 있는 최대 합

2. dp[i] = max(dp[i-1] + arr[i], arr[i])
//이전 값에서 현재 위치 값 더한 case
//현재값에서 수열 새로 시작 case

3. dp[0] = arr[0]*2
//나머지 최소값으로 초기화
'''
import sys
INT_MIN = -sys.maxsize
n = int(input())
arr = list(map(int, input().split()))
dp = [INT_MIN]*n
dp[0] = arr[0]

for i in range(1,n):
    dp[i] = max(dp[i-1]+arr[i], arr[i])
print(max(dp))