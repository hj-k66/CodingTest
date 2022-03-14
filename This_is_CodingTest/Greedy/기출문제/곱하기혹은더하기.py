#기출 02. 곱하기 혹은 더하기
'''
내풀이
idea : 무조건 곱하기로, 0이나 1 나오면 더하기로
'''
s = input()
result = 0

for i in s:
    # i <= 1 or result <= 1
    if (i == '0') or (i == '1') or (result == 0) or (result==1):
        result += int(i)
    else:
        result *= int(i)
print(result)


'''
solution
두 수에 대하여 연산을 수행할 때, 두 수 중에서 하나라도 1 이하인 경우 더하기, 두 수 모두 2 이상인 경우 곱하기
'''
data = input()

#첫 번째 문자를 숫자로 변경하여 대입
result = int(data[0])
for i in range(1,len(data)):
    #두 수 중에서 하나라도 '0' 또는 '1'인 경우, 곱하기보다는 더하기 수행
    num = int(data[i])
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num
print(result)

