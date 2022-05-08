#기출 16.연구소
#내풀이 : 2를 중심으로 탐색해야하나? 1을 중심으로 탐색해야하나?
# >> 이미 존재하는 1과 새로운 벽 1로 2를 감싸야하는데 이걸 어케 하지

# n,m = map(int, input().split())
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, input())))


# solution
#idea: 벽 3개를 설치하는 모든 경우의 수 다 계산한 후 DFS or BFS 통해 안전 영역 계산.
# 맵의 최대 크기가 8X8이므로, 모든 경우의 수는 64 C 3 >> 100,000보다 작으므로 제한 시간 내 모든 경우의 수 고려 가능
# 조합 계산 : 1. 파이썬 조합 라이브러리  2. DFS or BFS 이용
# >> 벽의 개수가 3개가 되는 모든 조합 찾은 후, 그 경우에 대해 DFS or BFS 이용해 안전 영역 크기 계산

n,m = map(int, input().split())
graph = []  #초기 맵 리스트
temp = [[0]*m for _ in range(n)] #벽을 설치한 뒤의 맵 리스트
for _ in range(n):
    graph.append(list(map(int, input().split())))

#4가지 이동 방향에 대한 리스트
dx = [-1,1,0,0]
dy = [0,0,-1,1]

result = 0

#DFS이용해 각 바이러스가 사방으로 퍼지도록 하기
def virus(x,y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        #상,하,좌,우 중에서 바이러스가 퍼질 수 있는 경우
        if nx >= 0 and nx < n and ny >=0 and ny < m:
            if temp[nx][ny] == 0:
                #해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                temp[nx][ny] = 2
                virus(nx,ny)
#현재 맵에서 안전 영역의 크기 계산하는 메서드 >> 0의 개수 구하기
def get_score():
    score = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                score += 1
    return score

#DFS 이용해 울타리 설치하면서, 매번 안전 영역 크기 계산
def dfs(count):
    global result
    #울타리가 3개 설치된 경우
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = graph[i][j]    # 울타리 3개 설치된 버전 temp로 표현
        #각 바이러스의 위치에서 전파 진행
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    virus(i,j)
        #안전 영역의 최댓값 계산
        result = max(result, get_score())
        return
    #빈 공간에 울타리 설치
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                count += 1
                dfs(count)
                graph[i][j] = 0
                count -= 1

dfs(0)
print(result)