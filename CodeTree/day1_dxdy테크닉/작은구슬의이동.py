n,t = map(int, input().split())
r,c,d = input().split()

dx,dy = [0,1,-1,0], [1,0,0,-1]
dirt = {"R" :0,"D":1,"U":2,"L":3}

x = int(r)-1
y = int(c)-1
dir_num = dirt[d]

def in_range(x,y):
    return 0<=x<n and 0<=y<n

for _ in range(t):
    nx, ny = x + dx[dir_num], y + dy[dir_num]
    if not in_range(nx,ny):
        dir_num = 3-dir_num
    else:
        x, y = x + dx[dir_num], y + dy[dir_num]

print(x+1,y+1)