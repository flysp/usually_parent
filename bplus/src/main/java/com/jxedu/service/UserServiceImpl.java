package com.jxedu.service;

import com.jxedu.bean.User;
import com.jxedu.listener.UserTransactionListener;
import com.jxedu.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventPublicationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    TransactionTemplate transactionTemplate;

    @Resource
    UserMapper userMapper;

    @Resource
            private ApplicationContext applicationContext;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void saveUser(User user) {

        transactionTemplate.execute((TransactionStatus status) -> {
            try {
                userMapper.insert(user);
                applicationContext.publishEvent(new UserTransactionListener.UserSaveEvent(this,"usersaveTest"));
               int a = 2 / 0;
            } catch (Exception e) {
                status.setRollbackOnly();
                logger.info("异常信息：{}", e.getMessage());
            }
            return null;
        });

    }
}
