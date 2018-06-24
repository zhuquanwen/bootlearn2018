package com.zqw.springboot.learn.boot.config;

import com.zqw.springboot.learn.boot.utils.MathUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class BytesHttpMessageConvert extends
        AbstractHttpMessageConverter {
    public BytesHttpMessageConvert(){
        super(MediaType.valueOf(Constants.BYTES));
        setDefaultCharset(Charset.forName("utf-8"));
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream os = outputMessage.getBody();
        float[][] data = (float[][])o;
        int k = 0;
        byte[] buff = new byte[data.length * data[0].length * 4];
        for (int i = 0; i < data.length ; i++) {
            for (int j = 0; j < data[i].length ; j++) {

                byte[] bytes = MathUtils.float2byte(data[i][j]);
                for (int l = 0; l < 4 ; l++) {
                    buff[k] = bytes[l];
                    k++;
                }
            }
        }
        os.write(buff);
    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }

}
