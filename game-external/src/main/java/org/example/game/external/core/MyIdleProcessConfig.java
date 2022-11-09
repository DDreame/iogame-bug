package com.example.game.external.core;

import com.iohao.game.bolt.broker.client.external.bootstrap.heart.IdleProcessSetting;
import lombok.experimental.UtilityClass;

/***
 * @description : Todo
 * @author : 梦某人
 * @date : 2022/11/8 00:07 
 */
@UtilityClass
public class MyIdleProcessConfig {

    public IdleProcessSetting createMyConfig(){
        return new IdleProcessSetting()
                .allIdleTime(5).readerIdleTime(5).writerIdleTime(5).idleHook(null);
    }
}
