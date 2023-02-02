package model;

public interface IDeletedPieceManager {

    void addPiece(Piece piece);
    int count(Piece.Type type);
    Piece removeLast();


}
