command = input()
dx,dy = [0,1,0,-1],[1,0,-1,0]
x,y = 0,0
dir_num = 0
for i in command:
    if i == 'R': #시계방향
        dir_num = (dir_num+1)%4
    elif i == 'L': #반시계방향
        dir_num = (dir_num+3)%4
    else:
        x += dx[dir_num]
        y += dy[dir_num]
print(x,y)