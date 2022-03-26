#구현 기출 07. 럭키 스트레이트
'''
내풀이
idea : 문자열 인덱스를 기준으로 오른쪽,왼쪽 구분
'''

n = input()
left = 0
right = 0
length = len(n)

for i in range(length):
    temp = int(n[i])
    if i >= length/2:
        right += temp
    else:
        left += temp
if left == right:
    print("LUCKY")
else:
    print("READY")

# '''
# solution : 왼쪽의 합과 오른쪽 뺄셈 진행 >> 0이면 럭키스트레이트
# '''
# n = input()
# length = len(n)
# summary = 0
#
# #왼쪽
# for i in range(length//2):
#     summary += int(n[i])
# #오른쪽
# for i in range(length//2, length):
#     summary -= int(n[i])
#
# if summary == 0:
#     print("LUCKY")
# else:
#     print("READY")