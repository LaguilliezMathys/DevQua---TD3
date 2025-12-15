import java.util.List;

public class Cellule {

    private boolean[][] grid;

    private void grid(){
        this.grid = new boolean[100][100];
    }

    public boolean[][] gridState(){
        return this.grid;
    }

    public void initiateLoop(){
        grid();
    }



    private void tickUpdate(){
       boolean[][] imgGrid = this.gridState();       
        killCells(0, 0);
        newCells(0, 0);
    }
 
    private void killCells(int x, int y){
        this.grid[x][y] = true;    
    } 


    public List[] cellsAlive(){
        List[] alive = new List[10000];
        int cpt = 0;
        for (int i = 0; i < grid.length - 1; i++){
            for (int j = 0; j < grid.length - 1; j++) {
                if(this.grid[i][j] == true){
                    alive[cpt] = List.of(i, j);
                    cpt += 1;     
                }
            }
        }
        return alive;
    }

    

    public void newCells(int x, int y){
        this.grid[x][y] = true;    
    }
}
