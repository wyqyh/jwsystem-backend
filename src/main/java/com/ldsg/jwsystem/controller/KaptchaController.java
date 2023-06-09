package com.ldsg.jwsystem.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@RestController
@RequestMapping("/kaptcha")
public class KaptchaController {

	@Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/create")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            if ((String) request.getSession().getAttribute("code_" + request.getSession().getId()) != null) {
                request.getSession().removeAttribute("code_" + request.getSession().getId());
            }
            // 将生成的验证码保存在session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("code_" + request.getSession().getId(), createText);
            BufferedImage bi = defaultKaptcha.createImage(createText);
            ImageIO.write(bi, "jpg", out);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        byte[] captchaChallengeAsJpeg = out.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
