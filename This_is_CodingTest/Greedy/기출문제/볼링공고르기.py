#기출 05. 볼링공 고르기
'''
내풀이 : 조합 nC2 - 무게 겹치는 경우의 수(조합 (겹치는 갯수)C2 + ...)
>> 겹치는 무게 구하기 : 오름차 정렬 후 1~m 무게 하나씩 target
'''
n,m = map(int,input().split())
k = list(map(int,input().split()))

#겹치는 무게 구하기
k.sort()
count = [0]*11
for i in range(n-1):
    if k[i] == k[i+1]:
        count[k[i]] += 1

#무게 겹치는 경우의 수
weight = 0
for i in count:
    weight += ((i+1)*(i))/2

#최종 계산
result = (n*(n-1) // 2) - weight

print(int(result))