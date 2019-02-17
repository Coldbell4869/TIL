package my.examples.shop.controller;

import my.examples.shop.domain.Level;
import my.examples.shop.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LevelController {
    @Autowired
    LevelService levelService;

    @GetMapping("/levelform")
    public String levelform(){
        return "levelform";
    }

    @PostMapping("/levelsave")
    public String rolesave(@RequestParam(name = "name")String name){
        Level level = new Level();
        level.setName(name);
        levelService.addLevel(level);
        return "redirect:/levelform";
    }

}
