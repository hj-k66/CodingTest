#기출 05. 볼링공 고르기
'''
내풀이 : 조합 nC2 - 무게 겹치는 경우의 수(조합 (겹치는 갯수)C2 + ...)
>> 겹치는 무게 구하기 : 오름차 정렬 후 1~m 무게 하나씩 target
'''
# n,m = map(int,input().split())
# k = list(map(int,input().split()))
#
# #겹치는 무게 구하기
# k.sort()
# count = [0]*11
# for i in range(n-1):
#     if k[i] == k[i+1]:
#         count[k[i]] += 1
#
# #무게 겹치는 경우의 수
# weight = 0
# for i in count:
#     weight += ((i+1)*(i))/2
#
# #최종 계산
# result = (n*(n-1) // 2) - weight
#
# print(int(result))
#


'''
Solution
무게마다 볼링공 몇 개 있는지 계산 >> 리스트 선언해서 각 무게별로 볼링공 몇 개 있는지 기록
'''

n,m = map(int,input().split())
data = list(map(int,input().split()))

#1~10까지 무게 담을 수 있는 리스트
array = [0]*11

for x in data:
    #각 무게에 해당하는 볼링공의 갯수 카운트
    array[x] += 1

result = 0
#1~m까지의 각 무게에 대해 처리
for i in range(1,m+1):
    n -= array[i]   #무게가 i인 볼링공의 갯수(A가 선택할 수 있는 갯수)제외
    result += array[i]*n #B가 선택하는 경우의 수와 곱하기

print(result)