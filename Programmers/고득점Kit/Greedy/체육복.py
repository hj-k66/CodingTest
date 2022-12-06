'''
프로그래머스 Level 1. 체육복
'''
'''
22.12.06 재풀이
나의 idea : lost배열 sort한 후, 앞 뒤 학생 둘 다 있는 경우, 앞에 학생껄로
- lost와 reserve에 중북되는 원소는 미리 제거한 후 로직 수행
'''


def solution(n, lost, reserve):
    _lost = [elem for elem in lost if not elem in reserve]
    _reserve = [elem for elem in reserve if not elem in lost]

    answer = n - len(_lost)
    _lost.sort()
    for elem in _lost:
        if elem - 1 in _reserve:
            answer += 1
            _reserve.remove(elem - 1)
        elif elem + 1 in _reserve:
            answer += 1
            _reserve.remove(elem+1)
    return answer


n = 3
lost = [1]
reserve = [1] #답 3
print(solution(n,lost,reserve))



# '''
# 나의 idea :
# >> 정확성 60점
# '''
# def solution(n, lost, reserve):
#     answer = 0
#     lost_copy = lost.copy()
#     reserve_copy = reserve.copy()
#     lost_copy.sort()
#     reserve_copy.sort()
#     for i in lost:
#         if i in reserve:
#             lost_copy.remove(i)
#             reserve_copy.remove(i)
#     answer = n - len(lost_copy)
#     for i in lost_copy:
#         for j in reserve_copy:
#             if j == i-1 :
#                 answer+= 1
#                 reserve_copy.remove(j)
#             elif j == j+1:
#                 answer += 1
#                 reserve_copy.remove(j)
#     return answer
# '''
# solution
# '''
# def solution(n, lost, reserve):
#     _reserve = [r for r in reserve if r not in lost]
#     _lost = [l for l in lost if l not in reserve]
#     for r in _reserve:
#         f = r - 1
#         b = r + 1
#         if f in _lost:
#             _lost.remove(f)
#         elif b in _lost:
#             _lost.remove(b)
#     return n - len(_lost)
# # n = 5
# # lost = [1,2,4]
# # reserve = [2,4,5] #답 4
# n = 5
# lost = [1,2,4]
# reserve = [2,3,4,5] #답 4
# print(solution(n,lost,reserve))