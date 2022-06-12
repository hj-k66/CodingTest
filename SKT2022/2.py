'''
* 2022 SK텔레콤 T-WorX for Developers 챌린지
* https://programmers.co.kr/competitions/2594?slug=2022-sk-internship
* 일시 : 2022.06.12
* 2번  : TestCase 전부 통과
'''

'''
answer[0] = 이번 달에 VIP가 아니지만 다음 달에 VIP가 되는 고객 수
answer[1] = 이번 달 VIP이지만, 다음 달에 VIP아니게 되는 고객 수
periods : 가입 기간
payments :
다음달 최근 12개월 : 처음 계산했던 최근 12개월 납부에서 제일 처음 1개월 값 빼야함
'''
def findVIP(period, pay):
    if period >= 60:
        if pay >= 900000 or (pay >= 600000 and pay < 900000):
            return True
        else:
            return False
    elif period >= 24:
        if pay >= 900000:
            return True
        else:
            return False
    else:
        return False

def solution(periods, payments, estimates):
    answer = [0,0]

    for i in range(len(periods)):
        thismon_period = periods[i]
        thismon_pay = sum(payments[i])
        thismon_VIP = findVIP(thismon_period,thismon_pay)
        next_period = thismon_period +1
        next_pay = thismon_pay - payments[i][0] + estimates[i]
        next_VIP = findVIP(next_period,next_pay)
        if thismon_VIP == False and next_VIP == True:
            answer[0] += 1
        elif thismon_VIP ==True and next_VIP == False:
            answer[1] += 1
    return answer