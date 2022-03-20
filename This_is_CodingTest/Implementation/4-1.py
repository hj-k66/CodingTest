'''
예제 4-1 상하좌우
error : 초기화한 값이 공간 벗어나는 조건으로 인식
'''

n = int(input())
plan = input().split()

x = 1; y = 1;
for a in plan:
    if a == 'L':
        ny = y- 1
        nx = x
    elif a == 'R':
        ny = y+1
        nx = x

    elif a == 'U':
        nx = x-1
        ny = y
    elif a == 'D' :
        nx = x+1
        ny = y
    # 공간을 벗어나는 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    # 이동 수행
    x, y = nx, ny
print(x,y)

'''
solution
'''
n = int(input())
plans = input().split()
x,y = 1,1

dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L','R','U','D']

#이동 계획을 하나씩 확인
for plan in plans:
    #이동 후 좌표 구하기
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    #공간을 벗어나는 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny >n :
        continue
    #이동 수행
    x,y = nx,ny

print(x,y)