package com.cn.controller.user;

import com.cn.model.entity.user.Dept;
import com.cn.services.Deptservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeptController {

    @Resource
    private Deptservice deptservice;
    /*@RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }*/

    @RequestMapping("/list")
    public String deptmanage(Model model) {
        List<Dept> depts = deptservice.deptList();
        model.addAttribute("depts",depts);
        return "user/deptmanage";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/deptadd";
    }

    @RequestMapping("/add")
    public String add(Dept dept) {
        deptservice.add(dept);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        deptservice.delete(id);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        Dept depts = deptservice.findOne(id);
        model.addAttribute("depts", depts);
        return "user/deptedit";
    }

    @RequestMapping("/edit")
    public String edit(Dept dept) {
        deptservice.edit(dept);
        return "redirect:/list";
    }

}
