#기출 04. 만들 수 없는 금액
'''
내풀이
idea : 만들 수 없는 가장 최소 금액 >> 가장 작은 동전부터 더하기
>> break되는 시점을 어떻게 찾지?? >> 특정 금액 target
풀이 오류 : 만들 수 없는 금액 조건 (break되는 시점) : target < coin 화폐 단위
>> 풀이 방법 쉽게 떠오르지 x >> 그리디 알고리즘 문제 많이 풀기
'''
# n = int(input())
# coin = list(map(int,input().split()))
# coin.sort()
#
# result = 1
# for i in range(n):
#     if coin[i] == result:
#         result += 1
#         continue
#     else:
#         for j in range(1,i+1):
#             temp = coin[i] + coin[i-1]
#             if temp == result:
#                 result += 1
#
# print(result)

# for i in range(n):
#     if coin[i] > result or coin[i] == result:
#         result += coin[i]
#     else:
#         if result < coin[i+1] :
#             result += coin[i-1] + coin[i-2]
#         else:
#             break
# print(result)


'''
solution
idea :현재 상태(1 ~ target-1까지 모든 금액을 만들 수 있는 상태 )에서 가장 좋아 보이는 것만 선택
>> 매번 target 금액 만들 수 있는지(현재 확인하는 동전 단위가 target 이하인지)
>> 가능하면, target값 업데이트
step 0 : initialize target = 1
step 1 : target = 1 확인 : 화폐 1 보유 >> target = target + 1 = 2
step 2 : target = 2 확인 : 화폐 2 보유 >> target = target + 2 = 4
step 3 : target = 4 확인 : 화폐 3 보유 >> target = target + 3 = 7
step 4 : target = 7 확인 : 화폐 8 보유 >> target보다 큰 화폐 >> x
'''
n = int(input())
data = list(map(int,input().split()))
data.sort()

target = 1
for x in data:
    #만들 수 없는 금액을 찾았을 때 종료
    if target < x:
        break
    target += x

#최종 출력
print(target)
