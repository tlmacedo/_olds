import javax.security.auth.callback.PasswordCallback;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-06-06
 * Time: 10:58
 */

public class TesteCertificado {
    //KeychainStore

    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, IOException, KeyStoreException, NoSuchProviderException, UnrecoverableEntryException {
        System.setProperty("senhaDoCertificado", "4879");
        Provider p = Security.getProvider("SunPKCS11");
        char[] pin = System.getProperty("senhaDoCertificado").toCharArray();

        String configName = "/Volumes/150GB-Development/CafePerfeito/cafeperfeito_v2.02/src/main/resources/certificados/tokenSafeNet5100.cfg";
        try {
            p = p.configure(configName);
            Security.addProvider(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        KeyStore.CallbackHandlerProtection chp =
                new KeyStore.CallbackHandlerProtection(callbacks -> {
                    for (int i = 0; i < callbacks.length; i++) {
                        PasswordCallback pc = (PasswordCallback) callbacks[i];
                        pc.setPassword(pin);
                    }
                });

        KeyStore ks = KeyStore.Builder.newInstance("PKCS11", p, chp).getKeyStore();
//        KeyStore ks = KeyStore.getInstance("KeychainStore",
//                "Apple");
//        ks.load(null, null);

//        KeyStore ks = KeyStore.getInstance("KeychainStore");

//        ks.load(null, pin);
        PrivateKey privateKey = null;
        KeyStore.PrivateKeyEntry pkEntry = null;
        Enumeration<String> aliasesEnum = ks.aliases();
        while (aliasesEnum.hasMoreElements()) {
            String alias = (String) aliasesEnum.nextElement();
            X509Certificate c = (X509Certificate) ks.getCertificate(alias);
            if (ks.isKeyEntry(alias)) {
                System.out.printf("\n\n\nalias: " + alias);
                System.out.printf("\ncert:" + c.getSubjectX500Principal().toString());
                System.out.printf("\n data: [%s]\n", c.getNotAfter());
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias,
                        new KeyStore.PasswordProtection(pin));
                privateKey = pkEntry.getPrivateKey();
                break;
            }
        }

//        while (en.hasMoreElements()) {
//            String aliasKey = en.nextElement();
//            X509Certificate c = (X509Certificate) ks.getCertificate(aliasKey);
//            System.out.printf("\nalias: " + aliasKey);
//            System.out.printf("\ncert:" + c.getSubjectX500Principal().toString());
//            System.out.printf("\n data: [%s]\n", c.getNotAfter());
//        }

    }
}
