package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        if (position.getRow() - 1 >= 0) {
            //above
            p.setValues(position.getRow() - 1, position.getColumn());
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getRow() - 1 >= 0) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setRow(p.getRow() - 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(0, 0);
        }

        if (position.getColumn() - 1 >= 0) {
            //left
            p.setValues(position.getRow(), position.getColumn() - 1);
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getColumn() - 1 >= 0 ) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setColumn(p.getColumn() - 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(0, 0);
        }

        if (position.getColumn() + 1 < mat.length) {
            //right
            p.setValues(position.getRow(), position.getColumn() + 1);
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getColumn() + 1 < mat.length) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setColumn(p.getColumn() + 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(0, 0);
        }

        if (position.getRow() + 1 < mat.length) {
            //below
            p.setValues(position.getRow() + 1, position.getColumn());
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && p.getRow() + 1 < mat.length) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setRow(p.getRow() + 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(0, 0);
        }
        return mat;
    }
}
