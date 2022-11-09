package com.worrior.common.pb;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import com.worrior.common.GameProtoFile;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/***
 * 登陆请求Pb
 * @author : 梦某人
 * @date : 2022/11/9 11:04 
 */
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = GameProtoFile.LOGIN_MODULE_FILE_NAME, filePackage = GameProtoFile.COMMON_FILE_PACKAGE)
public class LoginRequestPb {
    /* 登陆请求
     * 0: 游客登陆--account表示mac
     * 1：用户登录--account表示账号
     * 2: 用户登录--顶号
     */
    /** 登陆请求 */
    int type;
    String account;
}
