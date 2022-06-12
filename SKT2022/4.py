'''
* 2022 SK텔레콤 T-WorX for Developers 챌린지
* https://programmers.co.kr/competitions/2594?slug=2022-sk-internship
* 일시 : 2022.06.12
* 4번  : TestCase 2/3 통과
'''

from collections import deque

def solution(grid, k):
    answer = -1
    n = len(grid)
    m = len(grid[0])
    visited = []
    for i in range(n):
        visited.append([False]*m)
    visited[0][0] = True

    #상하좌우
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    road = grid[0][0]
    queue = deque()
    queue.append((0,0))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            temp = []
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            #강인 경우 무시
            if grid[nx][ny] == "#":
                continue

            if visited[nx][ny] == False:
                temp.append(grid[nx][ny])
        for i in temp:
            if '.' in temp and
                road += grid[nx][ny]
                queue.append((nx,ny))
                visited[nx][ny] = True

    answer = len(road) // (k + 1) -1
    if "F"*(k-1) in road:
        answer +=1
    print(answer)
    print(road)
    return answer
# grid = ["..FF","###F","###."]
grid = [".F.FFFFF.F", ".########.", ".########F", "...######F", "##.######F", "...######F", ".########F", ".########.", ".#...####F", "...#......"]
solution(grid,6)
