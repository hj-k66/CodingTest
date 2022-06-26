'''
프로그래머스 Level 1. 체육복
'''
'''
나의 idea : 
>> 정확성 60점
'''
def solution(n, lost, reserve):
    answer = 0
    lost_copy = lost.copy()
    reserve_copy = reserve.copy()
    lost_copy.sort()
    reserve_copy.sort()
    for i in lost:
        if i in reserve:
            lost_copy.remove(i)
            reserve_copy.remove(i)
    answer = n - len(lost_copy)
    for i in lost_copy:
        for j in reserve_copy:
            if j == i-1 :
                answer+= 1
                reserve_copy.remove(j)
            elif j == j+1:
                answer += 1
                reserve_copy.remove(j)
    return answer
'''
solution
'''
def solution(n, lost, reserve):
    _reserve = [r for r in reserve if r not in lost]
    _lost = [l for l in lost if l not in reserve]
    for r in _reserve:
        f = r - 1
        b = r + 1
        if f in _lost:
            _lost.remove(f)
        elif b in _lost:
            _lost.remove(b)
    return n - len(_lost)
# n = 5
# lost = [1,2,4]
# reserve = [2,4,5] #답 4
n = 5
lost = [1,2,4]
reserve = [2,3,4,5] #답 4
print(solution(n,lost,reserve))