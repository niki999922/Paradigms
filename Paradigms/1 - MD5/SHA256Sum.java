import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
public class CalcMD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8))) {
            String line;
            byte[] bytes;
            while ((line = reader.readLine()) != null) {
                FileInputStream fin = new FileInputStream(line);
                fin.read(bytes = new byte[fin.available()]);
                md.update(bytes);
                System.out.println(convertHex(md.digest()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found, try again with file");
        } catch (IOException e) {
            System.err.println("You have input or output exception, be carefully");
        }
    }
bv  v
    private static String convertHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String s = Integer.toHexString(0xff & bytes[i]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }
        return sb.toString();
    }
}
*/


// Тест SHA256SumTest
// Имя класса и файла должно быть SHA256Sum
// Для модификации 36-37 sha-256, где файлы через чтение и при пустом *-.

public class SHA256Sum {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        if (args.length == 0) {
            try {
                DigestInputStream input = new DigestInputStream(System.in, md);
                byte[] bytes = new byte[0xFFF];
                while (input.read(bytes) != -1) ;
                System.out.println(DatatypeConverter.printHexBinary(md.digest()) + " *-");
            } catch (IOException e) {
                System.err.println("You have input or output exception, be carefully " + e);
            }
        } else {
            for (String arg : args) {
                try (FileInputStream input = new FileInputStream(arg)) {
                    byte[] bytes;
                    input.read(bytes = new byte[input.available()]);
                    md.update(bytes);
                    System.out.println(DatatypeConverter.printHexBinary(md.digest()) + " *" + arg);
                } catch (FileNotFoundException e) {
                    System.err.println("File not found, try again with file " + e);
                } catch (IOException e) {
                    System.err.println("You have input or output exception, be carefully " + e);
                }
            }
        }
    }
}


/*

//Тест CalcSha256Test
//Имя класса и файла должно быть CalcSHA256
//Для модификации 38-39 sha-256, где файлы через чтение.

public class CalcSHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8))) {
            String line;
            byte[] bytes;
            while ((line = reader.readLine()) != null) {
                FileInputStream fin = new FileInputStream(line);
                fin.read(bytes = new byte[fin.available()]);
                md.update(bytes);
                System.out.println(convertHex(md.digest()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found, try again with file");
        } catch (IOException e) {
            System.err.println("You have input or output exception, be carefully");
        }
    }

    private static String convertHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String s = Integer.toHexString(0xff & bytes[i]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }
        return sb.toString();
    }
}

*/

