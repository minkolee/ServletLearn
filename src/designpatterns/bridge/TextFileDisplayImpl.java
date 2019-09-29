package designpatterns.bridge;

import java.io.*;

public class TextFileDisplayImpl extends DisplayImpl {

    private String filename;

    public TextFileDisplayImpl(String filename) {
        this.filename = filename;
    }

    private StringBuilder content = new StringBuilder();

    @Override
    public void rawOpen() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filename);
            bufferedReader = new BufferedReader(new FileReader(file));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                content.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    @Override
    public void rawPrint() {
        System.out.print(content.toString());
    }

    @Override
    public void rawClose() {
        System.out.println("End of file");
    }
}
