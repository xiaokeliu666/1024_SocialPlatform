package com.tensquare.articlecrawler.task;

import com.tensquare.articlecrawler.pipeline.ArticleDbPipeline;
import com.tensquare.articlecrawler.pipeline.ArticleTextPipeline;
import com.tensquare.articlecrawler.pojo.Article;
import com.tensquare.articlecrawler.processor.ArticleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

@Component
public class ArticleTask {

    @Autowired
    private ArticleProcessor articleProcessor;

    @Autowired
    private ArticleDbPipeline articleDbPipeline;

    @Autowired
    private ArticleTextPipeline articleTextPipeline;

    @Autowired
    private RedisScheduler redisScheduler;

    @Scheduled(cron = "0 48 21 * * ?")
    public void aiTask(){
        System.out.println("Retrieving AI Article...");
        Spider spider = Spider.create(articleProcessor);
        spider.addUrl("https://blog.csdn.net/nav/ai");
        articleDbPipeline.setChannelId("ai");
        articleTextPipeline.setChannelId("ai");
        spider.addPipeline(articleDbPipeline);
        spider.setScheduler(redisScheduler);
        spider.start();
    }

    @Scheduled(cron = "0 48 21 * * ?")
    public void dbTask(){
        System.out.println("Retrieving db Article...");
        Spider spider = Spider.create(articleProcessor);
        spider.addUrl("https://blog.csdn.net/nav/db");
        articleDbPipeline.setChannelId("db");
        articleTextPipeline.setChannelId("db");
        spider.addPipeline(articleDbPipeline);
        spider.setScheduler(redisScheduler);
        spider.start();
    }

    @Scheduled(cron = "0 48 21 * * ?")
    public void webTask(){
        System.out.println("Retrieving web Article...");
        Spider spider = Spider.create(articleProcessor);
        spider.addUrl("https://blog.csdn.net/nav/web");
        articleDbPipeline.setChannelId("web");
        articleTextPipeline.setChannelId("web");
        spider.addPipeline(articleDbPipeline);
        spider.setScheduler(redisScheduler);
        spider.start();
    }
}
