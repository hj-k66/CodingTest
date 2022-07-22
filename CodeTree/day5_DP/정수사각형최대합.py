'''
dp 3단계

1. dp[i][j] : 마지막으로 방문한 위치를 (i,j)라 했을 때, 얻을 수 있는 최대 합

2. dp[i][j] = max(dp[i][j-1], dp[i-1][j]) + arr[i][j]
//오른쪽, 밑으로만 이동 가능

3. dp[0][0] = arr[0][0]
dp[i][0], dp[0][j] -> 따로 계산
'''

n = int(input())
grid = []
for _ in range(n):
    grid.append(list(map(int,input().split())))

dp = [
    [0 for _ in range(n)]
    for _ in range(n)
]

def init():
    dp[0][0] = grid[0][0]

    for i in range(1,n):
        dp[i][0] = dp[i-1][0] + grid[i][0]
    for i in range(1,n):
        dp[0][i] = dp[0][i-1] + grid[0][i]

init()

for i in range(1,n):
    for j in range(1,n):
        dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]
max_value = -1
for j in range(n):
    max_value = max(max_value, dp[n-1][j])
print(max_value)
