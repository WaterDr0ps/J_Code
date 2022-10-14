import java.io.IOException;
import java.util.Hashtable;

public class SimpleLexer {
    private char ch;
    private Hashtable<String, Token> tokens = new Hashtable<String, Token>();

    public char getCh() {
        return ch;
    }

    public Hashtable<String, Token> getTokens() {
        return tokens;
    }

    public SimpleLexer() {
        tokens.put("if", new Token("if", TagType.KEYWORD));
        tokens.put("else", new Token("else", TagType.KEYWORD));
        tokens.put("while", new Token("while", TagType.KEYWORD));
        tokens.put("do", new Token("do", TagType.KEYWORD));
        tokens.put("break", new Token("break", TagType.KEYWORD));
    }

    /*** 从键盘读一个字符 * @throws IOException */
    void readChar() throws IOException {
        ch = (char) System.in.read();
    }

    /*** 判断键盘输入字符是否是给定字符 c * @param c * @return * @throws IOException */
    boolean readChar(char c) throws IOException {
        readChar();
        if (ch != c) {
            return false;
        }
        ch = '\0';
        return true;
    }

    /*** 分析输入的单词属于哪类 * @return * @throws IOException */
    public Token scan() throws IOException {
        String sToken = "";
        for (; ; readChar()) {
            if (ch == '\0' || ch == '\t' || ch == '\r' || ch == '\n') {
                continue;
            } else {
                break;
            }
        }
        switch (ch) {
            case '&':
                if (readChar('&')) {
                    return Token.and;
                } else {
                    return Token.bitand;
                }
            case '|':
                if (readChar('|')) {
                    return Token.or;
                } else {
                    return Token.bitor;
                }
            case '=':
                if (readChar('=')) {
                    return Token.eq;
                } else {
                    return Token.assign;
                }
            case '!':
                if (readChar('=')) {
                    return Token.ne;
                } else {
                    return Token.not;
                }
            case '<':
                if (readChar('=')) {
                    return Token.le;
                } else {
                    return Token.lt;
                }
            case '>':
                if (readChar('=')) {
                    return Token.ge;
                } else {
                    return Token.gt;
                }
            default:
                break;
        } Token t = null;
        if (Character.isDigit(ch)) {
            int v = 0;
            do {
                sToken = sToken + ch;
                v = 10 * v + Character.digit(ch, 10);
                readChar();
            } while (Character.isDigit(ch));
            sToken = sToken + ch;
            if (ch == '.') {
                float x = v;
                float d = 10;
                for (; ; ) {
                    readChar();
                    sToken = sToken + ch;
                    if (!Character.isDigit(ch)) {
                        break;
                    }
                    x = x + Character.digit(ch, 10) / d;
                    d = d * 10;
                }
                if (ch == '\0' || ch == '\r' || ch == '\n' || ch == '\t') {
                    t = new Token(String.valueOf(x), TagType.NUM);
                } else {
                    t = new Token(sToken, "INVALID");
                }
            } else {
                if (ch == '\0' || ch == '\r' || ch == '\n' || ch == '\t') {
                    t = new Token(String.valueOf(v), TagType.NUM);
                } else {
                    t = new Token(sToken, "INVALID");
                }
            }
            ch = '\0';
            return t;
        }
        if (Character.isLetter(ch)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(ch);
                readChar();
            } while (Character.isLetterOrDigit(ch));
            String s = b.toString();
            t = (Token) tokens.get(s);
            if (t == null) {
                t = new Token(s, TagType.ID);
            }
        }
        ch = '\0';
        return t;
    }
}