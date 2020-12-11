package com.tensquare.articlecrawler.processor;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class ArticleProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("https://blog.csdn.net/[a-z 0-9 -]+/article/details/[0‐9]{8}").all());
        String title= page.getHtml().xpath("//h1[@class='title-article']//text()").get();
        String content= page.getHtml().xpath("//article[@class='baidu_pl']").get();
//        get the content that we need
        System.out.println("title@ArticleProcessor:"+title);
        System.out.println("content@ArticleProcessor:"+content);
        if(title!=null && content!=null){ // if title & content exist
            page.putField("title",title);
            page.putField("content",content);
        }else{
            page.setSkip(true);// skip
        }
    }

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(3000).setSleepTime(100);
    }

}
