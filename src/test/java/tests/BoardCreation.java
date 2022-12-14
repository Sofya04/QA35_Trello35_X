package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{
    @Test
    public void boardCreation(){

        Board board = new Board().withTitle("MyFirstBoard");
        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrolldownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1);

    }
}
