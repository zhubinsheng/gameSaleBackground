package com.hjf.controller;

import com.hjf.entity.Game;
import com.hjf.entity.GameSale;
import com.hjf.entity.Sort;
import com.hjf.entity.Userinfo;
import com.hjf.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;


    /**
     * 显示商品信息
     * @return
     */
    @PostMapping("/showallgame")
    @ResponseBody
    public ArrayList<Game> showGame(){
        ArrayList<Game> showGame =  gameService.showGame();
        System.out.println("显示商品");
        return showGame;

    }

    /**
     * 管理员添加商品
     * @return
     */
    @PostMapping("/insertgame")
    @ResponseBody
    public String insertGame(@RequestBody Game game){
        int res = gameService.insertGame(game.getGameName(),game.getGamePrice(),game.getGameDescription(),
                game.getGameDiscount(), game.getGamePromotion(),game.getGameCharacter(),game.getGameImg(),
                game.getGameDown(),game.getGameSale());
        if(res == 0){
            System.out.println("添加商品失败");
            return "error";
        }else {
            System.out.println("添加商品成功");
            return "success";
        }
    }

    /**
     * 管理员删除商品
     * @return
     */
    @PostMapping("/deletegame")
    @ResponseBody
    public String deleteGame(@RequestBody Game game){
        int res = gameService.deleteGame(game.getGameId());
        if(res == 0){
            System.out.println("删除失败");
            return "error";
        }else {
            System.out.println("删除成功");
            return "success";
        }
    }

    /**
     * 管理员修改商品
     * @return
     */
    @PostMapping("/updategame")
    @ResponseBody
    public String updateGame(@RequestBody Game game){
        System.out.println(game);
        int res = gameService.updateGame(game.getGameName(),game.getGamePrice(),game.getGameDescription(),
                game.getGameDiscount(), game.getGamePromotion(),game.getGameCharacter(),game.getGameImg(),
                game.getGameId(),game.getGameDown());
        if(res == 0){
            System.out.println("修改失败");
            return "error";
        }else {
            System.out.println("修改成功");
            return "success";
        }
    }

    /**
     * 模糊查询
     * @return
     */
    @PostMapping("/showlike")
    @ResponseBody
    public ArrayList<Game> showLike(@RequestBody Game game){
        ArrayList<Game> showLike = gameService.showLike(game.getGameName());
        System.out.println("模糊查询成功");
        return showLike;
    }

    /**
     * 返回各分类游戏数
     * @return
     */
    @PostMapping("/getsort")
    @ResponseBody
    public ArrayList<Sort> getSort(){
        ArrayList<Sort> showsort = gameService.getSort();
        System.out.println("返回各分类游戏数");
        return showsort;
    }

    /**
     * 返回各分类游戏列表
     * @return
     */
    @PostMapping("/showsortgame")
    @ResponseBody
    public ArrayList<Game> showSortgame(@RequestBody Game game){
        ArrayList<Game> showsortgame = gameService.showSortgame(game.getGameCharacter());
        System.out.println("返回各分类游戏列表");
        return showsortgame;
    }

    /**
     * 返回游戏销售数量排名前十
     * @return
     */
    @PostMapping("/getsale")
    @ResponseBody
    public ArrayList<GameSale> getSale(){
        ArrayList<GameSale> showsale = gameService.getSale();
        System.out.println("返回游戏销售数量排名前十");
        return showsale;
    }

    /**
     * 返回游戏最新促销排名前五的游戏
     * @return
     */
    @PostMapping("/showblock")
    @ResponseBody
    public ArrayList<Game> showBlock(){
        ArrayList<Game> showblock = gameService.showBlock();
        System.out.println("返回游戏最新促销排名前五的游戏");
        return showblock;
    }

    /**
     * 返回游戏最新促销排名前十的游戏
     * @return
     */
    @PostMapping("/showsale")
    @ResponseBody
    public ArrayList<Game> showSale(){
        ArrayList<Game> showsale = gameService.showSale();
        System.out.println("返回游戏最新促销排名前十的游戏");
        return showsale;
    }

    /**
     * 返回游戏最新排名前十的游戏
     * @return
     */
    @PostMapping("/shownewgame")
    @ResponseBody
    public ArrayList<Game> showNewgame(){
        ArrayList<Game> shownewgame = gameService.showNewgame();
        System.out.println("返回游戏最新排名前十的游戏");
        return shownewgame;
    }



    /**
     * 通过游戏名查找一个游戏
     * @return
     */
    @PostMapping("/showonegame")
    @ResponseBody
    public Game showOneGame(@RequestBody Game game){
        Game showOneGame =  gameService.showOneGame(game.getGameName());
        System.out.println("查找一个游戏");
        return showOneGame;
    }

    /**
     * 通过游戏ID查找一个游戏
     * @return
     */
    @PostMapping("/showidgame")
    @ResponseBody
    public Game showGame(@RequestBody Game game){
        Game showidgame =  gameService.showIdgame(game.getGameId());
        System.out.println("查找一个游戏");
        return showidgame;
    }

    /**
     * 添加时游戏名是否重复
     * @param game
     * @return
     */
    @PostMapping("/duplicate")
    @ResponseBody
    public String Duplicate(@RequestBody Game game){
        Game usercount= gameService.duplicate(game.getGameName());
        if(usercount==null){
            System.out.println("游戏名未被使用");
            return "success";
        }else {
            System.out.println("游戏名重复");
            return "error";
        }
    }

}
