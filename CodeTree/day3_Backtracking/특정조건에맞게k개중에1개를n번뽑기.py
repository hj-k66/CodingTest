#연속하여 같은 숫자가 3번 이상 나오는 경우 제외

k,n = map(int,input().split())
answer = []

def choose(curr_num):
    #종료조건
    if curr_num == n+1:
        print(*answer)
        return
    for i in range(1,k+1):
        #가지치기 조건
        if curr_num >= 3 and i == answer[-1] == answer[-2] :
            continue
        answer.append(i)
        choose(curr_num+1)
        answer.pop()
choose(1)