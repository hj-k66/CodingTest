'''
예제 3-2 큰 수의 법칙
Idea : 가장 큰 수를 K번 더하고 두 번째로 큰 수를 한번 더한다
K : 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번 초과해 더하기x
'''

#N,M,K를 공백으로 구분해 입력받기
n,m,k = map(int, input().split())
#N개의 수를 공백으로 구분하여 입력받기
data = list(map(int,input().split()))

data.sort()     #입력받은 수 정렬
first = data[n-1]   #가장 큰 수
second = data[n-2]  #두 번째로 큰 수


'''
가장 큰 수가 더해지는 횟수 계산
반복되는 수열의 길이: k+1 :가장 큰 수를 K번 더하고 두 번째로 큰 수를 한번 더한다
수열이 반복되는 횟수: M/(k+1) 몫
  - 나누어 떨어지지 않는 경우 : M/(k+1) 나머지 만큼 가장 큰 수가 더해짐
가장 큰 수가 등장하는 횟수 : M/(k+1)*K
'''

count = int(m/(k+1))*k
count += m %(k+1)

result = 0
result += (count)*first #가장 큰 수 더하기
result += (m-count)*second  #두 번째로 큰 수 더하기

#최종 답안 출력
print(result)