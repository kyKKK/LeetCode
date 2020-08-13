import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class D1 {

    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            String src = "73.25%";
            HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();

            for (int i = 0; i < 100000000; i++) {
                byte[] bytes = md.digest(src.getBytes("UTF-8"));
                src = hexBinaryAdapter.marshal(bytes);
                if (i == 100000000 - 1)
                    System.out.println(src);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}





