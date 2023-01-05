package day20;

public enum BattlePiece {
    //SHIP("\uD83D\uDEE5"), EMPTY("?"), HALO("\uD83D\uDFE6"), WRECKED("\uD83D\uDFE5");
    SHIP("s"), EMPTY("_"), HALO("*"), WRECKED("#");

    private String piece;

    BattlePiece(String piece){
        this.piece = piece;
    }
    public String toString(){
        return piece + " ";
    }

}
