'''
* 2022 SK텔레콤 T-WorX for Developers 챌린지
* https://programmers.co.kr/competitions/2594?slug=2022-sk-internship
* 일시 : 2022.06.12
* 3번  : TestCase 전부 통과
'''
def solution(n, plans, clients):
    answer = []
    plans[0] = list(map(int, plans[0].split()))
    #plans = [[100,1,3], [500,4,1,3], ...]
    for i in range(1,len(plans)):
        plans[i] = list(map(int, plans[i].split()))
        plans[i] = plans[i] + plans[i-1][1:]

    for i in range(len(clients)):
        clients[i] = list(map(int, clients[i].split()))
        c_data = clients[i][0]
        c_service = clients[i][1:]
        use = False
        use_service = 0 #모든 부가 요금제가 있는지 check
        for j in range(len(plans)):
            if c_data <= plans[j][0]:
                for item in c_service:
                    if item in plans[j][1:]:
                        use_service += 1
                if use_service == len(c_service):
                    answer.append(j+1)
                    use = True
                    break
                else:
                    use_service = 0

        #해당되는 요금제가 없을 경우
        if not use:
            answer.append(0)
    return answer
plans = ["100 1 3","500 4","2000 5"]
clients = ["300 3 5", "1500 1","100 1 3", "50 1 2"]
print(solution(5, plans,clients))