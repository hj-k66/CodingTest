#구현 기출 09. 문자열 압축
'''
내풀이
idea :# 문자열 단위 구하기 >> answer =  전체 // 문자열 단위 + 문자열단위
# 문자열 단위 구하는 법 : 완전탐색 하기 >> 길이가 N인 문자열이면 1 ~ N//2까지 단위 완전탐색
풀이 오류 : 파이썬 리스트 인덱싱 등 기본 구현 부족
'''

def solution(s):
    list = []
    for i in s:
        for j in range(0, 2): #문자열 2개 단위
            list.append(j)



    answer = 0
    return answer

'''
solution
'''
def solution(s):
    answer = len(s)
    #1개 단위(step)부터 압축 단위를 늘려가며 확인
    for step in range(1,len(s) // 2 +1):
        compressed = ''
        prev = s[0:step] #앞에서부터 step만큼의 문자열 추출
        count = 1
        #단위(step)크기만큼 증가시키며 이전 문자열과 비교
        for j in range(step, len(s), step):
            #이전 상태와 동일하다면 압축 횟수(count) 증가
            if prev == s[j:j+step]:
                count += 1
            #다른 문자열이 나왔다면 (더 이상 압축하지 못하는 경우라면)
            else:
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j+step] #다시 상태 초기화
                count = 1
        #남아 있는 문자열에 대해 처리
        compressed += str(count) + prev if count >= 2 else prev
        #만들어지는 압축 문자열이 가장 짧은 것이 정답
        answer = min(answer,len(compressed))


    return answer