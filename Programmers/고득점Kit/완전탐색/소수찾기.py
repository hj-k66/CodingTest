'''
프로그래머스 Level 2. 소수 찾기
나의 idea : numbers 숫자로 >> 모든 숫자조합 담은 배열 생성 >> 소수인지 판별
소수 : 약수가 1과 자기 자신
실패 요인 : 숫자 조합을 만드는 법을 찾지 못함.
'''
def solution(numbers):
    answer = 0
    num_list = list(map(lambda x:x, numbers))
    c_list = set()
    for i in range(len(num_list)):
        c_list.append(int(num_list[i]))
        c_list.append(int(num_list[i] + num_list[i+1]))
    return answer
'''
solution
- 순열 라이브러리 이용
'''
from itertools import permutations
def solution(numbers):
    answer = []
    nums = list(map(lambda x:x, numbers))                  # numbers를 하나씩 자른 것
    per = []
    for i in range(1, len(numbers)+1):            # numbers의 각 숫자들을 순열로 모든 경우 만들기
        per += list(permutations(nums, i))        # i개씩 순열조합
    new_nums = [int(("").join(p)) for p in per]   # 각 순열조합을 하나의 int형 숫자로 변환

    for n in new_nums:                            # 모든 int형 숫자에 대해 소수인지 판별
        if n < 2:                                 # 2보다 작은 1,0의 경우 소수 아님
            continue
        check = True
        for i in range(2,int(n**0.5) + 1):        # n의 제곱근 보다 작은 숫자까지만 나눗셈
            if n % i == 0:                        # 하나라도 나눠떨어진다면 소수 아님!
                check = False
                break
        if check:
            answer.append(n)                      # 소수일경우 answer 배열에 추가

    return len(set(answer))                       # set을 통해 중복 제거 후 반환