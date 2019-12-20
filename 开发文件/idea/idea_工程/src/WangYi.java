import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WangYi {
    public static void main(String args[]) {
        WangYi wangYi = new WangYi();
        /*wangYi.maina();*/
        wangYi.maine();
    }

    public void maine() {
        try {
            Document document = Jsoup.connect("http://news.163.com/special").get();
            String classs = "div[class=news_list left]>ul>li>a";
            Elements elements = document.select(classs);
            for (org.jsoup.nodes.Element element : elements) {
                //爬到标题
                System.out.print(element.text() + "\t");
            }
        } catch (IOException EX) {
            EX.getMessage();
        }
    }

    public void maina() {
        try {
            Document document = Jsoup.connect("http://news.163.com/special").get();
            String classs = "div[class=news_list left]>ul>li>a";
            Elements elements = document.select(classs);
            for (org.jsoup.nodes.Element element : elements) {
                //再次请求a标签:拿到a标签的href
                String url = element.absUrl("href");
                //这时候拿到的是叠加之后的文档
                Document conn = Jsoup.connect(url).get();
                System.out.println(conn.select("#endText").text());
            }
        } catch (IOException EX) {
            EX.getMessage();
        }
    }
}
