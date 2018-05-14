package TesteVelha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import JogoVelhaMito.Board;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author udesc
 */
public class BoardTest {
    
    public BoardTest() {
    }

    @Test
    public void testCheckGranny() {
        Board board = new Board();
        board.fillUp();
        assertEquals(true,board.checkGranny());
    }
    
}
