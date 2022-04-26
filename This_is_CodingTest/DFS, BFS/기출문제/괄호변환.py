#기출 18.괄호 변환
#내풀이 : 알고리즘 설명대로 재귀적으로 구현하면 될듯
# 근데, 균형잡힌 괄호, 올바른 괄호 문자열 판단을 어떻게??

# def solution(p):
#     if p == "":
#         return ""
#     if 균형잡힌 문자열:
#
#     if 올바른 문자열:
#
#     else:
#         return '(' + ')'
#     answer = ''
#     return answer

#solution
#그대로 구현, 소스코드 단순화 위해 "균형잡힌 괄호" 인덱스 반환 함수, "올바른 문자열 판단"함수 구현

#균형잡인 괄호 문자열 인덱스 반환
def balanced_index(p):
    count = 0 #왼쪽 괄호의 갯수
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            return i

#올바른 괄호인지 판단
def check_proper(p):
    count = 0 #왼쪽 괄호
    for i in p:
        if i == '(':
            count += 1
        else:
            if count == 0: #쌍이 맞지 않는 경우
                return False
            count -= 1
    return True #쌍이 맞는 경우 True 반환

def solution(p):
    answer = ''
    if p == '':
        return answer
    index = balanced_index(p)
    u = p[:index+1]
    v = p[index+1:]
    #u가 올바른 괄호라면, v에 대해 함수 수행한 결과 붙여 반환
    if check_proper(u):
        answer = u + solution(v)
    #올바른 괄호가 아니라면
    else:
        answer = '('
        answer += solution(v)
        answer += ')'
        u = list(u[1:-1]) # 첫 번째와 마지막 문자 제거
        #괄호 방향 뒤집기
        for i in range(len(u)):
            if u[i] == '(':
                u[i] = ')'
            else:
                u[i] = '('
        answer += "".join(u) #리스트를 문자열로 변환
    return answer