package examples;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class urlencode {
   public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "start;/?:@=&!*’()+$,#[] ~end";
        System.out.println( URLEncoder.encode(str, "utf-8") );
    }
}
