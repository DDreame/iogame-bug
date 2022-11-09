package org.example.game.broker;

import com.iohao.game.bolt.broker.server.BrokerServer;

/**
 * 单独启动类
 * @author 梦某人
 * @date 2022/11/6 13:30
 */
public class GameBrokerApplication {

    public static void main(String[] args){
        BrokerServer brokerServer = new GameBrokerBoot().createBrokerServer();
        //启动闯网关
        brokerServer.startup();
    }
}
