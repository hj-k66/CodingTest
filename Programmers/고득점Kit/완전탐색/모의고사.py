'''
프로그래머스 Level 1. 모의고사
'''
'''
22.12.07 재풀이
나의 idea :  정답 배열 완전 탐색하면서 score 계산
- 각각 수포자 정답 패턴 미리 선언 >> i%len(answers)로 패턴 반복
>> 최댓값 리턴
'''

def solution(answers):
    answer1 = [1, 2, 3, 4, 5]
    answer2 = [2, 1, 2, 3, 2, 4, 2, 5]
    answer3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    score = [0,0,0]
    for i in range(len(answers)):
        if answer1[i%len(answer1)] == answers[i]:
            score[0] += 1
        if answer2[i%len(answer2)] == answers[i]:
            score[1] += 1
        if answer3[i%len(answer3)] == answers[i]:
            score[2] += 1

    arr_answer = []
    max_value = max(score)
    for i in range(3):
        if max_value == score[i]:
            arr_answer.append(i+1)
    return arr_answer



















'''
나의 idea : 1,2,3번 답 배열 생성 후, for문 돌면서 정답배열이랑 비교 >> 맞출때마다 점수 증가 >> 가장 높은 값
>> 통과
But, 각 수포자의 답을 넣은 리스트 길이를 answers의 길이만큼 곱함 >> 쓸데없는 메모리 낭비 발생
'''
'''
1번 수포자 : 순차적으로, 1,2,3,4,5
2번 수포자 : 2,1,2,3,2,4,2,5, >> 2찍고, 1, 2찍고, 3, .. 2를 무조건 한번 찍고 다음 숫자 찍는 방법
3번 수포자 : 33,11,22,44,,55,33,11,22 >> 3,1,2,4,5, 순으로 두번씩
'''

def solution(answers):
    answer = []
    answers_len = len(answers)
    answer1 = [1,2,3,4,5]*answers_len
    answer2 = [2,1,2,3,2,4,2,5]*answers_len
    answer3 = [3,3,1,1,2,2,4,4,5,5]*answers_len

    value = [0,0,0]
    for i in range(answers_len):
        if answer1[i] == answers[i]:
            value[0] += 1
        if answer2[i] == answers[i]:
            value[1] += 1
        if answer3[i] == answers[i]:
            value[2] += 1
    #가장 높은 값이 중복되는 경우 위해, value 리스트 완전탐색
    maxvalue = max(value)
    for i in range(3):
        if value[i] == maxvalue:
            answer.append(i+1)
    return answer

'''
Other solution
1. 내 풀이 문제점 :  answer1 = [1,2,3,4,5]*answers_len
>> 다른 풀이에서는 if answers[i] == answer1[i%len(answer1)]으로
5개가 반복되는 경우, i%5로 처리! 
2. enumerate 사용 풀이
'''
def solution(answers):
    p = [[1, 2, 3, 4, 5],
         [2, 1, 2, 3, 2, 4, 2, 5],
         [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    s = [0] * len(p)

    for q, a in enumerate(answers):
        for i, v in enumerate(p):
            if a == v[q % len(v)]:
                s[i] += 1
    return [i + 1 for i, v in enumerate(s) if v == max(s)]

def solution(answers):
    pattern1 = [1,2,3,4,5]
    pattern2 = [2,1,2,3,2,4,2,5]
    pattern3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0, 0, 0]
    result = []

    for idx, answer in enumerate(answers):
        if answer == pattern1[idx%len(pattern1)]:
            score[0] += 1
        if answer == pattern2[idx%len(pattern2)]:
            score[1] += 1
        if answer == pattern3[idx%len(pattern3)]:
            score[2] += 1

    for idx, s in enumerate(score):
        if s == max(score):
            result.append(idx+1)

    return result