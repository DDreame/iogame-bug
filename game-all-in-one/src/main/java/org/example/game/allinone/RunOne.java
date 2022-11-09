package org.example.game.allinone;

import com.iohao.game.action.skeleton.ext.spring.ActionFactoryBeanForSpring;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.client.external.ExternalServer;
import com.iohao.game.bolt.broker.server.BrokerServer;
import com.iohao.game.simple.SimpleRunOne;
import com.iohao.game.simulation.client.ClientSimulation;
import org.example.game.broker.GameBrokerBoot;
import org.example.game.external.GameExternal;
import org.example.game.logic.GameLogicClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/***
 * 整合启动器
 * @author : 梦某人
 * @date : 2022/11/8 23:02 
 */
@SpringBootApplication
public class RunOne {

    public static void main(String[] args) {

        // 启动 spring boot
        SpringApplication.run(RunOne.class, args);

        // 游戏逻辑服列表
        List<AbstractBrokerClientStartup> logicList = List.of(
                // 游戏逻辑服
                new GameLogicClient()
                /*
                 * 启动多个同类型的游戏逻辑服
                 *
                 * 启动 2 个房间的游戏逻辑服
                 * 方便测试 请求同类型多个逻辑服通信结果
                 * https://www.yuque.com/iohao/game/rf9rb9
                 */
        );

        // 对外开放的端口
        int externalPort = 10100;
        // 游戏对外服
        ExternalServer externalServer = new GameExternal().createExternalServer(externalPort);

        // broker （游戏网关）
        BrokerServer brokerServer = new GameBrokerBoot().createBrokerServer();

        // 多服单进程的方式部署（类似单体应用）
        new SimpleRunOne()
                // broker （游戏网关）
                .setBrokerServer(brokerServer)
                // 游戏对外服
                .setExternalServer(externalServer)
                // 游戏逻辑服列表
                .setLogicServerList(logicList)
                // 启动 游戏对外服、游戏网关、游戏逻辑服
                .startup();

        // spring 集成 https://www.yuque.com/iohao/game/evkgnz

        // 客户端模拟类 SpringWebsocketClient.java
        ClientSimulation.start();
    }


    @Bean
    public ActionFactoryBeanForSpring actionFactoryBean() {
        // 将业务框架交给 spring 管理
        return ActionFactoryBeanForSpring.me();
    }
}
