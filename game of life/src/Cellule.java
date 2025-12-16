import java.util.List;

public class Cellule {

    private boolean[][] grid;

    private boolean[][] tempGrid;

    private void grid() {
        this.grid = new boolean[100][100];
    }

    public boolean[][] gridState() {
        return this.grid;
    }

    public void initiateLoop() {
        grid();
    }

    private void tickUpdate() {
        boolean[][] imgGrid = new boolean[100][100];

        for (int i = 0; i < imgGrid.length; i++) {
            for (int j = 0; j < imgGrid[0].length; j++) {
                if(grid[i][j]){
                    
                    imgGrid[i][j] = true;
                }else{


                    imgGrid[i][j] = false;
                }
            }
        }
    }


    public void killCells(int x, int y) {
        this.grid[x][y] = false;
    }

    public void newCells(int x, int y) {
        this.grid[x][y] = true;
    }

    public int neighborsAlive(int x, int y) {
        int cpt = 0;
        for (int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++){
                if (!(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) && (i != x || j != y)){
                    if (grid[i][j]){
                        cpt++;
                        System.out.println("Codonnée : " + i + " " + j );
                    }
                }
                    
            }
        }

        System.out.println("nb voisin en vie : " + cpt);
        return cpt;

    }

    public List[] cellsAlive() {
        List[] alive = new List[10000];
        int cpt = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length - 1; j++) {
                if (this.grid[i][j] == true) {
                    alive[cpt] = List.of(i, j);
                    cpt += 1;
                }
            }
        }
        return alive;
    }

}
