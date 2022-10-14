import java.io.IOException;

public class Inputlexer {
    public static void main(String[] args) throws IOException {
        System.out.println("输入 quit 或 exit 退出词法 分析");
        SimpleLexer lex = new SimpleLexer();
        while (true) {
            Token t = lex.scan();
            if (t == null) {
                continue;
            }
            lex.getTokens().put(t.getLexeme(), t);
            System.out.println(t);
            if (t.getLexeme().equals("quit") || t.getLexeme().equals("exit")) {
                break;
            }
        }
        System.out.println(lex.getTokens());
    }
}