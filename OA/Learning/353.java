import java.util.LinkedList;
import java.util.Queue;

class SnakeGame {
    int r,c;
    int rows, cols;
    int index;
    int[][] food;
    int score;
    Queue<int[]> snake;
    public SnakeGame(int width, int height, int[][] food) {
        r = 0;
        c = 0;
        rows = height;
        cols = width;
        this.food = food;
        snake = new LinkedList<>();
    }
    
    public int move(String direction) {
        switch(direction){
            case "U":
            r--;
            break;
            case "D":
            r++;
            break;
            case "L":
            c--;
            break;
            case "R":
            c++;
            break;
        }
        if(!isValid(r,c))return -1;
        return process(r,c);
    }

    public boolean isValid(int r, int c){
        return(r >= 0 && r < rows && c >= 0 && c < cols);
    }

    public int process(int r, int c){
        if(index == food.length)snake.poll();
        else if(r == food[index][0] && c == food[index][1]){
            index++;
            score++;
        }else{
            snake.poll();
        }
        for(int[] s:snake){
            if(r == s[0] && c == s[1])return -1;
        }
        snake.add(new int[]{r,c});
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */