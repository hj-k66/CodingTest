n = int(input())
mapper = {"W" : 0, "S":1, "N":2,"E":3}
dx,dy = [-1,0,0,1],[0,-1,1,0]
x,y = 0,0
t = 0
command = [input().split() for _ in range(n)]
done = False
for i in range(n):
    direction, distance = command[i]
    distance = int(distance)
    for j in range(distance):
        x += dx[mapper[direction]]
        y += dy[mapper[direction]]
        t+=1
        # print(x,y)
        if (x, y) == (0, 0):
            print(t)
            done = True
            break
    if done:
        break
if (x,y) != (0,0):
    print(-1)