package com.example.game.external;

import com.iohao.game.bolt.broker.client.external.ExternalServer;
import com.iohao.game.bolt.broker.client.external.ExternalServerBuilder;
import com.iohao.game.bolt.broker.client.external.bootstrap.ExternalJoinEnum;
import com.iohao.game.bolt.broker.client.external.config.ExternalGlobalConfig;
import com.iohao.game.bolt.broker.core.client.BrokerAddress;
import com.iohao.game.bolt.broker.core.common.BrokerGlobalConfig;
import com.example.game.external.core.MyIdleProcessConfig;

/**
 *
 * @author 梦某人
 * @date 2022/11/6 13:35
 */
public class GameExternal {

   public ExternalServer createExternalServer( int externalPort){
      extractedIgnore();

      //游戏对外服务器
      ExternalServerBuilder externalServerBuilder = ExternalServer.newBuilder(externalPort)
              //启动心跳
              .enableIdle(MyIdleProcessConfig.createMyConfig())
              // websocket 方式链接
              .externalJoinEnum(ExternalJoinEnum.WEBSOCKET)
              // Broker (游戏网关)的链接地址,默认也是如此
              .brokerAddress(new BrokerAddress("127.0.0.1", BrokerGlobalConfig.brokerPort));


      return externalServerBuilder.build();
   }

   private void extractedIgnore(){
      /*
       * 注意，权限相关验证配置在游戏对外服是正确的，因为是游戏对外服在控制访问验证
       * see https://www.yuque.com/iohao/game/tywkqv#qEvtB
       */
      var accessAuthenticationHook = ExternalGlobalConfig.accessAuthenticationHook;

      //登录才能访问业务方法
      //暂时关闭
      accessAuthenticationHook.setVerifyIdentity(false);

      //配置无需登录也可也方位的路由方法
      //accessAuthenticationHook.addIgnoreAuthenticationCmd()
   }
}
