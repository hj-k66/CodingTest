'''
프로그래머스 Level 1. K번째 수
나의 idea : 슬라이싱으로 배열 자르고, sort()함수로 정렬 후 k번째 수 리턴 >> 통과
'''

# def solution(array, commands):
#     answer = []
#
#     for command in commands:
#         i = command[0]
#         j = command[1]
#         k = command[2]
#         split_arr = array[i-1:j]
#         split_arr.sort()
#         answer.append(split_arr[k-1])
#     return answer
#
array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
# print(solution(array, commands))


'''
other solution 1. 
* for i,j,k in commands로 2차원 배열 요소 바로 뽑아올 수 있음
'''
def solution(array, commands):
    answer = []
    for i,j,k in commands:
        answer.append(list(sorted(array[i-1:j]))[k-1])
    return answer
print(solution(array,commands))

'''
other solution 2.
* lambda, map 이용
'''
def solution(array, commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))
