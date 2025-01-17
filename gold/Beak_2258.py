import sys

N, M = map(int, sys.stdin.readline().split())

meat = []

for _ in range(N) :
    a, b = map(int, sys.stdin.readline().split())
    meat.append((b, a))

meat = sorted(meat, key = lambda x: (x[0], -x[1]))

maxSize = sys.maxsize
weight, same = 0, 0
flage = False

for i in range(N) :
    weight += meat[i][1]
    if i >= 1 and meat[i][0] == meat[i - 1][0] :
        same += meat[i][0]
    else :
        same = 0
    
    if weight >= M:
        maxSize = min(maxSize, meat[i][0] + same)
        flage = True

print(maxSize if flage else -1)

