package model;

import tad.ListCoor;

public class Queen extends Piece {
    public Queen(Type type, Cell cell){
        super(type, cell);
    }

    @Override
    public ListCoor getNextMovements() {
        return
                Bishop.getNextMovementsAsBishop(this).
                        addAll(Rook.getNextMovementsAsRook(this));
    }


}
