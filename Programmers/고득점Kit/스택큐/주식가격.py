'''
프로그래머스 Level 2. 주식가격
나의 idea : 완전 탐색하면서 현재 index 이후 가격들 비교 >> answer++
>> 현재 index 가격이 크면(주식 가격이 떨어지면) 탐색 종료
'''
def solution(prices):
    answer = [0]*len(prices)
    for i in range(len(prices)):
        for j in range(i+1,len(prices)):
            answer[i] += 1
            if prices[i] > prices[j]:
                break
    return answer
prices = [1,1,1,1,1]
print(solution(prices))

'''
내 풀이 문제점 : 완전 탐색이라 시간이 너무 오래 걸림
other solution: 스택 이용 >> 시간 80% 감소
'''
def solution(prices):
    answer = [0]*len(prices)
    stack = []

    for i, price in enumerate(prices):
        #stack이 비었을 때 and 다음 price가 더 작을 때
        while stack and price < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)

    while stack:
        j = stack.pop()
        answer[j] = len(prices) - 1 - j

    return answer