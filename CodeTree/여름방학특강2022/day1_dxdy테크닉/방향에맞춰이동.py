'''
방향에 맞춰 이동
https://www.codetree.ai/missions/5/problems/move-in-direction/description
'''
'''
내풀이
'''
n = int(input())
dx, dy = [1, 0, -1, 0], [0, -1, 0, 1]
x,y = 0,0

for _ in range(n):
    direction, distance = input().split()
    distance = int(distance)
    if direction == 'E':
        nx,ny = x + dx[0]*distance , y + dy[0]*distance
    elif direction == 'S':
        nx,ny = x + dx[1]*distance , y + dy[1]*distance
    elif direction == 'W':
        nx,ny = x + dx[2]*distance , y + dy[2]*distance
    else:
        nx,ny = x + dx[3]*distance , y + dy[3]*distance
    x,y = nx,ny
print(nx,ny)

'''
other solution : 딕셔너리 이용
'''
x,y = 0,0
dx,dy = [1,0,-1,0],[0,-1,0,1]
n = int(input())
mapper = {'E':0, 'S':1, 'W' : 2,'N':3}

for _ in range(n):
    c_dir,dist = input().split()
    dist = int(dist)

    x+=dx[mapper[c_dir]]*dist
    y+=dy[mapper[c_dir]]*dist
print(x,y)