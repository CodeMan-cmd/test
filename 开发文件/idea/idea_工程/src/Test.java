import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test {
    public static void main(String args[]) throws IOException {
        //第一步请求url—Dom文档
        Document document = Jsoup.connect("https://tieba.baidu.com/f?kw=%C1%C4%CC%EC&fr=ala0&tpl=5").get();
        //解析
        String selecttor = "div[class=threadlist_author pull_right]";
        Elements elements = document.select(selecttor);
        for (org.jsoup.nodes.Element element : elements) {
            Elements title=element.select("div[class=threadlist_detail clearfix]");
            //test就是遍历出div下面的所有对象
        }
    }
}
