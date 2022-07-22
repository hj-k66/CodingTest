#메모이제이션 기법 : Top-Down 방식
n = int(input())
memo = [-1]*(n+1)
def fibbo(n):
    if memo[n] != -1:
        return memo[n]
    if n <= 2:
        memo[n] =  1
    else:
        memo[n] = fibbo(n-1) + fibbo(n-2)
    return memo[n]

print(fibbo(n))

#Tabulation : Bottom-Up 방식
dp = [0]*(n+1)
dp[1] = 1
dp[2] = 1

for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]
print(dp[n])