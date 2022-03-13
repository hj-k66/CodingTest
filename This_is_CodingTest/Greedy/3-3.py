'''
예제 3 숫자 카드 게임
카드 행을 선택하고 그 중에서 가장 낮은 카드를 뽑는데, 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있게 한다.
Idea : 각 행마다 가장 작은 수를 찾은 뒤에 그 수 중에서 가장 큰 수
'''

#min 함수 이용

#N,M을 공백으로 구분하여 입력받기
n,m = map(int,input().split())

result = 0
#한 줄씩 입력받아 확인
for i in range(n):
    data = list(map(int,input().split()))
    #현재 줄에서 가장 작은 수 찾기
    min_value = min(data)
    #가장 작은 수 중에서 가장 큰 수 찾기
    result = max(result, min_value)

#최종 출력
print(result)