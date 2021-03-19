package conjuntoBonsOuRuinsV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConjuntoBonsOuRuinsV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String palavra;
        String minString;
        String maxString ;
        String armString;
        List<String > listaPalavras = new ArrayList<>();
        boolean booleano = false;

        while(!(palavra = st.nextToken()).equals("0")) {
            int num = Integer.parseInt(palavra);
            while(num > 0) {
                st = new StringTokenizer(br.readLine());
                listaPalavras.add(st.nextToken());
                --num;
            }

            for(int i = 0; i < listaPalavras.size() - 1; i++) {
                for (int g = 1; g < listaPalavras.size(); g++) {
                    minString = listaPalavras.get(i);
                    maxString = listaPalavras.get(g);

                    if(minString.equals(maxString) && i == g) {
                        continue;
                    }

                    if(minString.length() > maxString.length()) {
                        armString = maxString;
                        maxString = minString;
                        minString = armString;
                    }

                    if(maxString.startsWith(minString)) {
                        booleano = true;
                        break;
                    }
                }

                if(booleano) {
                    break;
                }
            }

            if(booleano) {
                System.out.println("Conjunto Ruim");
            } else {
                System.out.println("Conjunto Bom");
            }

            booleano = false;
            listaPalavras.clear();
            st = new StringTokenizer(br.readLine());
        }

    }
}
