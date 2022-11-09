package org.example.game.logic;

import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilderParamConfig;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerClient;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;
import org.example.game.logic.action.LoginAction;
import org.example.game.logic.core.MyBarSkeletonConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * 游戏服务器,业务端点
 * @author 梦某人
 * @date 2022/11/6 18:22
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameLogicClient extends AbstractBrokerClientStartup {


    @Override
    public BarSkeleton createBarSkeleton() {

        // 业务框架构建器 配置
        BarSkeletonBuilderParamConfig config = MyBarSkeletonConfig.createBarSkeletonBuilderParamConfig()
                // 扫描 LoginAction.class 所在包
                .addActionController(LoginAction.class);
        //业务框架构建器
        BarSkeletonBuilder builder = MyBarSkeletonConfig.createBarSkeletonBuilder(config);
        // 打开 jsr380 验证
        builder.getSetting().setValidator(true);
        //
        builder.getSetting().setPrintAction(false);

        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        BrokerClientBuilder builder = BrokerClient.newBuilder();
        builder.appName("游戏逻辑服务器");
        return builder;
    }
}
