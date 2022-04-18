#실전 문제 : 음료수 얼려 먹기
#내풀이
#idea : 근접한 0이 없을 때까지 하나
#>>오류 : 상하좌우를 살피는 걸 안함. count 세는 것도 dfs안에서 해결하려함 >> XX dfs는 함수로 처리하고 실제 count는 마지막에 처리, dfs내에서는 True return되게

n,m = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input())))
count = 0
def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if i == '0' and not visited[i]:
            dfs(graph,i,visited)

visited = [False]*n*m
dfs(graph,0,visited)

#solution
# 1. 특정 지점의 주변 상,하,좌,우를 살펴본 뒤에
#     값이 '0'이면서 아직 방문하지 않은 지점이 있다면 해당 지점 방문
# 2. 방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문 다시 진행

n,m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input())))

#DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x,y):
    #주어진 범위 벗어나는 경우 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    #현재 노드를 아직 방문 안했다면
    if graph[x][y] == 0:
        #해당 노드 방문 처리
        graph[x][y] = 1
        #상,하,좌,우 위치 모두 재귀적으로 호출
        dfs(x-1,y) #좌
        dfs(x,y-1) #상
        dfs(x+1,y) #우
        dfs(x,y+1) #하
        return True

    #1이면 False
    return False

#모든 노드에 대해 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        #현재 위치에서 DFS 수행
        if dfs(i,j) == True:
            result += 1
print(result)

