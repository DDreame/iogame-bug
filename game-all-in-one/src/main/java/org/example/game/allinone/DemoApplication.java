package org.example.game.allinone;

import com.iohao.game.simple.SimpleRunOne;
import com.iohao.game.simulation.client.ClientSimulation;
import org.example.game.logic.GameLogicClient;

import java.util.List;

/***
 * @description : Todo
 * @author : 梦某人
 * @date : 2022/11/8 23:14 
 */
public class DemoApplication {

    public static void main(String[] args) {
        int port = 10100;

        new SimpleRunOne()
                .setExternalServer(port)
                .setLogicServerList(List.of(new GameLogicClient()))
                .startup();
        ClientSimulation.start();
    }
}
