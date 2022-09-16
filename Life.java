
/**
 * A Java Program that simulates the Game of Life.
 * The user must be able to provide these 3 things, in this order, and as arguments when executing the program from Console
 * (see 'Example run command in console' below):
 * 1) the number of iterations (any integer)
 * 2)the size of the square grid (any integer)
 * 3)which pattern type to initialize the cells with:
 * -Penta-decathlon Oscillator (enter P)
 * -Simkin glider gun (enter S)
 * -Random (enter R)
 *
 * @author (Apurva Acharya)
 * @version (14 September 2022)
 */

import java.awt.Color;

public class Life
{
    private int size; //size of the square grid
    private int current[][]; //current 2D Grid
    private int previous[][]; //previous 2D Grid
    private int mag; //pixel width of each cell
    private Picture picture; //picture to be drawn on screen

    /**
     * Constructor for objects of class Life
     */
    public Life(int s, char p)
    {
        size = s;
        //picture = new Picture(1000,1000)
        picture = new Picture(800, 800);
        mag = 800 / size; // pixel-width of each cell
        
        
        current = new int[size][size];
        previous = new int[size][size];
        
        if(p == 'P' || p == 'p')
            penta();
        else if(p == 'S' || p == 's')
            simkin();
        else if(p == 'R' || p == 'r')
            random();
    }
    
    //initialize the cells with Penta-decathlon Oscillator
    public void penta(){
        //setting the initial layout for the Penta-decathlon Oscillator
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++){
                current[i][j] = 0;
            }
        }
        current[20][20] =1;
        current[21][20] =1;
        current[22][19] =1;
        current[22][21] =1;
        current[23][20] =1;
        current[24][20] =1;
        current[25][20] =1;
        current[26][20] =1;
        current[27][19] =1;
        current[27][21] =1;
        current[28][20] =1;
        current[29][20] =1;
    
    }
    //initialize the cells with Simkin glider gun
    public void simkin(){
        //setting the initial layout for the simkin glider run
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++){
                current[i][j] = 0;
            }
        }
        current[20][20] =1;
        current[20][21] =1;
        current[20][27] =1;
        current[20][28] =1;
        
        current[21][20] =1;
        current[21][21] =1;
        current[21][27] =1;
        current[21][28] =1;
        
        current[23][24] =1;
        current[23][25] =1;
        
        current[24][24] =1;
        current[24][25] =1;
        
        current[29][42] =1;
        current[29][43] =1;
        current[29][45] =1;
        current[29][46] =1;
        
        current[30][41] =1;
        current[30][47] =1;
        
        current[31][41] =1;
        current[31][48] =1;
        current[31][51] =1;
        current[31][52] =1;
        
        current[32][41] =1;
        current[32][42] =1;
        current[32][43] =1;
        current[32][47] =1;
        current[32][51] =1;
        current[32][52] =1;
        
        current[33][46] =1;
        
        current[37][40] =1;
        current[37][41] =1;
        
        current[38][40] =1;
        
        current[39][41] =1;
        current[39][42] =1;
        current[39][43] =1;
        
        current[40][43] =1;
    }
    //initialize the cells with random
    public void random(){
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++){
                if (Math.random() >= 0.5D){ //Math.random() gives values between 0 and 1
                    current[i][j] = 1;
                }
                else{
                    current[i][j] = 0;
                    previous[i][j] = 1;
                }
            }
        }
    }
    
    public void save()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                previous[i][j] = current[i][j]; //saving the current grid of the cell
        }
    }
    
    public void update()
    {
    
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                //checking all the neighbours and adding the sum
                //int neighbours_sum = previous[i][(j+1)%size] + previous [i][(j-1)%size] + previous[(i+1)%size][j] + previous[(i-1)%size][j] + previous[(i+1)%size][(j+1)%size] + previous[(i+1)%size][(j-1)%size] + previous[(i-1)%size][(j+1)%size]+ previous[(i-1)%size][(j-1)%size] ;     
                int neighbours_sum = previous[(i + 1 + size) % size][j] % 2 + previous[(i + 1 + size) % size][(j + 1 + size) % size] % 2 + previous[(i + 1 + size) % size][((j - 1) + size) % size] % 2  + previous[i][(j + 1 + size) % size] % 2 + previous[((i - 1) + size) % size][(j + 1 + size) % size] % 2 + previous[((i - 1) + size) % size][((j - 1) + size) % size] % 2 + previous[i][((j - 1) + size) % size] % 2 +  previous[((i - 1) + size) % size][j] % 2;
                //applying the rules of game of life
                if (neighbours_sum < 2) { 
                    current[i][j] = 0;
                }
                else if (neighbours_sum == 2){
                    if (previous[i][j] == 1)
                        current[i][j] = 1;
                    else 
                        current[i][j] = 0;
                }
                else if (neighbours_sum == 3){
                    current[i][j] = 1;
                }
                else {
                    current[i][j] = 0;
                }
            }
        }        
    }
    
    private void colorCell(int i, int j){
        Color color;
        if (current[i][j] == 1) 
            color = Color.BLACK;
        else 
            color = Color.WHITE;
        
        for(int k = 0; k < mag; k++)
        {
            for(int l = 0; l < mag; l++)
                picture.set(i * mag + k, j * mag + l, color);

        }        
    }
    
    public void show(){
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
                colorCell(i, j);
        }
        picture.show();
    }
    
    // must provide number of iterations = n, the size of square grid = s, and which pattern type to initialize the cell with = p
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]); //iterations
        int s = Integer.parseInt(args[1]); //size
        char p = args[2].charAt(0); // pattern
        Life life = new Life(s,p);
        life.show();
        
        for (int i = 0; i < n; i++)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            life.save();
            life.update();
            life.show();
            
        }
        

    }
}
