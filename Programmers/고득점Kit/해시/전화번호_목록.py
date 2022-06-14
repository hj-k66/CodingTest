'''
프로그래머스 Level 2. 전화번호 목록
나의 idea : 전화번호 한자리씩 hash값 더해가면서, 기존 값 존재하면 return False >> 시간초과
>> list.append는 hashmap보다 훨씬 오래걸림
리스트를 append 하는 행동과 딕셔너리에 키와 값을 input 하는 행동은 약 20~30% 차이남.
'''
def solution(phone_book):
    answer = True
    hashnumber = []
    for num in phone_book:
        temp = ''
        hashnumber.append(hash(num))
        for number in num:
            temp += number
            if hash(temp) in hashnumber and temp != num:
                return False
    return answer

'''
solution
1. hash 이용
'''
def solution(phone_book):
    # 1. Hash map을 만든다
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1

    # 2. 접두어가 Hash map에 존재하는지 찾는다
    for phone_number in phone_book:
        jubdoo = ""
        for number in phone_number:
            jubdoo += number
            # 3. 접두어를 찾아야 한다 (기존 번호와 같은 경우 제외)
            if jubdoo in hash_map and jubdoo != phone_number:
                return False
    return True


'''
solution
2. hash 이용 x, sorting 후 바로 전 phonenumber와 비교 
'''
def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if len(phone_book[i]) < len(phone_book[i+1]):
            if phone_book[i + 1][:len(phone_book[i])] == phone_book[i]:
                answer = False
                break
    return answer
