import model.*;
import tad.ListCoor;

public class PruebaMain {

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);

        b.startPieces();
        System.out.println(b);
        b = new Board();

        b.testPlacePawn();
        ListCoor coordinates = b.getCell(new Coordinate('C',7)).getPiece().getNextMovements();
        b.highlight(coordinates);
        System.out.println(b);
        b.resetColors();
        System.out.println(b);

        b = new Board();
        b.testPlaceBishop();
        coordinates = b.getCell(new Coordinate('D',6)).getPiece().getNextMovements();
        b.highlight(coordinates);
        System.out.println(b);
        b.resetColors();
        System.out.println(b);

        b = new Board();
        b.testPlaceRook();
        coordinates = b.getCell(new Coordinate('D',6)).getPiece().getNextMovements();
        b.highlight(coordinates);
        System.out.println(b);
        b.resetColors();
        System.out.println(b);

        b = new Board();
        b.testPlaceQueen();
        coordinates = b.getCell(new Coordinate('D',6)).getPiece().getNextMovements();
        b.highlight(coordinates);
        System.out.println(b);
        b.resetColors();
        System.out.println(b);

        b = new Board();
        b.testPlaceKing();
        coordinates = b.getCell(new Coordinate('D',6)).getPiece().getNextMovements();
        b.highlight(coordinates);
        System.out.println(b);
        b.resetColors();
        System.out.println(b);

        b = new Board();
        b.testPlaceKnight();
        coordinates = b.getCell(new Coordinate('D',6)).getPiece().getNextMovements();
        b.highlight(coordinates);
        System.out.println(b);
        b.resetColors();
        System.out.println(b);


    }
}
