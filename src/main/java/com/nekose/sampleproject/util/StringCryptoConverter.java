package com.nekose.sampleproject.util;

import com.nekose.sampleproject.config.property.SampleProperties;
import com.nekose.sampleproject.exception.CryptoException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Component
//@Configurable
@RequiredArgsConstructor
public class StringCryptoConverter {
    private static final String ALGORITHM = "AES/GCM/NoPadding";

    private final SampleProperties properties;

    public String generateHashedString(String str) {
        return DigestUtils.sha512Hex(properties.getCrypto().getHashSalt() + str);
    }

    public String getBase64BasicAuth(String clientId, String secret) {
        return "Basic " + Base64.getEncoder().encodeToString(
                String.format("%s:%s", clientId, secret).getBytes(StandardCharsets.UTF_8));
    }

    public String encrypt(String srcData) {
        if (StringUtils.isBlank(srcData)) {
            return null;
        }

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getKey());

            byte[] base64Crypto = Base64.getEncoder().encode(cipher.doFinal(srcData.getBytes()));
            return new String(base64Crypto);
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    public String decrypt(String data) {
        if (StringUtils.isBlank(data)) {
            return null;
        }

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getKey());

            byte[] bytes = Base64.getDecoder().decode(cipher.doFinal(data.getBytes()));
            return new String(bytes);
        } catch (Exception e) {
            throw new CryptoException(e);
        }
    }

    private Key getKey() {
        return new SecretKeySpec(properties.getCrypto().getKey().getBytes(), "AES");
    }
}
