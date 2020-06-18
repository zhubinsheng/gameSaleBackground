package com.hjf.config;

public class AlipayConfig {

    // 商户appid
    public static String APPID = "2016101500692510";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCUdDaqjfzh5y1AssmvJismmiMZQz9hZnQPxiMkpOL7fAJsf4V7aC0vZuUJjA750p8PjRcM4FuaIho2qIc+i2lPpYrOcp/lyOhoUSl5KVqkJEy7mlgvjGEBgOvL0Xvuc4tYkBDrxinrqvrz6A/CBAA9TqBrFEFHEBTDvPNpxLh/F5Og3y+T9youQY70Ckd5OxeIeU272ZzuxNpq+B/k1OYh+i5Z+YTVtIWb+mbaQBWOXDD1WX3djfXpLrw4sw+mJyH+/RGMTgPYmC5TdRI2MYG/fQa3c9/64c3ueoKKLNeNSUF51qgkp5Q9fpi8Vl/B+BMmrVy91o8ZmzoTAA+maVV5AgMBAAECggEAMu/5PeZASeb/oP53s3BeR/2FY4queaYk1rC+qDknZPD1B/Ntgp2JO4WLuw3iqZe6WiSoLxPgem+PHQgQd8ZwGRMNIK817CtWi0yl9VvaLQ4Dgi+AaLg7JL/uqF21r2jX/EhadfvlsGZXe0858PFcf6y14GfvyglbhpoTz0vfnkOayKtsYctTqkOnTxwyfRN+XYDW7zzROENiRSVzDzapu27osgLxuWWvWtQ54cIUwLR9Rp+Qi2xf5I9JVDQ4driu/a/CeFmB9KA9xCuZiXaO0FQuBst55aLaGOQLvnsthUSK2JlMtSl9o4SmZdwKMg/Wmy7UyEBqCmmcvBrZtHW6gQKBgQDeIU0waDEMjAScNbhwfAdcUCZjEHKXIg5JdV3H/9bvM+y2KWLAkeR2fWuxk4iZapPwxg5rf8LRCDaE9g/AMdwp4Uykg2u7nLOvbSJydMfX6s2cfnac3YwM9TQbFK4piG2puw7emp3VuHB34bFDS9VXzhI706SHZPDUCKHbRjV7sQKBgQCrFwOW2onXfO2MFP6RW/c1AofNrDarCAHj9Olh8Hh7zpcgrd3RxjRYv13COG4G+XPTFlFan35aXP0cxlNuHO15BzgjFKfU1zIZL+se7e+V92VsiK9586X4k+4K/T4nOR9ljM0rJ6EiuYil0UseAjJvQ6Rz5+S/8NMSvpB1Ec4QSQKBgQCfNaU6peNKB+2h/QsWbH9mFfh9lqNbWch9tEake+YVCtWF9wHV3nuuxdRzsbf9phslPv/E4wzCgC17fVXqvpH73oTtgVitXvKXMRS4jqVSR/RZT3c6lby06OcQ5fCyyhs3xWAyAwZP0eOiuTwxbOAcEBKXmOlbNek7QHiqTpc08QKBgBFpoDXkPA8wacTOBjKpF3nPrh6inlW91ONsc6xCGyEOn5b12xOUhpNZtqMjtx8CmGUtak482VE9EY2yKZ+VVh3xPCdl3Mbut+yUUeut76plqW7oYmOZBpVMCPgZWhAH4kglkmQH/oBYPa4SpQCC3LsyOTSKr19RlUndFzqy+zPxAoGAP0oY1WNrS5ijYkNI69S4/s6c+GeYdoiuJ1sFC4AEbr5XD1uQBo+giyXm5D8TtQZS99VhoLatfi53+taN5ZeAjEy+Us5hUKFPnIOe1VBlx1KDSnb+9AMsRXKM48WhpJZIf6u/FcZJsTDGDq2FhGxaOIxGBXWobd2y+QuD9GqzhuM=";

    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";


    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjaEYE/5IxfVgB8PRFVT4lovdUbJ0pns2du5X2qmebx+0v3J/NtyDA3jeghDZJkdi1ra71RnyvtGmbAN9zYSGBnBU12RNxx6n3ZUmS2VeK9fUwcJSoyQOuDbX5ECIOPj2prLRAsxidHWeJRlYY7rJqZGV1eQEyXcOAWGUj3Ruh0HXZdMjAwwgnq6b3gGTjVdpnOr1g13g+1RB+rzyihES1clrxKU59MmKtIzNuCrOekHiNWpXQxO5g6lkYUKBrIWM2fyJt1x7rvayxnmF7m6m69igvzNc2tqgP3ZOT94/MfwGZZd0yyDIr8CvMvPlKjhooiQG1SM6SBF5au2Vjrz2zwIDAQAB";


    // RSA2
    public static String SIGNTYPE = "RSA2";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "JSON";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://127.0.0.1:8215/alipay/returnUrl";

    // 日志记录目录
    public static String log_path = "D:\\";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://upaad.free.idcfengye.com/alipay/notifyUrl";

}