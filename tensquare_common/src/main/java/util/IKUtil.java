package util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

public class IKUtil {
//    Return text after split
//    Input: Original text
//    Apply Segmenter to segment the text
//    Use space as split char then return
    public static String split(String content,String splitChar) throws IOException {
        StringReader sr=new StringReader(content);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex=null;
        StringBuilder sb=new StringBuilder("");
        while((lex=ik.next())!=null){
            sb.append(lex.getLexemeText()+splitChar);
        }
        return sb.toString();
    }

}
