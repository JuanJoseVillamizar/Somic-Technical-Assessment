package JuanJose.PruebaSomic.entities;

public enum TransactionType {
    INCOME('+'),
    OUTGOING('-');
    private final char code;

    TransactionType(char code) {
        this.code = code;
    }

    public char getCode(){
        return code;
    }

    //Converts a character code into the corresponding TransactionType.
    public static  TransactionType fromCode (char code){
        for(TransactionType type : TransactionType.values()){
            if(type.code == code){
                return type;
            }
        }
        throw new IllegalArgumentException(
                "Invalid TransactionType code: '" + code + "'. Valid codes are '+' and '-'."
        );
    }
}
