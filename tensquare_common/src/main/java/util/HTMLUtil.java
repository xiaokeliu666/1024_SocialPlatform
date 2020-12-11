package util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HTMLUtil {
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // define script label
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // define style label
        String regEx_html = "<[^>]+>"; //define html label
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // remove srcipt
        Pattern
                p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // remove style
        Pattern
                p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // remove html
        return htmlStr.trim(); // return
    }
}
