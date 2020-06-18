package com.hjf.service;


import com.alipay.api.AlipayApiException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface AlipayService {

    /**
     * 支付宝支付调用接口
     * @param response
     * @throws IOException
     */
    void aliPay(String number, String money, String subjects, String gameid,
                HttpServletResponse response)throws IOException;

    void returnUrl(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException;

    String notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException;
}
