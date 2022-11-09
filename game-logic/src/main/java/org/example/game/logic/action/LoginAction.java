package org.example.game.logic.action;

import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.exception.MsgException;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import lombok.extern.slf4j.Slf4j;
import org.example.common.cmd.LoginVerifyModule;
import org.example.common.pb.LoginRequestPb;
import org.example.common.pb.ResultPb;
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


    /**
     * 登录验证
     * @return Stringpb 同时返回用户存档
     * @throws MsgException exception
     */
    @ActionMethod(LoginVerifyModule.LOGIN)
    public ResultPb loginVerify(LoginRequestPb loginValue, FlowContext flowContext) throws MsgException {

        //登陆操作 并返回是否登陆成功
        ResultPb result = new ResultPb();
        result.success = true;
        return result;
    }


//    @ActionMethod(LoginVerifyModule.SIGNUP)
//    public ResultPb SignUp(){
//
//        ResultPb result = new ResultPb();
//        return  result;
//    }
}
