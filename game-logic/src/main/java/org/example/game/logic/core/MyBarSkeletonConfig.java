package org.example.game.logic.core;

import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilderParamConfig;
import com.iohao.game.action.skeleton.core.flow.interal.DebugInOut;
import lombok.experimental.UtilityClass;
import org.example.common.GameCodeEnum;

/**
 * @author 梦某人
 * @date 2022/11/6 18:27
 */
@UtilityClass
public class MyBarSkeletonConfig {


    public BarSkeletonBuilderParamConfig createBarSkeletonBuilderParamConfig(){
        // 业务逻辑构建器 配置
        return new BarSkeletonBuilderParamConfig()
                // 开启广播日志
                .setBroadcastLog(true)

                // 异常码生成
                .addErrorCode(GameCodeEnum.values());

        //.addActionSend(SendDoc.class);

    }
    public BarSkeletonBuilder createBarSkeletonBuilder(BarSkeletonBuilderParamConfig config) {
        // 业务框架构建器
        return config.createBuilder()
                // 添加控制台输出插件
                .addInOut(new DebugInOut())
//                // 设置一个自定义的 flow 上下文生产工厂
//                .setFlowContextFactory(MyFlowContext::new)
                ;
    }
}
