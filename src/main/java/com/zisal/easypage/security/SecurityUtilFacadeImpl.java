package com.zisal.easypage.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by Ladies Man on 1/13/2016.
 */
@Stateless
public class SecurityUtilFacadeImpl implements ISecurityUtilFacade {

    private static final Random rand = new Random((new Date()).getTime());

    @Override
    public String encript(String data) {
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);
        return encoder.encode(salt) + encoder.encode(data.getBytes());
    }

    @Override
    public String decript(String data) {
        if (data.length() > 12) {
            String cipher = data.substring(12);
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                return new String(decoder.decodeBuffer(cipher));
            } catch (IOException e) {
                //  throw new InvalidImplementationException(
                //Fail
            }
        }
        return null;
    }
}
