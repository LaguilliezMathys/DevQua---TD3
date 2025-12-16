import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


public class TestCellule {
    
    @Test 
    public void GridIsCreated(){

        Cellule cellule = new Cellule();
        cellule.initiateLoop();
        boolean[][] grid = cellule.gridState();

        assertEquals(100 , grid.length);

    }

    @Test
    public void CellsIsAlive(){

        Cellule cellule = new Cellule();
        cellule.initiateLoop();
        boolean[][] grid = cellule.gridState();

        cellule.newCells(2, 3);
        cellule.newCells(4, 5);
        cellule.newCells(6, 7);

        List[] alive = cellule.cellsAlive();

        assertEquals(List.of(2,3), alive[0]);
        assertEquals(List.of(4,5), alive[1]);
        assertEquals(List.of(6,7), alive[2]);

        }


        @Test
        public void cellNumberOfNeighbors(){
            Cellule cellule = new Cellule();
            cellule.initiateLoop();
            boolean[][] grid = cellule.gridState();

            cellule.newCells(2, 2);
            cellule.newCells(2, 3);
            cellule.newCells(1, 3);
            cellule.newCells(1,1);
            


            assertEquals(3, cellule.neighborsAlive(2, 2));

            cellule.newCells(1,2 );
            assertEquals(4, cellule.neighborsAlive(2, 2));

            cellule.newCells(10, 11);
            assertEquals(4, cellule.neighborsAlive(2, 2));
        }

        @Test
        public void cellNumberOfNeighborsNearOOB(){
         Cellule cellule = new Cellule();
            cellule.initiateLoop();
            boolean[][] grid = cellule.gridState();

            cellule.newCells(0, 0);
            cellule.newCells(0, 1);
            cellule.newCells(1, 0);

            assertEquals(2, cellule.neighborsAlive(0, 0)); 

            cellule.newCells(99, 99);
            cellule.newCells(98, 99);
            cellule.newCells(99, 98);
            assertEquals(2, cellule.neighborsAlive(99, 99)); 

        }

        @Test 
        public void cellAloneDies(){
            Cellule cellule = new Cellule();
            cellule.initiateLoop();
            boolean[][] grid = cellule.gridState();
    
            cellule.newCells(50, 50);
            cellule.tickUpdate();
    
            assertFalse(grid[50][50]);
        }



}
