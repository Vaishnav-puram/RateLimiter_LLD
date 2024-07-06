package com.rateLimiter.rateLimiter_LLD.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucketCreater {
    Map<Integer, TokenBucket> bucket;

    public UserBucketCreater() {
        bucket = new ConcurrentHashMap<>();
    }

    public void createUser(int id, int capacity,int refreshRate) {
        bucket.put(id,new TokenBucket(capacity,refreshRate));
    }

    public void accessApplication(int id){
        TokenBucket tokenBucket = bucket.get(id);
        if(tokenBucket!=null){
            if(tokenBucket.grantAccess()){
                System.out.println("User "+id+" able to access the application");
            }else{
                System.out.println("Please user : "+ id+" try again after some time.....");
            }
        }else{
            System.out.println("User "+id+" doesn't exists!!!");
        }

    }
}
