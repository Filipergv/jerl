package com.translator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.antlr.JavaLexer;
import com.antlr.JavaParser;

public class GenerateParseTree {
	public static void main(String[] args) {
    	
    	InputStream is = null;
    	String inputFile = null;
    	
          if (args.length > 0){ 
        	  inputFile = args[0];
          	  is = System.in;
          }else 
        	  inputFile = "/home/varjao/workspace/jerl/examples/HelloWorld.java";

        try {
                is = new FileInputStream("/home/varjao/workspace/jerl/examples/HelloWorld.java");
//                is = new FileInputStream(inputFile);
                String outputFile = inputFile.substring(0, inputFile.length()-5)+"cerl";

                ANTLRInputStream input = new ANTLRInputStream(is);
                JavaLexer lexer = new JavaLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                JavaParser parser = new JavaParser(tokens);
                ParseTree tree = parser.compilationUnit();
                System.out.println(tree.toStringTree(parser));

//                ParseTreeWalker walker = new ParseTreeWalker();
//    			walker.walk(new Translate(), tree);
/*
                FileWriter cerl = new FileWriter(new File(outputFile));
                BufferedWriter bw = new BufferedWriter(cerl);

                bw.write(tree.toStringTree(parser)); //bw.newLine();
                bw.close();
*/
            } catch (Exception e) {
              e.printStackTrace();
              }
	}
}
