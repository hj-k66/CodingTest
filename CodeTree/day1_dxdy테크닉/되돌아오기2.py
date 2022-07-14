command = input()
x,y = 0,0
dx,dy = [0,1,0,-1],[1,0,-1,0]
dir_num = 0
t = 0

for i in command:
    if i == 'R': #시계방향
        dir_num = (dir_num+1)%4
    elif i == 'L': #반시계방향
        dir_num = (dir_num+3)%4
    else:
        x += dx[dir_num]
        y += dy[dir_num]
    t += 1
    if (x,y) == (0,0):
        print(t)
        break
if (x,y) != (0,0):
    print(-1)
