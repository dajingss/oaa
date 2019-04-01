package com.cn.controller.user;

import com.cn.controller.login.VerifyCodeUtils;
import com.cn.model.entity.user.User;
import com.cn.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "login/login";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "index/test";
    }
    @RequestMapping("/logins")
    public String  loginCheck(HttpSession session, HttpServletRequest req, Model model, User user){
        String ca=req.getParameter("code").toLowerCase();
        String sesionCode = (String) req.getSession().getAttribute("codekey");
        if(!ca.equals(sesionCode.toLowerCase())){
            System.out.println("验证码输入错误!");
            model.addAttribute("errormess", "验证码输入错误!");
            req.setAttribute("errormess","验证码输入错误!");
            return "login/login";
        }
        Map map=userService.findUserOne(user);
        if (map.get("msg").equals("登录成功")){
            session.setAttribute("thisuser",map.get("user"));
            return  "index/index";
        }
        return "login/login";
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

        // 生成图片
        int w = 135, h = 40;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

        // 将验证码存储在session以便登录时校验
        session.setAttribute("codekey", verifyCode.toLowerCase());
    }

}
