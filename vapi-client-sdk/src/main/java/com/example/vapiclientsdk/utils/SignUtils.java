package com.example.vapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtils {

    public static String getSign(String body, String secretKey) {
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        String result = digester.digestHex(content);
        return result;
    }
}
