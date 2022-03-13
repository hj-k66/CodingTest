#예제 3-1 거스름돈
#Idea : 가장 큰 화폐 단위부터 돈 거슬러 줌

n = 1260
count = 0

#큰 단위의 화폐부터 차례대로 확인
coin_types = [500,100,50,10]

for coin in coin_types:
    count += n // coin #해당 화폐로 거슬러 줄 수 있는 동전의 갯수 세기
    n %= coin

print(count)