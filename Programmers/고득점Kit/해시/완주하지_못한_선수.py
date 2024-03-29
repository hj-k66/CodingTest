'''
프로그래머스 Level 1. 완주하지 못한 선수
'''
'''
22.12.07 재풀이
나의 idea : 해쉬값 : 참가자 이름>> sum
- sum - 완주자 hash값
- 남은값을 참가자 이름과 mapping 
'''
def solution(participant, completion):
    hash_map = dict()
    sum = 0
    for part in participant:
        hash_value = hash(part)
        hash_map[hash_value] = part
        sum += hash_value
    for comp in completion:
        sum -= hash(comp)
    return hash_map[sum]

'''
나의 idea : sort하고 루프문 돌면서 매칭해보기
'''
def solution(participant, completion):
    participant.sort()
    completion.sort()

    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    #예외처리 : sorting된 completion과 모두 매칭될 경우
    return participant[len(participant) -1]

'''
Other solution : hash 이용한 풀이
* HashMap : key - hash한 값, value - 각 선수 이름
'''
def solution(participant, completion):
    hashDict = {}
    sum = 0

    # 1. Participant의 dict 만들기
    # 2. Participant의 sum 구하기
    for part in participant:
        hashvalue = hash(part)
        hashDict[hashvalue] = part
        sum += hashvalue

    # 3. completion의 hash값 sum에서 빼기
    for comp in completion:
        sum -= hash(comp)

    # 4. 남은 값이 완주하지 못한 선수의 hash값
    return hashDict[sum]
