package com.hjf.dao;

import com.hjf.entity.Game;
import com.hjf.entity.GameSale;
import com.hjf.entity.Order;
import com.hjf.entity.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface GameDao {
    ArrayList<Game> showGamePro();

    int insertGamePro(@RequestParam("gameName") String gameName,
                      @RequestParam("gamePrice") BigDecimal gamePrice,
                      @RequestParam("gameDescription") String gameDescription,
                      @RequestParam("gameDiscount") BigDecimal gameDiscount,
                      @RequestParam("gamePromotion") Boolean gamePromotion,
                      @RequestParam("gameCharacter") String gameCharacter,
                      @RequestParam("gameImg") String gameImg,
                      @RequestParam("gameDown") String gameDown,
                      @RequestParam("gameSale") Integer gameSale,
                      @RequestParam("gameTime") String gameTime);

    int deleteGamePro(@RequestParam("gameId") Integer gameId);

    int updateGamePro(@RequestParam("gameName") String gameName,
                      @RequestParam("gamePrice") BigDecimal gamePrice,
                      @RequestParam("gameDescription") String gameDescription,
                      @RequestParam("gameDiscount") BigDecimal gameDiscount,
                      @RequestParam("gamePromotion") Boolean gamePromotion,
                      @RequestParam("gameCharacter") String gameCharacter,
                      @RequestParam("gameImg") String gameImg,
                      @RequestParam("gameId") Integer gameId,
                      @RequestParam("gameDown") String gameDown);

    ArrayList<Game> showLikePro(@RequestParam("gameName") String gameName);

    ArrayList<Sort> getSortPro();

    ArrayList<GameSale> getSalePro();

    Game showOneGamePro(@RequestParam("gameName")String gameName);

    Game showIdgamePro(@RequestParam("gameName") Integer gameId);

    ArrayList<Game> showBlockPro();

    ArrayList<Game> showSalePro();

    ArrayList<Game> showNewgamePro();

    ArrayList<Game> showSortgamePro(@RequestParam("gameCharacter") String gameCharacter);

    void updateCartmsg(@RequestParam("gameName") String gameName,
                       @RequestParam("price") BigDecimal price,
                       @RequestParam("gameImg") String gameImg,
                       @RequestParam("gameId") Integer gameId);

    void updateCollectmsg(@RequestParam("gameName") String gameName,
                          @RequestParam("price") BigDecimal price,
                          @RequestParam("gameImg") String gameImg,
                          @RequestParam("gameId") Integer gameId);

    Game duplicatePro(@RequestParam("gameName") String gameName);

    void addSortcount(@RequestParam("gameCharacter") String gameCharacter);

    void updateSort(@RequestParam("gameCharacter") String gameCharacter);

    ArrayList<Order>  selOrder(@RequestParam("gameId") Integer gameId);

    void updateSale(@RequestParam("gameId") Integer gameId);

    /**
     * 若修改商品分类，更新分类的数量
     */
    void updateSortOnePro(@RequestParam("dec") String dec);

    void updateSortTwoPro(@RequestParam("gameId") String gameCharacter);

}
