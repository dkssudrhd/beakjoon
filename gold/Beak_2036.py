import sys

n = int(sys.stdin.readline())

list = []

minus, zero, one = 0, 0, 0

for i in range(n):
    list.append(int(sys.stdin.readline()))
    if list[i] < 0:
        minus += 1
    elif list[i] == 0:
        zero += 1
    elif list[i] == 1:
        one += 1

plus_start = minus + zero + one
plus = n - plus_start

list.sort()

answer = 0

for i in range(0, minus-1, 2) :
    answer += list[i] * list[i+1]

if minus%2==1 :
    if zero == 0 :
        answer += list[minus-1]

start = 0
if plus%2 == 1 :
    start = 1
    answer += list[plus_start]

answer += one
for i in range(start, plus-1, 2) :
    answer += list[plus_start + i] * list[plus_start + i+1]
print(answer)