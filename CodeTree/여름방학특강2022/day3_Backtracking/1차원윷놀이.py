'''
내풀이 : 말의 조합 >> 중복순열로 구한 후 distance에 matching
>> 거리합이 m-1이상인 경우 >> 점수 증가 >> 최고점 출력
결과 : 통과 but, 시간 너무 오래걸림
>> 말과 score를 하나의 배열로 표현가능(index = 말, elem = 말의 위치)
'''

# n,m,k = map(int,input().split())
# distance = list(map(int, input().split()))
# mal = []
# score = [0]*(k+1)
# max_score = 0
#
# def find_combination(curr):
#     global score
#     global max_score
#     if curr == n+1:
#         for i in range(len(distance)):
#             score[mal[i]] += distance[i]
#         # print(*mal)
#         # print("score : ",*score)
#         curr_score = 0
#         for elem in score:
#             if elem >= m-1:
#                 curr_score+=1
#         # print("max_score : ", max_score)
#         if max_score <= curr_score:
#             max_score = curr_score
#         score = [0]*(k+1)
#         return
#     for _k in range(1,k+1):
#         mal.append(_k)
#         find_combination(curr+1)
#         mal.pop()
# find_combination(1)
# print(max_score)

'''
other solution
backtracking 이용해 말의 조합 생성
n번에 턴 마다 k개 주 어떤 말을 움직일지 선택하는 재귀함수
>> 이미 점수를 획득한 말은 선택에서 제외
- piece의 index 조합 = 말 조합
'''
n,m,k = map(int,input().split())
distance = list(map(int, input().split()))
scores = [1]*k

max_score = 0
def calc():
     score = 0
     #말의 배열 중 이미 마지막에 도달한 말이 있으면 count
     for s in scores:
         score += (s >= m)
     return score

def find_max(curr):
    global max_score

    #말을 직접 n번 움직이지 않아도
    #최대가 될 수 있으므로 항상 답을 갱신
    max_score = max(max_score,calc())

    #종료조건
    if curr == n:
        return

    for i in range(k):
        #이미 점수 획득한 말은 움직이지 x
        if scores[i] >= m:
            continue

        scores[i] += distance[curr]
        find_max(curr+1)
        scores[i] -= distance[curr]

find_max(0)
print(max_score)
