package com.cn.controller.user;

import com.cn.model.entity.user.LoginRecord;
import com.cn.services.LoginRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LoginRecordController {

    @Resource
    private LoginRecordService loginRecordService;

    @RequestMapping("/loginRecordList")
    public  String LoginRecordList(Model model){
        List<LoginRecord> loginRecordList=loginRecordService.loginRecordList();
        model.addAttribute("loginRecordList",loginRecordList);
        return "user/loginRecord";
    }


}
