'''
프로그래머스 Level 1. 시저암호
'''
def solution(s, n):
    answer = ''
    for i in s:
        if i == ' ':
            answer += ' '
            continue
        if i.isupper():
            if ord(i)+n > ord('Z'):
                answer += chr(ord(i)%26 + n)
            else:
                answer += chr(ord(i) +n)
        else:
            if ord(i)+n > ord('z'):
                answer += chr(ord(i)%26 + n)
            else:
                answer += chr(ord(i) +n)
    return answer

s = "AB"
n = 1
print(solution(s,n))