import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 用于解析html中的接口并保存在mysql中
 * Created by zhoulei17344 on 2019-4-25.
 */
public class ParseHtml {

    public static void test() throws IOException {
        File input = new File("/tmp/input.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        Element content = doc.getElementById("tr");
        Elements links = content.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
        }
    }
}
