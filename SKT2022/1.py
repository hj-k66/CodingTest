'''
* 2022 SK텔레콤 T-WorX for Developers 챌린지
* https://programmers.co.kr/competitions/2594?slug=2022-sk-internship
* 일시 : 2022.06.12
* 1번  : TestCase 전부 통과
'''

def solution(p):
    i = 0
    answer = []
    answer = [0]*len(p)
    for i in range(len(p)):
        min = 99999
        for j in range(i,len(p)):
            if p[j] < min:
                min = p[j]
                minidx = j
        if i != minidx:
            temp = p[i]
            p[i] = p[minidx]
            p[minidx] = temp
            answer[minidx] += 1
            answer[i] += 1
    return answer

'''
TestCase
[2,5,3,1,4] >> [1,1,0,3,1]
[2,3,4,5,6,1] >> [1,1,1,1,1,5]
[1,2,3,4,5,6,7,8,9]>>[0,0,0,0,0,0,0,0,0]
'''