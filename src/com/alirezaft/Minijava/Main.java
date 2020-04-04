package com.alirezaft.Minijava;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import com.alirezaft.Minijava.gen.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        CharStream Stream = null;
        try {
            Stream = CharStreams.fromFileName("Code.mj");
        } catch (IOException e) {
            e.printStackTrace();
        }

        MiniJavaLexer lexer = new MiniJavaLexer(Stream);
        MiniJavaBaseListener listener = new MiniJavaBaseListener();
        CommonTokenStream TokenStream = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(TokenStream);
        ParseTree Ptree = parser.program();
        ParseTreeWalker PtreeWalker = new ParseTreeWalker();
        MiniJavaListener MJListener = new MiniJavaBaseListener();
        PtreeWalker.walk(MJListener, Ptree);

//        System.out.println(Stream.getText(new Interval(0, 200)));
    }
}
