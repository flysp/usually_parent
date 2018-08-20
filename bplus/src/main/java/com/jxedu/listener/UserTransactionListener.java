package com.jxedu.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserTransactionListener {


     private  static  final  Logger logger = LoggerFactory.getLogger(UserTransactionListener.class);

    @TransactionalEventListener(phase =  TransactionPhase.AFTER_COMMIT)
      public  void handEvent(UserSaveEvent event){

           logger.info("事务监听..................{}",event.getName());


      }
    public static class UserSaveEvent extends ApplicationEvent {

        private String name;

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public UserSaveEvent(Object source,String name) {
            super(source);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}


