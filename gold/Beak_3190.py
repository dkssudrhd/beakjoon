import sys



# board 보드
# 크기는 [N+2][N+2]
# "-" 벽, " " 빈공간, "A" 사과, "S" 뱀
def board_init():
    N = int(sys.stdin.readline())
    K = int(sys.stdin.readline())

    board = [[" "] * (N+2) for _ in range(N+2)]
    # 시작위치
    board[0][0] = "S"
    
    # 벽 생성
    for i in range(N+1):
        board[0][i] = "-"
    for i in range(N+1):
        board[N+1][i] = "-"
    for i in range(N+1):
        board[i][0] = "-"
    for i in range(N+2):
        board[i][N+1] = "-"
    
    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        board[X][Y] = "A"
    
    return board

# 방향 
direction =[[0, 1], [1, 0], [0, -1], [-1, 0]]

def snake_move(board):
    snake_size = 1
    snakes = [[1,1]]
    now_direction = 0
    now_x = 1
    now_y = 1
    time = 0

    # 뱀의 방향 전환
    moveChanges = []
    L = int(sys.stdin.readline())
    for _ in range(L):
        moveChanges.append(list(sys.stdin.readline().split()))

    while True:
        time +=1
        now_x += direction[now_direction][0]
        now_y += direction[now_direction][1]

        if board[now_x][now_y] in ("-", "S"):
            break
        elif board[now_x][now_y] == "A":
            board[now_x][now_y] = "S"
            snake_size +=1
            snakes.append([now_x, now_y])
        else:
            snakes.append([now_x, now_y])
            board[now_x][now_y] = "S"
            before = snakes.pop(0)
            board[before[0]][before[1]] = " "
        
        if len(moveChanges) >0 and moveChanges[0][0] == str(time):
            if moveChanges[0][1] == "D":
                now_direction = (now_direction + 1) % 4
            else:
                now_direction = (now_direction + 3) % 4
            moveChanges.pop(0)

    return time

# 보드 출력 함수
def board_print(board):
    for i in range(len(board)):
        for j in range(len(board[i])):
            print(board[i][j], end=" ")
        print()

if __name__ == "__main__":
    board = board_init()
    
    time = snake_move(board)

    print(time)