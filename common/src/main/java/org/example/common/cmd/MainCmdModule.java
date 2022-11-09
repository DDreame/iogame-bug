package com.worrior.common.cmd;

/**
 * 这里存放所有的模块 主CMD
 * @author 梦某人
 * @date 2022/11/6 13:11
 */
public interface MainCmdModule {
    /**  用户模块 */
    int loginVerify = 1;
    /**  存档模块 */
    int archive = 2;
    /**  其他模块 */
    int other = 3;
}
