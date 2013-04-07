package house.manager;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = null;
        BufferedWriter bw = null;
        Boolean done = false;
        String line;
        String temp;
        int ind = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        int mix = 0;
        while (!done) {
            try {
                bw = new BufferedWriter(new FileWriter("out.txt"));
            } catch (Exception e) {
                File f;
                f = new File("out.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter("out.txt"));
            }
            try {
                br = new BufferedReader(new FileReader("HouseDuties.txt"));
            } catch (Exception e) {
                bw.write("Input Error!");
                System.out.println("Input Error");
                bw.newLine();
                done = true;
            }
            int num = Integer.parseInt(br.readLine());
            String[] names = new String[num];
            String[] jobs = new String[num];
            try {
                line = br.readLine();
                while (line != null) {
                    st = new StringTokenizer(line, "|");
                    names[ind] = st.nextToken();
                    jobs[ind] = st.nextToken();
                    line = br.readLine();
                    ind++;
                }//while
                while(mix != 10000) {
                    tmp1 = (int) ((Math.random()*num));
                    tmp2 = (int) ((Math.random()*num));
                    temp = names[tmp1];
                    names[tmp1] = names[tmp2];
                    names[tmp2] = temp;
                    mix++;
                }//while
                for (int i = 0; i < (num); i++) {
                    bw.write(jobs[i]);
                    bw.write(":  ");
                    bw.write(names[i]);
                    bw.newLine();
                }//for
                bw.close();
                done = true;
            }//try
            catch (Exception e) {
                bw.write(e.toString());
                bw.close();
                done = true;
            }//catch
        }//while
    }//main
}//Main