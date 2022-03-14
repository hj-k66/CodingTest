#기출 03. 문자열 뒤집기
'''
내 풀이
idea : 무조건 연속된 숫자가 있으면 연속뒤집기로, 전체 x
풀이오류 : 선택 조건을 전체를 뒤집는거와 부분적으로 뒤집는 것 2가지로 생각
>> 부분 뒤집기가 기본이고, 0으로 뒤집을 때와 1로 뒤집을 때로 생각해야함.
>>주어진 문제에만 너무 집중하지 않기!
'''

# s = input()
# count = 0
# factor=s[0]
# for i in s:
#     if factor == i:
#         continue
#     else:
#         factor = i
#         count += 1
# print(count-1)
#

'''
solution
idea : 전부 0으로 바꾸는 경우와 전부 1로 바꾸는 경우 중, 더 적은 횟수 경우 계산
'''
data = input()
count0 = 0 #전부 0으로 바꾸기
count1 = 0 #전부 1로 바꾸기

#첫 번째 원소에 대해 처리
if data[0] == '1':
    count0 += 1
else:
    count1 += 1

#두 번째 원소부터 모든 원소를 확인하며
for i in range(len(data) -1):
    #달라지는 경우
    if data[i] != data[i+1]:
        #다음 수에서 1로 바뀌는 경우
        if data[i+1] == '1':
            count0 += 1
        else:
            count1 += 1
print(min(count0,count1))