n = int(input())
grid = []
for _ in range(n):
    grid.append(list(map(int, input().split())))

def get_coin(row_s, row_e, col_s,col_e):
    coin = 0
    for row in range(row_s, row_e+1):
        for col in range(col_s, col_e+1):
            coin += grid[row][col]
    return coin

max_coin = 0
for row in range(n):
    for col in range(n):
        if row +2 >= n or col +2 >=n:
            continue
        coin = get_coin(row,row+2, col, col+2)

        max_coin = max(max_coin, coin)
print(max_coin)
