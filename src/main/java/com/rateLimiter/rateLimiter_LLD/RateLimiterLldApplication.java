package com.rateLimiter.rateLimiter_LLD;

import com.rateLimiter.rateLimiter_LLD.LeakyBucket.LeakyBucketApplication;
import com.rateLimiter.rateLimiter_LLD.LeakyBucket.UserBucketCreater;
import com.rateLimiter.rateLimiter_LLD.TokenBucket.TokenBucket;
import com.rateLimiter.rateLimiter_LLD.TokenBucket.TokenBucketApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimiterLldApplication {

	public static void main(String[] args) {

		SpringApplication.run(RateLimiterLldApplication.class, args);
		LeakyBucketApplication leakyBucketApplication=new LeakyBucketApplication();
		//leakyBucketApplication.startLeakyBucket();
		TokenBucketApplication tokenBucketApplication=new TokenBucketApplication();
		tokenBucketApplication.startTokenBucket();
	}

}
