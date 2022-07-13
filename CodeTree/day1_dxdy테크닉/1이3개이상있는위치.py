n = int(input())
grid = []
for _ in range(n):
    grid.append(list(map(int,input().split())))
dxs,dys = [1,0,-1,0],[0,1,0,-1]
def in_range(x,y):
    return 0<=x and x < n and 0<=y and y < n
x,y = 0,0
cnt = 0
result = 0
for i in range(n):
    for j in range(n):
        x,y = i,j
        cnt = 0
        for dx,dy in zip(dxs, dys):
            nx,ny = x + dx, y + dy
            if in_range(nx,ny) and grid[nx][ny] == 1:
                cnt += 1
        if cnt >= 3:
            result += 1
print(result)

'''
other solution
'''
