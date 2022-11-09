package org.example.game.broker;

import com.iohao.game.bolt.broker.server.BrokerServer;
import com.iohao.game.bolt.broker.server.BrokerServerBuilder;

/**
 * 网关构建器
 * @author 梦某人
 * @date 2022/11/6 13:27
 */
public class GameBrokerBoot {
    public BrokerServer createBrokerServer(){
        // broker (游戏网关) 构建器
        BrokerServerBuilder brokerServerBuilder = BrokerServer.newBuilder();
        return brokerServerBuilder.build();
    }
}
