package book_materials.streams;

import java.io.*;

public class Streams {

    public static void main(String[] args) throws FileNotFoundException {

        try (OutputStream out = new FileOutputStream("src/main/resources/file.txt")) {
            // work with the output stream...
//            generateCharacters(out);
        } catch (IOException ex) {
          System.err.println(ex.getMessage());
        }

        int bytesRead =0;
        int bytesToRead = 1024;
        byte[] input = new byte[bytesToRead];
//        while (bytesRead < bytesToRead) {
//            bytesRead += in.read(input, bytesRead, bytesToRead - bytesRead);
//        }

        FileInputStream fin = new FileInputStream("src/main/resources/file.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);

        InputStream in = new FileInputStream("src/main/resources/file.txt");
        in = new BufferedInputStream(in);

        DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("src/main/resources/file.txt")));

    }

    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2]; // the +2 is for the carriage return and linefeed
        while (true) { /* infinite loop */
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter)
                        % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte) '\r'; // carriage return
            line[73] = (byte) '\n'; // line feed
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }
}
