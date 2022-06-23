'''
프로그래머스 Level 2. H-Index
h이상인 값이 h개 이상이고,나머지는 h이하인 값
'''
'''
나의 idea : 내림차순으로 정렬 후,  원소값이 h값보다 크면 h 증가, 같으면 h 리턴
테케 9 통과 x
'''
# def solution(citations):
#     answer = 0
#     citations.sort(reverse = True)
#     h = 0
#     for i in citations:
#         if h==i:
#             return h
#         if i >= h:
#             h += 1
#             if h == i:
#                 return h
#         else:
#             return h
'''
wiki 식 참고해서 짠 코드 >> 테케 모두 통과
https://en.wikipedia.org/wiki/H-index#cite_note-McDonald2005-5
'''
def solution(citations):
    citations.sort(reverse=True)
    h = 0
    for i in range(1,len(citations)+1):
        if citations[i-1] >= i:
            h = max(h,i)
    return h
