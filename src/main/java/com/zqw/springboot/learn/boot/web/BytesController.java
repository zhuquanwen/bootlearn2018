package com.zqw.springboot.learn.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BytesController {
    @GetMapping("/bytes")
    public float[][] getBytes(){
//        byte[] buff = new byte[2048*2048*4];
        float[][] data = new float[2048][2048];
        Random random = new Random();
//        int k = 0;
        for (int i = 0; i < 2048 ; i++) {
            for (int j = 0; j < 2048 ; j++) {
                data[i][j] = random.nextFloat();
//                byte[] bytes = MathUtils.float2byte(random.nextFloat());
//                for (int l = 0; l < 4 ; l++) {
//                    buff[k] = bytes[l];
//                    k++;
//                }
            }
        }

        return data;
    }
}
