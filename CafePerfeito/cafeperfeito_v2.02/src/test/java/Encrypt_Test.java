import br.com.tlmacedo.cafeperfeito.model.dao.UsuarioDAO;
import br.com.tlmacedo.cafeperfeito.model.vo.Usuario;
import br.com.tlmacedo.cafeperfeito.service.ServiceCryptografia;
import org.bouncycastle.crypto.generators.BCrypt;

import java.util.Scanner;

public class Encrypt_Test {

    public static void main(String[] args) throws Exception {

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please Enter Plain Text Password:");
//        String senha = scan.next();
//
//        String encrypt = ServiceCryptografia.encrypt(senha);
//        System.out.printf("\nSenhaEncrypt: %s\n", encrypt);


        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter Plain Text Password:");
        String senha = scan.next();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.getById(Usuario.class, 1L);
        System.out.printf("SenhaOld: %s\n", usuario.senhaProperty().getValue());

        System.out.printf("\nSenhaVálida[1]: %s\n", ServiceCryptografia.checkPassword(senha, usuario.getSenha()));

    }
}
