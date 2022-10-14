public class Token {
    // 词素名称
    private String lexeme;
    // 词素大类
    private String tagType;

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public Token(String lexeme) {
        super();
        this.lexeme = lexeme;
    }

    public Token(String lexeme, String tagType) {
        super();
        this.lexeme = lexeme;
        this.tagType = tagType;
    }

    @Override
    public String toString() {
        return "<" + lexeme + "," + tagType + ">";
    }

    public static final Token and = new Token("&&", TagType.OP),
            or = new Token("||", TagType.OP),
            eq = new Token("==", TagType.OP),
            ne = new Token("!=", TagType.OP),
            le = new Token("<=", TagType.OP),
            ge = new Token(">=", TagType.OP),
            assign = new Token("=", TagType.OP),
            not = new Token("!", TagType.OP),
            lt = new Token("<", TagType.OP),
            gt = new Token(">", TagType.OP),
            bitand = new Token("&", TagType.OP),
            bitor = new Token("|", TagType.OP),
            bitxor = new Token("^", TagType.OP);
}