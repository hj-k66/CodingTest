#모험가 길드
'''
내풀이
* idea : 가장 높은 공포도로 그룹 인원 지정, 가장 작은 공포도 가진 사람부터 그룹에 넣기
* 풀이 오류 : 모든 모험가를 특정한 그룹에 넣을 필요 없는데, 이를 고려 x
>>가장 공포도가 높은 모험가를 먼저 고려>> 그룹에 넣는 식으로 했기 때문에 가장 적은 그룹 수 리턴됨.

# n = int(input())
# data = list(map(int,input().split()))
#
# data.sort()
# max = data[n-1]
# group = 0
# index = n-1
#
# while n >= max:
#     group += 1
#     n -= max
#     index -= 1
#     max = data[index]
#
# print(group)
'''

'''
solution
* idea : 오름차순 정렬, 공포도가 가장 낮은 모험가부터 하나씩 확인, 현재 그룹에 포함된 모험가 수가 현재 확인하고 있는 공포도보다 크거나 같으면 그룹화
>> 항상 최소한의 모험가 수만 포함하여 그룹 결성 >> 최대한 많은 그룹 결성 가능
* if count >= i라는 조건 덕분에 뒤에 갑자기 공포도 큰 모험가 있어도 그룹 결성 x >> 모든 모험가가 그룹 설정할 필요 x
    >>'공포도가 x인 모험가는 반드시 x명 이상으로 구성한 모험가 그룹에 참여해야 여행 떠날 수 있다' 조건 충족
'''
n = int(input())
data = list(map(int,input().split()))
data.sort()

result = 0 #총 그룹의 수
count = 0 #현재 그룹에 포함된 모험가의 수

for i in data : #공포도를 낮은 것부터 하나씩 확인 하며
    count += 1 #현재 그룹에 해당 모험가를 포함시키기
    if count >= i : #현재 그룹에 포함된 모험가 수가 현재의 공포도 이상이라면, 그룹 결성
        result += 1 #총 그룹 수 증가시키기
        count = 0 #현재 그룹에 포함된 모험가의 수 초기화

print(result)