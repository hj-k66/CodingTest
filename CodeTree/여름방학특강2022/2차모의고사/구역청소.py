a,b = map(int, input().split())
c,d = map(int, input().split())

min = min(a,b,c,d)
max = max(a,b,c,d)

A = b-a
B = d-c

if b<c or d<a:
    print(A+B)
else:
    print(max-min)
