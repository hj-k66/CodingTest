#조합

n,m = map(int,input().split())
answer = []

#n자리 2진수 : 0 0 0 0 1 1 = 5,6이 존재하는 상태

def combination(curr_num, cnt):
    #curr_num : 몇번째 자리(= 1~n )를 보고있는지
    #cnt : 지금까지 나온 1의 갯수

    if curr_num == n+1:
        if cnt == m:
            print(*answer)
        return
    #curr_num 넣어준 경우
    answer.append(curr_num)
    combination(curr_num+1, cnt+1)
    answer.pop()

    #curr_num 안넣은 경우
    combination(curr_num + 1 , cnt)
# combination(1,0)
#코드 순서 바뀌면 내림차순
'''
other solution
'''
#4C3
for i in range(1,5):
    for j in range(i+1, 5):
        for k in range(j+1,5):
            print(i,j,k)
def find_combination(cnt, last_num):
    if cnt == m:
        print(*answer)
        return

    #last_num 이후의 가능한 숫자들을 재귀호출
    for i in range(last_num+1,n+1):
        answer.append(i)
        find_combination(cnt+1,i)
        answer.pop()
# #가능한 범위를 순회하며 해당 숫자가
# #조합의 첫번째 숫자일 때 탐색
for i in range(1,n+1):
    answer.append(i)
    find_combination(1,i)
    answer.pop()