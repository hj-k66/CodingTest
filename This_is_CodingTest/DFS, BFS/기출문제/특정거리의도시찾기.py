#기출 15. 특정 거리의 도시 찾기
#내풀이 : 1. 리스트 중에서 x로 시작하는 원소 찾기 >> k만큼 돌기
#2. 방문 안한 x로 시작하는 원소 >> k만큼 돌기

#error : 그래프 입력 형식부터 다름
from collections import deque
#
# n,m,k,x = map(int,input().split())
# graph = []
# for i in range(m):
#     graph.append(list(map(int,input().split())))
#
# for i in range(m):
#     if graph[i][0] == x:
#         for j in range(k):


#solution : BFS : 모든 간선 비용이 동일하므로
# x를 시작점으로 BFS 수행하여 모든 도시까지 최단 거리 계산
# >> 각 최단 거리 하나씩 확인하며 그 값이 K인 경우 출력
n,m,k,x = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)

distance = [-1]*(n+1)
distance[x] = 0

#bfs
q = deque([x])
while q:
    now = q.popleft()
    #현재 도시에서 이동할 수 있는 모든 도시 확인
    for next_node in graph[now]:
        #아직 방문 x
        if distance[next_node] == -1:
            #최단 거리 갱신
            distance[next_node] = distance[now] + 1
            q.append(next_node)

#최단 거리 k인 도시 출력
check = False
for i in range(1,n+1):
    if distance[i] == k:
        print(i)
        check = True

#최단 거리 k인 도시 없으면
if check == False:
    print(-1)