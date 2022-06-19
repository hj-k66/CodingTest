'''
프로그래머스 Level 2. 가장 큰 수
나의 idea : 주어진 정수로 만들 수 있는 모든 경우의 수 적용하면서 숫자 만든 후, 정렬 >> 가장 큰 수 리턴
순열? >> 개오래걸림
idea2 : number str >> 내림차순정렬 >> 가장 큰수 >> 틀림, '3' '30' 중 '3'이 더 큰 수로 인식되어야 하는 방법을 찾지 못함.
'''

def solution(numbers):
    answer = ''
    sort = []
    sort = sorted(list(map(lambda x: str(x), numbers)), reverse=True)
    for i in sort:
        answer += i
    return answer

'''
solution
'''
def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x * 3, reverse=True)
    return str(int(''.join(numbers)))

