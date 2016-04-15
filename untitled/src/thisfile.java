import java.io.*;

/**
 * Created by Student on 01.04.2016.
 */
public class thisfile {
    private final static String[] nol = {"one thousandth","two thousandth","three thousandth","four thousandth","five thousandth","six thousandth","seven thousandth","eight thousandth","nine thousandth"};
    private final static String[] one = {"one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred"};
    private final static String[] two = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private final static String[] three = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final static String[] four = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private final static String[] five = {"hundred", "thousandth", "million", "", "", "", "", "", ""};

    static String[] str1;

    public static String repeareText(String path) {
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String s;
            while ((s = in.readLine()) != null) {
                str.append(s + " \n");
                str1 = s.split(" ");
                int k = 0;
                int flag = 0;
                for (int i = 0; i < str1.length; i++) {
                    for (int j = 0; j < two.length; j++) {
                        if (nol[j].compareToIgnoreCase(str1[i]) == 0)
                        {
                            flag = i;
                            k += (j+1)*1000;
                            str1[i] = "";
                        }
                        if (one[j].compareToIgnoreCase(str1[i]) == 0)
                        {
                            flag = i;
                            k += (j+1)*100;
                            str1[i] = "";
                        }
                        if (two[j].compareToIgnoreCase(str1[i]) == 0)
                        {
                            flag = i;
                            k += (j+1)*10;
                            str1[i] = "";
                        }
                        if (three[j].compareToIgnoreCase(str1[i]) == 0)
                        {
                            flag = i;
                            k += (j+1)+10;
                            str1[i] = "";
                        }
                        if (four[j].compareToIgnoreCase(str1[i]) == 0)
                        {
                            flag = i;
                            k += (j+1);
                            str1[i] = "";
                        }
                        if (five[j].compareToIgnoreCase(str1[i]) == 0)
                        {
                            flag = i;
                            switch (j){
                                case 0:k+=100;
                                    break;
                                case 1:k+=1000;
                                    break;
                                case 2: k+=1000000;
                                    break;
                            }
                            str1[i] = "";
                        }
                    }
                }
                str1[flag] = Integer.toString(k)+" ";
                File file = new File("E:\\d.txt");
                try {
                    PrintWriter out = new PrintWriter(file.getAbsoluteFile());
                    try {
                        for (int i = 0; i < str1.length; i++) {
                            out.print(str1[i]);
                        }
                    } finally {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}

