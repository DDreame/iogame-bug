package com.worrior.game.logic.all.action;

import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.exception.MsgException;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import com.iohao.game.bolt.broker.client.kit.ExternalCommunicationKit;
import com.iohao.game.bolt.broker.client.kit.UserIdSettingKit;
import com.worrior.common.GameCodeEnum;
import com.worrior.common.cmd.LoginVerifyModule;
import com.worrior.common.enums.LoginTypeEnum;
import com.worrior.common.pb.LoginRequestPb;
import com.worrior.common.pb.ResultPb;
import com.worrior.game.logic.all.entity.Archive;
import com.worrior.game.logic.all.service.ArchiveService;
import com.worrior.game.logic.all.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author 梦某人
 * @date 2022/11/6 18:34
 */
@Component
@Slf4j
@ActionController(LoginVerifyModule.CMD)
public class LoginAction {


    @Autowired
    private ArchiveService archiveService;
    @Autowired
    private UserService userService;
    /**
     * 登录验证
     * 1.判断参数正确
     * 2.判断是否在线
     * 3.在线情况下判断是否顶号
     * 4.完成登陆设置状态
     * @return Stringpb 同时返回用户存档
     * @throws MsgException exception
     */
    @ActionMethod(LoginVerifyModule.LOGIN)
    public ResultPb loginVerify(LoginRequestPb loginValue, FlowContext flowContext) throws MsgException {
        //判断参数
        GameCodeEnum.LoginError.assertTrue(loginValue.type < LoginTypeEnum.Unexpect.getCode());
        //判断是否在线
        Archive archive = archiveService.getArchiveByToken(loginValue.account);
        boolean login = ExternalCommunicationKit.existUser(archive.getId());
        if(login){
            //已经登陆而且不考虑顶号就抛出异常
            GameCodeEnum.LoginError.assertTrue(loginValue.type != LoginTypeEnum.Conflict.getCode(), "当前账号已登陆");
            ExternalCommunicationKit.existUser(archive.getId());
        }
        //登陆操作 并返回是否登陆成功
        ResultPb result = new ResultPb();
        result.success = UserIdSettingKit.settingUserId(flowContext,archive.getId());
        return result;
    }


//    @ActionMethod(LoginVerifyModule.SIGNUP)
//    public ResultPb SignUp(){
//
//        ResultPb result = new ResultPb();
//        return  result;
//    }
}
