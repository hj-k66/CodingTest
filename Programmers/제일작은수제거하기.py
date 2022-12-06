'''
프로그래머스 Level 1. 제일 작은 수 제거하기
나의 idea : min함수 이용해 제일 작은 수 pick >> 제거
'''

def solution(arr):
    arr.remove(min(arr))
    if len(arr) == 0:
        arr.append(-1)
    return arr