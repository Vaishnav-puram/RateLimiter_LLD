package com.rateLimiter.rateLimiter_LLD.TokenBucket;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class TokenBucketApplication {
    public void startTokenBucket(){
        UserBucketCreater userBucketCreater=new UserBucketCreater();
        userBucketCreater.createUser(1,10,5);
        userBucketCreater.createUser(2,20,6);
        userBucketCreater.createUser(3,5,4);
        ExecutorService executorService= Executors.newFixedThreadPool(12);
        for (int i=0;i<36;i++){
            int userId = ThreadLocalRandom.current().nextInt(1, 4); // Randomly select user ID between 1 and 3
            executorService.execute(()->userBucketCreater.accessApplication(userId));
        }
        executorService.shutdown();
    }
}
