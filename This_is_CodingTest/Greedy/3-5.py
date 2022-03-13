'''
문제 4 : 1이 될 때까지
N이 1이 될 때까지의 최소 수행 과정 횟수 구하기
    1. N에서 1을 뺀다.
    2. N을 K로 나눈다.
Idea : 최대한 많이 나누기
        1. N이 K의 배수 될 때까지 1씩 빼기
        2. N을 K로 나누기
'''

'''
n,k = map(int,input().split())
result = 0

# N이 K 이상이라면 K로 계속 나누기
while n>=k:
    # N이 K로 나누어 떨어지지 않는다면 N에서 1 빼기
    while n%k != 0:
        n -= 1
        result +=1
    # k로 나누기
    n //= k
    result += 1

#마지막으로 남은 수 1씩 빼기
while n > 1:
    n -= 1
    result += 1

print(result)
'''

#더 효율적인 code
n,k = map(int,input().split())
result = 0

while True:
    # (N(target) == k로 나누어떨어지는 수)가 될 때까지 1씩 빼기
    target = (n//k)*k
    result += (n - target)
    n = target
    # 더 이상 나눌 수 없을 때 반복문 탈출
    if n < k:
        break
    # k로 나누기
    n //= k
    result += 1

#마지막으로 남은 수에 대해 1씩 빼기
result += (n-1)
print(result)