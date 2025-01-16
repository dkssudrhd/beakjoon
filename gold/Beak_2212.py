N = int(input())
K = int(input())

road_list = sorted(list(map(int, input().split())))

x = []
for i in range(N-1):
    x += [road_list[i+1] - road_list[i]]

x.sort()
print(x)
print(sum(x[:N-K]))