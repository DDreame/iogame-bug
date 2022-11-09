package com.worrior.common;

import com.iohao.game.action.skeleton.core.exception.MsgExceptionInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * 异常信息枚举类
 * @author 梦某人
 * @date 2022/11/6 18:42
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum GameCodeEnum implements MsgExceptionInfo {
    /** 登录异常 1xx*/
    LoginError(101, "登录异常"),
    /** 格式错误 9xx */
    FormatError(902, "数据并非JsonObject格式！"),
    /** 存档异常 2xx*/
    ArchiveError(201, "存档失败！情况未知！"),
    ArchiveAuthError(201, "存档异常，尚未登陆")

    ;


    /** 消息码 */
    final int code;
    /** 消息模板 */
    final String msg;

    GameCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
