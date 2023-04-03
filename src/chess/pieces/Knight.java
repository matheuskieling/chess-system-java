package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        if (position.getRow() - 1 >= 0) {
            // above
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getRow() - 1 >= 0 && position.getColumn() - 1 >= 0) {
            // diag up left
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getRow() - 1 >= 0 && position.getColumn() + 1 < mat.length) {
            // diag up right
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getRow() + 1 < mat.length) {
            // below
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getRow() + 1 < mat.length && position.getColumn() - 1 >= 0) {
            // diag down left
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getRow() + 1 < mat.length && position.getColumn() + 1 < mat.length) {
            // diag down right
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getColumn() - 1 >= 0) {
            // left
            p.setValues(position.getRow(), position.getColumn() - 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        if (position.getColumn() + 1 < mat.length) {
            // right
            p.setValues(position.getRow(), position.getColumn() + 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
