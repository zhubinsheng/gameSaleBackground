package com.hjf.controller;

import com.alipay.api.AlipayApiException;
import com.hjf.entity.Pay;
import com.hjf.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    AlipayService alipayService;

    @PostMapping("/pay")
    @ResponseBody
    public void Pay(@RequestBody Pay pay, HttpServletResponse response) {
        try {
            alipayService.aliPay(pay.getNumber(),pay.getMoney(),pay.getSubjects(),pay.getGameid(), response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 支付宝同步回调接口
     * @param request
     * @param response
     * @throws IOException
     * @throws AlipayApiException
     */
    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    @ResponseBody
    public void returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
            alipayService.returnUrl(request,response);
    }

    /**
     * @Description: 支付宝异步回调接口(不调用不知道为什么)
     * @return String
     * @throws AlipayApiException
     */
    @RequestMapping(value = "/notifyUrl", method = RequestMethod.POST)
    @ResponseBody
    public String notifyUrl(HttpServletRequest request)
            throws AlipayApiException, UnsupportedEncodingException {
        return  alipayService.notifyUrl(request);

    }
}
