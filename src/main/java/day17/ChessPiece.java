package day17;

public enum ChessPiece {
    KING_WHITE(100, "♔"), KING_BLACK(100, "♚"), QUEEN_WHITE(9, "♕"), QUEEN_BLACK(9, "♛"), BISHOP_WHITE(3.5, "♗"), BISHOP_BLACK(3.5, "♝"), KNIGHT_WHITE(3, "♘"), KNIGHT_BLACK(3, "♞"),
    ROOK_WHITE(5, "♖"), ROOK_BLACK(5, "♜"), PAWNS_WHITE(1, "♙"), PAWNS_BLACK(1, "♟"), EMPTY(-1, "_");

    private double value;
    private String chess;

    ChessPiece(double value, String chess){
        this.value = value;
        this.chess = chess;
    }
    public String toString(){
        return chess + " ";
    }
}
