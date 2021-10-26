package Design;

public class Leetcode348 {
    //store the value of rows
    int[] rows;
    //store the value of cols
    int[] cols;
    int N;
    // check if diagnal line has values
    int dia;
    // check if reverse diagnal line has values
    int reverseDia;
    public Leetcode348(int n){
        this.rows = new int[n];
        this.cols = new int[n];
        this.dia = 0;
        this.reverseDia = 0;
        this.N = n;
    }
    public int move(int row, int col, int player){
        int add = player==1?1:-1;
        rows[row] += add;
        cols[col] += add;
        dia += col == row?add:0;
        reverseDia += N-col-1 == row?add:0;
        if(Math.abs(rows[row]) == N || Math.abs(cols[col]) == N|| Math.abs(reverseDia) == N || Math.abs(dia) == N)return player;
        return 0;
    }
}
