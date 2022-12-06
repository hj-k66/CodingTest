'''
프로그래머스 Level 1. 핸드폰 번호 가리기
'''

def solution(phone_number):
    answer = ''
    count = 0
    n = len(phone_number)
    for num in range(n-1,-1,-1):
        if count < 4:
            char = phone_number[num]
        else:
            char = '*'
        count += 1
        answer = char + answer
    return answer

print(solution("027778888"))