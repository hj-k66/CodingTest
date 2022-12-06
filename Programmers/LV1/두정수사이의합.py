'''
프로그래머스 Level 1. 두 정수 사이의 합
'''

def solution(a, b):
    answer = 0
    if a>b:
        big = a
        small = b
    else:
        big = b
        small = a
    for i in range(small,big+1):
        answer += i
    return answer


a = 3
b = 5
print(solution(a,b))