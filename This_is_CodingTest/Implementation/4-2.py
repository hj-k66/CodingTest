'''
예제 4-2. 시각
idea : 00시 00분 00초 ~ 23시 59분 59초 >> 86,400가지의 경우의 수
>> 100,000개 이하이므로 단순 완전 탐색으로 해결 가능
'''

h = int(input())

count = 0
for i in range(h+1): #시
    for j in range(60): #분
        for k in range(60): #초
            #매 시각 안에 '3'이 포함되어 있다면 카운트 증가
            if '3' in str(i)+str(j)+str(k):
                # h+m+s = 032035
                count += 1
print(count)


