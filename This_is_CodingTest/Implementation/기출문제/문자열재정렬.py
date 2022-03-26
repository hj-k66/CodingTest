#구현 기출 08. 문자열 재정렬
'''
내풀이
idea : 문자열 '123'을 숫자 1,2,3으로 바꾸기
'''

# s = input()
# s = sorted(s)
# result = []
# sum = 0
# for i in s:
#     i = chr(ord(i))
#     if i <= '9' or i >= '0':
#         sum += int(i)
#     else:
#         result.append(i)
# result.append(sum)
#
# print(result)

'''
solution : 알파벳 확인 하는 함수 : isalpha()
'''
s = input()
result=[]
sum=0

for x in s:
    if x.isalpha():
        result.append(x)
    else:
        sum += int(x)
result.sort()

if sum != 0:
    result.append(str(sum))

print(''.join(result))