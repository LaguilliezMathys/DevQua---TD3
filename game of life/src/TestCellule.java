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
    public void CellsAlive(){

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





}
