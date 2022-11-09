package com.example.game.external;

import com.iohao.game.bolt.broker.client.external.ExternalServer;

/**
 * 游戏对外服务器
 * @author 梦某人
 * @date 2022/11/6 13:33
 */
public class GameExternalApplication {

    public static void main(String[] args) {
        // 对客户端端口
        int externalPort = 9999;
        //
        //构建游戏对外服务器
        ExternalServer externalServer = new GameExternal().createExternalServer(externalPort);

        //启动
        externalServer.startup();
    }
}
