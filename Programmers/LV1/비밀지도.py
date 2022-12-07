'''
프로그래머스 Level 1. 비밀지도
나의 idea : 숫자 배열 나누기, 나머지 연산으로 이진수 배열로 변환
 >> 이진수 돌면서 or 연산
    - 하나라도 1이면 벽(#)으로, 둘 다 0이면 공백(" ")
'''
def convert_binary(code, n):
    answer = []
    while(code > 0):
        binary = code % 2
        answer.insert(0,binary)
        code //= 2
    while(len(answer) < n):
        answer.insert(0,0)
    return answer
def solution(n, arr1, arr2):
    answer = []
    _arr1 = [convert_binary(code,n) for code in arr1]
    _arr2 = [convert_binary(code,n) for code in arr2]
    for i in range(n):
        line = ""
        for j in range(n):
            if(_arr1[i][j] or _arr2[i][j]):
                line +="#"
            else:
                line+=" "
        answer.append(line)
    return answer
n=5
arr1=[9, 20, 28, 18, 11]
arr2=[30, 1, 21, 17, 28]
solution(n,arr1,arr2)
