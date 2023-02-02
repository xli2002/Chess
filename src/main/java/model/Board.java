package model;

import tad.ListCoor;

import java.util.Arrays;

public class Board {

    private Cell[][] cells;

    public Board(){
        cells = new Cell[8][8];
        //to create every cell
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(this, new Coordinate((char)('A'+j),i+1));
            }
        }
    }

    public void highlight(ListCoor coordinates){
//        Coordinate c;
//        while ((c = coordinates.remove(0)) != null)
//            getCell(c).highlight();

        for (int i = 0; i < coordinates.size(); i++) {
            getCell(coordinates.get(i)).highlight();
        }
    }

    public void resetColors(){
        for(Cell[] row : cells)
            for(Cell c : row)
                c.resetColor();
    }


    public Cell getCell(Coordinate coordinate){
        if(coordinate.getRow()<1 || coordinate.getRow()>8)
            return null;
        if(coordinate.getColumn()<'A' || coordinate.getColumn()>'H')
            return null;
        return cells[coordinate.getRow()-1][coordinate.getColumn()-'A'];
    }

    public void startPieces(){
        Piece p;
        p = new RookWhite(getCell(new Coordinate('A',8)));
        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('H',8)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('B',8)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('G',8)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('C',8)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',8)));
        p.putInYourPlace();
        p = new KingWhite(getCell(new Coordinate('D',8)));
        p.putInYourPlace();
        p = new QueenWhite(getCell(new Coordinate('E',8)));
        p.putInYourPlace();

        p = new RookBlack(getCell(new Coordinate('A',1)));
        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',1)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('B',1)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('G',1)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('C',1)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('F',1)));
        p.putInYourPlace();
        p = new KingBlack(getCell(new Coordinate('D',1)));
        p.putInYourPlace();
        p = new QueenBlack(getCell(new Coordinate('E',1)));
        p.putInYourPlace();

        for (int i = 0; i < 8; i++) {
            p = new PawnBlack(getCell(new Coordinate((char)('A'+i),2)));
            p.putInYourPlace();
            p = new PawnWhite(getCell(new Coordinate((char)('A'+i),7)));
            p.putInYourPlace();
        }


    }


    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i+1) + " ";
            for (int j = 0; j < 8; j++) {
                output += cells[i][j];
            }
            output += " " + (i+1) + "\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }

    public void testPlacePawn(){
        Piece p;
        p = new PawnWhite(getCell(new Coordinate('B',6)));
        p.putInYourPlace();
        p = new PawnWhite(getCell(new Coordinate('C',7)));
        p.putInYourPlace();
        p = new PawnBlack(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
    }

    public void testPlaceBishop(){
        Piece p;
        p = new BishopWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',4)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('B',4)));
        p.putInYourPlace();
    }

    public void testPlaceRook(){
        Piece p;
        p = new RookWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('A',6)));
        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',6)));
        p.putInYourPlace();
    }

    public void testPlaceQueen(){
        Piece p;
        p = new QueenWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('A',6)));
        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',6)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',4)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('B',4)));
        p.putInYourPlace();
    }

    public void testPlaceKing(){
        Piece p;
        p = new KingWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('E',6)));
        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('C',6)));
        p.putInYourPlace();
    }


    public void testPlaceKnight(){
        Piece p;
        p = new KnightWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('F',7)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('B',7)));
        p.putInYourPlace();
    }

}
