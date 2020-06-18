package com.hjf.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.hjf.config.AlipayConfig;
import com.hjf.entity.Cart;
import com.hjf.service.AlipayService;
import com.hjf.service.CartService;
import com.hjf.service.GameService;
import com.hjf.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
@Slf4j
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @Autowired
    GameService gameService;


    @Override
    public void aliPay(String number, String money, String subjects,String gameid,
                       HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String out_trade_no = number;
        //付款金额，从前台获取，必填
        String total_amount = money;
        //订单名称，必填
        String subject = subjects;
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "5m";

        String body = gameid;

        String json = "{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}";

        aliPayRequest.setBizContent(json);

        System.out.println("支付的信息：" + json);
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(aliPayRequest).getBody();
            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            // 直接将完整的表单html输出到页面
            response.getWriter().write(result);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnUrl(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        System.out.println("=================================同步回调=====================================");
        // 获取支付宝GET过来反馈信息
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            map.put(name, valueStr);
        }
        boolean signVerified = false;
        signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
        if (signVerified) {
            PrintWriter out= null;
            out = response.getWriter();
//            out.print("<script>self.opener.location.href = 'http://127.0.0.1:8080/pay';</script>");
//            out.print("<script>self.opener.location.href = 'http://www.baidu.com'");
            out.print("<script>window.close();</script>");
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }

    @Override
    public String notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        System.out.println("=================================异步回调=====================================");
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            log.info(valueStr);
            map.put(name, valueStr);
        }
        //交易状态
        String status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
        //交易内容
        String body = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");
        boolean signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
        if (signVerified) {
            //处理你的业务逻辑，更细订单状态等
            System.out.println("交易状态：" + status);
            System.out.println("验证成功：" + signVerified);
            //交易成功
            if(status.equals("TRADE_SUCCESS")) {
                String[] s = body.split(" ");
                for (int i = 0; i < s.length - 1; i++) {
                    Integer a = Integer.parseInt(s[i]);
                    Integer b = Integer.parseInt(s[s.length - 1]);
                    System.out.println("游戏ID：" + a);
                    System.out.println("用户ID：" + b);
                    Cart c = cartService.showCartTo(a, b);
                    orderService.insertOrder(c.getCartName(),c.getCartPrice(),c.getCartGameid(),
                            c.getCartUserid());
                    gameService.updateSale(a);
                    orderService.updateBol(a, b);
                    cartService.deleteCartToOrder(a, b);
                }
                return "success";
            } else {//交易失败
                String[] s = body.split(" ");
                for (int i = 0; i < s.length - 1; i++) {
                    Integer a = Integer.parseInt(s[i]);
                    Integer b = Integer.parseInt(s[s.length - 1]);
                    orderService.deleteOrderTwo(a, b);
                }
                return "success";
            }
        } else {
            System.out.println("验证失败,不去更新状态");
            return "fail";
        }
    }
}