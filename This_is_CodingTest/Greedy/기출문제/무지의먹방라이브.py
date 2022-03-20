# 기출 06. 무지의 먹방 라이브
'''
내 풀이 : food_times길이 // k = 리스트 전체 원소에서 1 빼는 횟수, food_times 길이 % k = 결과인덱스 +1
'''


def solution(food_times, k):
    answer = 0
    times = k // len(food_times)
    index = k % len(food_times) -1
    for i in range(times):
        food_times = [j - 1 for j in food_times]

    while True:
        if food_times[index] > 0:
            answer = index
            break
        else:
            index += 1
            if index == len(food_times)-1:
                index = 0

    return answer

print(solution([3,1,2], 5))

'''
solution
idea : 음식을 시간 순으로 정렬 >> 가장 적게 걸리는 음식부터 제거 
>> 우선순위 큐 이용 : 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 것
>> (음식 시간, 음식 번호)
>>heapq : 이진 트리 기반의 min heap 자료구조 >> 가장 작은 값이 이진 트리의 루트
'''
import heapq

def solution(food_times,k):
    #전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
    if sum(food_times) <= k:
        return -1

    #시간이 적은 음식부터 빼야 하므로 우선순위 큐 이용
    q = []
    for i in range(len(food_times)):
        #(음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
        heapq.heappush(q, (food_times[i], i+1))

    sum_value = 0   #먹기 위해 사용한 시간
    previous = 0    #직전에 다 먹은 음식 시간
    length = len(food_times)    #남은 음식의 갯수

    # sum_value + (현재 음식 시간 - 이전 음식 시간) * 현재 음식 갯수 와 k 비교
    while sum_value + ((q[0][0] - previous)*length) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now-previous)*length
        length -= 1 #다 먹은 음식 제외
        previous = now  #이전 음식 시간 재설정

    #남은 음식 중에서 몇 번째 음식인지 확인하여 출력
    result = sorted(q,key=lambda x: x[1])   #음식 번호 기준으로 정렬
    return result[(k-sum_value) % length][1]