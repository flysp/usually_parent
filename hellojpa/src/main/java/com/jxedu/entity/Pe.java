package com.jxedu.entity;

import org.springframework.beans.factory.annotation.Value;

public interface Pe {

    @Value("#{target.name + ' ' + target.address}")
    String getFullName();

    String getName();

    String getAddress();
}
