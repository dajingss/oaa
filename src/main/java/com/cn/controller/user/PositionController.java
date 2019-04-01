package com.cn.controller.user;


import com.cn.model.entity.user.Position;
import com.cn.services.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PositionController {

    @Resource
    private PositionService positionService;

    @RequestMapping("/positionList")
    public String positionList(Model model){
       List<Position> positionList= positionService.positionList();
        model.addAttribute("positionList",positionList);
        return "user/positionlist";
    }


    @RequestMapping("/toaddP")
    public String toadd(){
        return "user/positionadd";
    }

    @RequestMapping("/addP")
    public String add(Position position){
        positionService.add(position);
        return "redirect:/positionList";
    }

    @RequestMapping("/toeditP")
    public  String toedit(Model model ,long id){
        Position position =  positionService.findOneById(id);
        model.addAttribute("position",position);
        return "user/positionedit";
    }
    @RequestMapping("/editP")
    public String edit(Position position){
        positionService.edit(position);
        return"redirect:/positionList";
    }

}
