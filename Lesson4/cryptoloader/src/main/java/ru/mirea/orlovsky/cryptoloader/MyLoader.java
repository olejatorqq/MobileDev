package ru.mirea.orlovsky.cryptoloader;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class MyLoader extends AsyncTaskLoader<String> {
    private String encryptedText;
    private SecretKey secretKey;
    public static final String ARG_TEXT = "text";
    public static final String ARG_KEY = "key";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null) {
            encryptedText = args.getString(ARG_TEXT);
            byte[] keyBytes = args.getByteArray(ARG_KEY);
            secretKey = new SecretKeySpec(keyBytes, "AES");
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        SystemClock.sleep(5000); // Emulate long-running operation
        return decrypt(encryptedText, secretKey);
    }

    private String decrypt(String encryptedText, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.decode(encryptedText, Base64.DEFAULT));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
