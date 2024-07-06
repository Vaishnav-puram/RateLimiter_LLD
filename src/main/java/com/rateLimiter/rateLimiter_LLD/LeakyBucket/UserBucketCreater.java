package com.rateLimiter.rateLimiter_LLD.LeakyBucket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucketCreater {
    Map<Integer,LeakyBucket> bucket;

    public UserBucketCreater() {
        bucket = new ConcurrentHashMap<>();
    }

    public void createUser(int id, int capacity) {
        bucket.put(id,new LeakyBucket(capacity));
    }

    public void accessApplication(int id){
        LeakyBucket leakyBucket = bucket.get(id);
        if(leakyBucket!=null){
            if(leakyBucket.grantAccess()){
                System.out.println("User "+id+" able to access the application");
            }else{
                System.out.println("Please user : "+ id+" try again after some time.....");
            }
        }else{
            System.out.println("User "+id+" doesn't exists!!!");
        }

    }
}
