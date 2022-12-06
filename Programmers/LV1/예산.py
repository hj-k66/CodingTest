'''
프로그래머스 Level 1. 예산
나의 idea : 최대 부서 수로 지원 >> d를 sort하고 가장 적은 금액 신청한 부서부터 지원
'''

def solution(d, budget):
    answer = 0
    d.sort()
    for req in d:
        budget -= req
        if budget < 0:
            break
        answer += 1
    return answer