package com.worrior.common.pb;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import com.worrior.common.GameProtoFile;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/***
 * 操作是否成功的返回
 * @author : 梦某人
 * @date : 2022/11/9 11:18 
 */
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(filePackage = GameProtoFile.COMMON_FILE_PACKAGE, fileName = GameProtoFile.COMMON_FILE_NAME)
public class ResultPb {
    boolean success;
}
