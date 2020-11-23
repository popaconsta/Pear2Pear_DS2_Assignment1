package security;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyManager {

    private KeyPairGenerator keyGen;
    private int keyNumber;
    public static PrivateKey[] PRIVATE_KEYS;
    public static PublicKey[] PUBLIC_KEYS;

    public KeyManager(int keylength, int keyNumber) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keylength);
        this.keyNumber = keyNumber;
        PRIVATE_KEYS = new PrivateKey[keyNumber];
        PUBLIC_KEYS = new PublicKey[keyNumber];
    }

    public void createKeys() {
    	for(int i=0; i<keyNumber; i++) {
    		KeyPair pair = keyGen.generateKeyPair();
            this.PRIVATE_KEYS[i] = pair.getPrivate();
            this.PUBLIC_KEYS[i] = pair.getPublic();
    	}
    }
}