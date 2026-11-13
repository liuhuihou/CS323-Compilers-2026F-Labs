import generated.Splc.SplcLexer;
import generated.Splc.SplcParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        CharStream input = null;
        try {
            input = CharStreams.fromFileName("testcases/llvm1/base2.splc");
            SplcLexer lexer = new SplcLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SplcParser parser = new SplcParser(tokens);
            SplcParser.ProgramContext program = parser.program();
            LLVMVisitor visitor = new LLVMVisitor();
            visitor.visit(program);
            String llvm = visitor.getLLVM();
            Files.writeString(Path.of("testcases/llvm1/result/base.ll"), llvm);
            System.out.println("written to testcases/llvm1/result/base.ll");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}