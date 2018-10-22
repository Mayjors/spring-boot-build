package com.example.manager.controller;

import com.example.util.utils.CreateQrcode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 生成二维码
 * @author yuanjie
 * @date 2018/9/18 18:19
 */
@RestController
@RequestMapping("/api")
public class QRCodeController {

    @RequestMapping("/qrcode")
    public void getEquipmentQrcode(String url, HttpServletResponse response) {
        CreateQrcode createQrcode = new CreateQrcode();
        try {
            // 生成二维码
            createQrcode.getQrcode(url, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
