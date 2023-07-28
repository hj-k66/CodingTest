'''
아름다운 수 조건
1. 1 이상 4 이하의 숫자로만 이루어짐
2. 해당 숫자만큼 연달아 같은 숫자가 나옴 ex) 1333221
3. 동일한 숫자에 대해 연달아 같은 숫자의 묶음
    ex) 111 - 1이 1번 나오는게 3번 반복
    ex) 22222222 - 2가 2번 나오는게 4번 반복
'''
'''
내풀이 : 재귀 중간에 아름다운 수 조건 파악 하려함(가지치기) >> 구현 어려움
'''
# n = int(input())
# answer = []
# cnt = 0
# check = False
# def find_num(curr):
#     #종료조건
#     if curr == n+1:
#         print(*answer)
#         return
#     for elem in range(1,5):
#         # if elem > n or n-len(answer) < elem :
#         #     continue
#         print(answer)
#         if curr > 1 and elem != answer[-1] and elem != 1:
#             continue
#         answer.append(elem)
#         find_num(curr+1)
#         answer.pop()
# find_num(1)

'''
solution : 모든 경우의 수 구한 뒤, 아름다운 수 조건 파악
'''

n = int(input())
answer = []
cnt = 0
def is_beautiful(answer):
    i = 0 #연달아 같은 숫자 나오는 시작 위치
    while i < n:
        #만약 연속하여 해당 숫자만큼 나올 수 없다면
        #ex) 3자리 수인데 4가 나왔을 경우
        if i + answer[i] - 1 >= n:
            return False
        #연속하여 해당 숫자만큼 같은 숫자 있는지 확인
        for j in range(i,i+answer[i]):
            if answer[j] != answer[i]:
                return False
        i += answer[i]
    return True


    return True
def find_num(curr):
    global cnt
    #종료조건
    if curr == n+1:
        if is_beautiful(answer):
            cnt += 1
        return
    for elem in range(1,5):
        answer.append(elem)
        find_num(curr+1)
        answer.pop()
find_num(1)
print(cnt)