package com.hjf.service.impl;

import com.hjf.dao.GameDao;
import com.hjf.dao.OrderDao;
import com.hjf.entity.Game;
import com.hjf.entity.GameSale;
import com.hjf.entity.Order;
import com.hjf.entity.Sort;
import com.hjf.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public ArrayList<Game> showGame() {
        return gameDao.showGamePro();
    }

    @Override
    public int insertGame(String gameName, BigDecimal gamePrice, String gameDescription, BigDecimal gameDiscount,
                          Boolean gamePromotion, String gameCharacter, String gameImg, String gameDown,Integer gameSale) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("游戏创建时间：" + dateFormat.format(date));
        String gameTime =  dateFormat.format(date);
        gameDao.addSortcount(gameCharacter);
        return gameDao.insertGamePro(gameName,gamePrice,gameDescription,gameDiscount,
                gamePromotion,gameCharacter,gameImg,gameDown,gameSale,gameTime);
    }

    @Override
    public int deleteGame(Integer gameId) {
        Game g = gameDao.showIdgamePro(gameId);
        gameDao.updateSort(g.getGameCharacter());
        return gameDao.deleteGamePro(gameId);
    }

    @Override
    public int updateGame(String gameName, BigDecimal gamePrice, String gameDescription,
                          BigDecimal gameDiscount, Boolean gamePromotion, String gameCharacter,
                          String gameImg, Integer gameId, String gameDown) {
        BigDecimal price = gamePrice.multiply(gameDiscount);
        ArrayList<Order> o = gameDao.selOrder(gameId);
        Game g = gameDao.showOneGamePro(gameName);
        String dec = g.getGameCharacter();
        if(dec != gameCharacter){
            gameDao.updateSortOnePro(dec);
            gameDao.updateSortTwoPro(gameCharacter);
        }
        gameDao.updateCartmsg(gameName,price,gameImg,gameId);
        gameDao.updateCollectmsg(gameName,price,gameImg,gameId);
        if(o != null) {
            orderDao.updateName(gameId,gameName);
        }
        return gameDao.updateGamePro(gameName,gamePrice,gameDescription,gameDiscount,
                gamePromotion,gameCharacter,gameImg,gameId,gameDown);
    }

    @Override
    public ArrayList<Game> showLike(String gameName) {
        return gameDao.showLikePro(gameName);
    }

    @Override
    public ArrayList<Sort> getSort() {
        ArrayList<Sort> getsort = gameDao.getSortPro();
        return getsort;
    }

    @Override
    public ArrayList<GameSale> getSale() {
        ArrayList<GameSale> getsale = gameDao.getSalePro();
        return getsale;
    }

    @Override
    public Game showOneGame(String gameName) {
        return gameDao.showOneGamePro(gameName);
    }

    @Override
    public Game showIdgame(Integer gameId) {
        return gameDao.showIdgamePro(gameId);
    }

    @Override
    public ArrayList<Game> showBlock() {
        return gameDao.showBlockPro();
    }

    @Override
    public ArrayList<Game> showSale() {
        return gameDao.showSalePro();
    }

    @Override
    public ArrayList<Game> showNewgame() {
        return gameDao.showNewgamePro();
    }

    @Override
    public ArrayList<Game> showSortgame(String gameCharacter) {
        return gameDao.showSortgamePro(gameCharacter);
    }

    @Override
    public Game duplicate(String gameName) {
        return gameDao.duplicatePro(gameName);
    }

    @Override
    public void updateSale(Integer gameId) {
        gameDao.updateSale(gameId);
    }

}
