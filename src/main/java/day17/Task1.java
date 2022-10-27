package day17;

public class Task1 {
    public static void main(String[] args) {
        ChessPiece[] chess = {ChessPiece.PAWNS_WHITE, ChessPiece.PAWNS_WHITE, ChessPiece.PAWNS_WHITE, ChessPiece.PAWNS_WHITE,
                ChessPiece.ROOK_BLACK, ChessPiece.ROOK_BLACK, ChessPiece.ROOK_BLACK, ChessPiece.ROOK_BLACK};
        for (int i = 0; i<chess.length; i++){
            System.out.print(chess[i].toString());
        }

    }
}