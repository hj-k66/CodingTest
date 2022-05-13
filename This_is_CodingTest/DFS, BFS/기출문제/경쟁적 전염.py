#기출 17.경쟁적 전염
#내풀이 : 4중 for문 >> 시간초과

# n,k = map(int,input().split())
# graph = []
# for i in range(n):
#     graph.append(list(map(int,input().split())))
# s,x,y = map(int,input().split())
#
# dx = [1,-1,0,0]
# dy = [0,0,-1,1]
#
# visited = [[False]*n for _ in range(n)]
#
# def virus(x,y,k):
#     if visited[x][y] == True:
#         return
#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]
#         if nx >= 0 and nx < n and ny >=0 and ny < n and visited[nx][ny] == False:
#             if graph[nx][ny] == 0:
#                 graph[nx][ny] = k
#                 visited[nx][ny] = True
#
#
#
# for i in range(s):
#     for j in range(1,k+1):
#         for xi in range(n):
#             for yi in range(n):
#                 if graph[xi][yi] == j:
#                     virus(xi,yi,j)
#                     visited[xi][yi] = True
# #    print(graph)
# print(graph[x-1][y-1])


#solution : bfs이용?
from collections import deque

n,k = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))
s,x,y = map(int,input().split())

dx = [1,-1,0,0]
dy = [0,0,-1,1]

queue = deque(graph)
