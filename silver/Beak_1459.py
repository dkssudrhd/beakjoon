
str = input()
strList = str.split()

numbers = list(map(int, strList))
sum = int(0)


# 가로 + 세로가 대각선보다 짧을 경우
if numbers[2] * 2 < numbers[3] :
    sum = (numbers[0] + numbers[1]) * numbers[2]

# 가로, 세로가 대각선보다 오래 걸릴 경우
elif numbers[2] > numbers[3] :
    num = min(numbers[0], numbers[1])
    num2 = numbers[0] + numbers[1] - num*2

    sum = num * numbers[3]
    if (numbers[0] + numbers[1])%2 ==0:
        sum += num2 * numbers[3]
    else :
        sum += (num2-1) * numbers[3] + numbers[2]

# 중간일 경우
else :
    num = min(numbers[0], numbers[1])
    num2 = numbers[0] + numbers[1] - num*2
    sum = num * numbers[3] + num2 * numbers[2]

print(sum)  