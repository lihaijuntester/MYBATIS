package com.logger;
import org.apache.log4j.Logger;
/**
 * Created by arvin on 2018/1/14.
 */
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class);
    public boolean verfiLoginfo(String username,String password){
        logger.info("Start to verify User [{}]");
        logger.info("Start to verify User [{}]",new UnknownError());
        return false;
    }
}
