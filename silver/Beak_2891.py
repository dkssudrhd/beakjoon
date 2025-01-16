N, S, R = map(int, input().split())

brokenTeam = set(map(int, input().split()))
onemoreTeam = set(map(int, input().split()))

answer = 0

intersection = brokenTeam & onemoreTeam 
brokenTeam = list(brokenTeam - intersection)
onemoreTeam = list(onemoreTeam - intersection)

brokenTeam.sort()

for i in brokenTeam:
    if i-1 in onemoreTeam :
        onemoreTeam.remove(i-1)
    elif i+i in onemoreTeam:
        onemoreTeam.remove(i+1)
    else:
        answer += 1

print(answer)