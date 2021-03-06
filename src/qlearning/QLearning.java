package qlearning;

import java.util.concurrent.ThreadLocalRandom;

public class QLearning {
    public int[] R;       // Recompensas
    public double[][] Q;    // Tabela Q
    private int[][] M;    // Tabela Q
    private int objetivo = 49;
    public int inicial= 0;
    public int atual;
    public double y = 0.95;

    public void init() {
        this.atual = this.inicial;
        this.R = new int[50];
        this.Q = new double[50][4];
        this.M = new int[50][4];

        //Implementa tabela Q
        //0 - norte
        //1 - sul
        //2 - leste
        //3 - oeste
        Q[0][0] = 0;Q[0][2] = 0;
        Q[1][0] = 0;Q[1][1] = 0;Q[1][2] = 0;
        Q[2][0] = 0;Q[2][1] = 0;Q[2][2] = 0;
        Q[3][0] = 0;Q[3][1] = 0;Q[3][2] = 0;
        Q[4][1] = 0;Q[4][2] = 0;
        Q[5][1] = 0;Q[5][2] = 0;Q[5][3] = 0;
        Q[6][0] = 0;Q[6][1] = 0;Q[6][2] = 0;Q[6][3] = 0;
        Q[7][0] = 0;Q[7][1] = 0;Q[7][2] = 0;Q[7][3] = 0;
        Q[8][0] = 0;Q[8][1] = 0;Q[8][2] = 0;Q[8][3] = 0;
        Q[9][0] = 0;Q[9][2] = 0;Q[9][3] = 0;
        Q[10][0] = 0;Q[10][2] = 0;Q[10][3] = 0;
        Q[11][0] = 0;Q[11][1] = 0;Q[11][2] = 0;Q[11][3] = 0;
        Q[12][0] = 0;Q[12][1] = 0;Q[12][2] = 0;Q[12][3] = 0;
        Q[13][0] = 0;Q[13][1] = 0;Q[13][2] = 0;Q[13][3] = 0;
        Q[14][1] = 0;Q[14][2] = 0;Q[14][3] = 0;
        Q[15][1] = 0;Q[15][2] = 0;Q[15][3] = 0;
        Q[16][0] = 0;Q[16][1] = 0;Q[16][2] = 0;Q[16][3] = 0;
        Q[17][0] = 0;Q[17][1] = 0;Q[17][2] = 0;Q[17][3] = 0;
        Q[18][0] = 0;Q[18][1] = 0;Q[18][2] = 0;Q[18][3] = 0;
        Q[19][0] = 0;Q[19][2] = 0;Q[19][3] = 0;
        Q[20][0] = 0;Q[20][2] = 0;Q[20][3] = 0;
        Q[21][0] = 0;Q[21][1] = 0;Q[21][2] = 0;Q[21][3] = 0;
        Q[22][0] = 0;Q[22][1] = 0;Q[22][2] = 0;Q[22][3] = 0;
        Q[23][0] = 0;Q[23][1] = 0;Q[23][2] = 0;Q[23][3] = 0;
        Q[24][1] = 0;Q[24][2] = 0;Q[24][3] = 0;
        Q[25][1] = 0;Q[25][2] = 0;Q[25][3] = 0;
        Q[26][0] = 0;Q[26][1] = 0;Q[26][2] = 0;Q[26][3] = 0;
        Q[27][0] = 0;Q[27][1] = 0;Q[27][2] = 0;Q[27][3] = 0;
        Q[28][0] = 0;Q[28][1] = 0;Q[28][2] = 0;Q[28][3] = 0;
        Q[29][0] = 0;Q[29][2] = 0;Q[29][3] = 0;
        Q[30][0] = 0;Q[30][2] = 0;Q[30][3] = 0;
        Q[31][0] = 0;Q[31][1] = 0;Q[31][2] = 0;Q[31][3] = 0;
        Q[32][0] = 0;Q[32][1] = 0;Q[32][2] = 0;Q[32][3] = 0;
        Q[33][0] = 0;Q[33][1] = 0;Q[33][2] = 0;Q[33][3] = 0;
        Q[34][1] = 0;Q[34][2] = 0;Q[34][3] = 0;
        Q[35][1] = 0;Q[35][2] = 0;Q[35][3] = 0;
        Q[36][0] = 0;Q[36][1] = 0;Q[36][2] = 0;Q[36][3] = 0;
        Q[37][0] = 0;Q[37][1] = 0;Q[37][2] = 0;Q[37][3] = 0;
        Q[38][0] = 0;Q[38][1] = 0;Q[38][2] = 0;Q[38][3] = 0;
        Q[39][0] = 0;Q[39][2] = 0;Q[39][3] = 0;
        Q[40][0] = 0;Q[40][2] = 0;Q[40][3] = 0;
        Q[41][0] = 0;Q[41][1] = 0;Q[41][2] = 0;Q[41][3] = 0;
        Q[42][0] = 0;Q[42][1] = 0;Q[42][2] = 0;Q[42][3] = 0;
        Q[43][0] = 0;Q[43][1] = 0;Q[43][2] = 0;Q[43][3] = 0;
        Q[44][1] = 0;Q[44][2] = 0;Q[44][3] = 0;
        Q[45][1] = 0;Q[45][3] = 0;
        Q[46][0] = 0;Q[46][1] = 0;Q[46][3] = 0;
        Q[47][0] = 0;Q[47][1] = 0;Q[47][3] = 0;
        Q[48][0] = 0;Q[48][1] = 0;Q[48][3] = 0;
        Q[49][0] = 0;Q[49][3] = 0;

        //Implementa tabela M
        //0 - norte
        //1 - sul
        //2 - leste
        //3 - oeste
        M[0][0] = 1;    M[0][1] = -1;   M[0][2] = 9;M[0][3] = -1;
        M[1][0] = 2;    M[1][1] = 0;    M[1][2] = 8;M[1][3] = -1;
        M[2][0] = 3;    M[2][1] = 1;    M[2][2] = 7;M[2][3] = -1;
        M[3][0] = 4;    M[3][1] = 6;    M[3][2] = 2;M[3][3] = -1;
        M[4][0] = -1;   M[4][1] = 3;    M[4][2] = 5;M[4][3] = -1;
        M[5][0] = -1;   M[5][1] = 6;    M[5][2] = 14;M[5][3] = 4;
        M[6][0] = 5;    M[6][1] = 7;    M[6][2] = 13;M[6][3] = 3;
        M[7][0] = 6;    M[7][1] = 8;    M[7][2] = 12;M[7][3] = 2;
        M[8][0] = 7;    M[8][1] = 9;    M[8][2] = 11;M[8][3] = 1;
        M[9][0] = 8;    M[9][1] = -1;   M[9][2] = 10;M[9][3] = 0;
        M[10][0] = 11;  M[10][1] = -1;  M[10][2] = 19;M[10][3] = 9;
        M[11][0] = 12;  M[11][1] = 10;  M[11][2] = 18;M[11][3] = 8;
        M[12][0] = 13;  M[12][1] = 11;  M[12][2] = 17;M[12][3] = 7;
        M[13][0] = 14;  M[13][1] = 12;  M[13][2] = 16;M[13][3] = 6;
        M[14][0] = 13;  M[14][1] = 13;  M[14][2] = 15;M[14][3] = 5;
        M[15][0] = -1;  M[15][1] = 16;  M[15][2] = 24;M[15][3] = 14;
        M[16][0] = 15;  M[16][1] = 17;  M[16][2] = 23;M[16][3] = 13;
        M[17][0] = 16;  M[17][1] = 18;  M[17][2] = 22;M[17][3] = 12;
        M[18][0] = 17;  M[18][1] = 19;  M[18][2] = 21;M[18][3] = 11;
        M[19][0] = 18;  M[19][1] = -1;  M[19][2] = 20;M[19][3] = 10;
        M[20][0] = 21;  M[20][1] = -1;  M[20][2] = 29;M[20][3] = 19;
        M[21][0] = 22;  M[21][1] = 20;  M[21][2] = 28;M[21][3] = 18;
        M[22][0] = 23;  M[22][1] = 21;  M[22][2] = 27;M[22][3] = 17;
        M[23][0] = 24;  M[23][1] = 22;  M[23][2] = 26;M[23][3] = 16;
        M[24][0] = 24;  M[24][1] = 23;  M[24][2] = 25;M[24][3] = 15;
        M[25][0] = 24;  M[25][1] = 26;  M[25][2] = 34;M[25][3] = 24;
        M[26][0] = 25;  M[26][1] = 27;  M[26][2] = 33;M[26][3] = 23;
        M[27][0] = 26;  M[27][1] = 28;  M[27][2] = 32;M[27][3] = 22;
        M[28][0] = 27;  M[28][1] = 29;  M[28][2] = 31;M[28][3] = 21;
        M[29][0] = 28;  M[29][1] = 28;  M[29][2] = 30;M[29][3] = 20;
        M[30][0] = 31;  M[30][1] = 39;  M[30][2] = 39;M[30][3] = 29;
        M[31][0] = 32;  M[31][1] = 30;  M[31][2] = 38;M[31][3] = 28;
        M[32][0] = 33;  M[32][1] = 31;  M[32][2] = 37;M[32][3] = 27;
        M[33][0] = 34;  M[33][1] = 32;  M[33][2] = 36;M[33][3] = 26;
        M[34][0] = -1;  M[34][1] = 33;  M[34][2] = 35;M[34][3] = 25;
        M[35][0] = -1;  M[35][1] = 36;  M[35][2] = 44;M[35][3] = 34;
        M[36][0] = 35;  M[36][1] = 37;  M[36][2] = 43;M[36][3] = 33;
        M[37][0] = 36;  M[37][1] = 38;  M[37][2] = 42;M[37][3] = 32;
        M[38][0] = 37;  M[38][1] = 39;  M[38][2] = 41;M[38][3] = 31;
        M[39][0] = 38;  M[39][1] = 38;  M[39][2] = 40;M[39][3] = 30;
        M[40][0] = 41;  M[40][1] = -1;  M[40][2] = 49;M[40][3] = 39;
        M[41][0] = 42;  M[41][1] = 40;  M[41][2] = 48;M[41][3] = 38;
        M[42][0] = 43;  M[42][1] = 41;  M[42][2] = 47;M[42][3] = 37;
        M[43][0] = 44;  M[43][1] = 42;  M[43][2] = 46;M[43][3] = 36;
        M[44][0] = -1;  M[44][1] = 43;  M[44][2] = 45;M[44][3] = 35;
        M[45][0] = -1;  M[45][1] = 46;  M[45][2] = -1;M[45][3] = 44;
        M[46][0] = 45;  M[46][1] = 47;  M[46][2] = -1;M[46][3] = 43;
        M[47][0] = 46;  M[47][1] = 48;  M[47][2] = -1;  M[47][3] = 42;
        M[48][0] = 47;  M[48][1] = 49;  M[48][2] = -1;  M[48][3] = 41;
        M[49][0] = 48;  M[49][1] = -1;  M[49][2] = -1;  M[49][3] = 40;

        R[0] = -1;
        R[1] = -1;
        R[2] = -1;
        R[3] = -1;
        R[4] = -1;
        R[5] = -1;
        R[6] = -100;
        R[7] = -1;
        R[8] = -1;
        R[9] = -100;
        R[10] = -100;
        R[11] = -1;
        R[12] = -1;
        R[13] = -100;
        R[14] = -1;
        R[15] = -1;
        R[16] = -100;
        R[17] = -1;
        R[18] = -100;
        R[19] = -100;
        R[20] = -100;
        R[21] = -1;
        R[22] = -1;
        R[23] = -100;
        R[24] = -100;
        R[25] = -100;
        R[26] = -100;
        R[27] = -1;
        R[28] = -1;
        R[29] = -100;
        R[30] = -100;
        R[31] = -1;
        R[32] = -1;
        R[33] = -1;
        R[34] = -1;
        R[35] = -1;
        R[36] = -100;
        R[37] = -1;
        R[38] = -100;
        R[39] = -100;
        R[40] = -100;
        R[41] = -1;
        R[42] = -1;
        R[43] = -1;
        R[44] = -1;
        R[45] = -1;
        R[46] = -1;
        R[47] = -1;
        R[48] = -1;
        R[49] = 100;


    }
    public int getAleatorio(int pos){
        int[] MPos;
        MPos = M[pos];
        int rand = ThreadLocalRandom.current().nextInt(0, 4);
        while(MPos[rand] < 0){
            rand = ThreadLocalRandom.current().nextInt(0, 4);
        }
        return rand;
    }

    public int getdirecao(int pos){
        double recompensa = -1000.0;
        int dir =0;
        for(int i=0;i<4;i++) {
            if (M[pos][i] > 0 && recompensa < Q[pos][i]) {
                recompensa = Q[pos][i];
                dir = i;
            }
        }
        //20% dos casos aleatório, outros 80% busca o melhor caso
        int rand = ThreadLocalRandom.current().nextInt(0, 10);
        if (rand > 7) {
            return getAleatorio(pos);
        } else {
            return dir;
        }
    }

    public void doAcao(int pos,int dir){
        int alvo = M[pos][dir];
        Q[pos][dir] = R[alvo] + y*getMaxQ(alvo);
        this.atual = alvo;
    }

    public boolean eterminal(){
        if(this.atual == this.objetivo){
           return true;
        }
        return false;
    }

    public double getMaxQ(int pos) {
        double[] QPos = Q[pos];
        double recompensa = -1000.0;
        for (int i = 0; i < 4; i++) {
            if (M[pos][i] >= 0 && recompensa < Q[pos][i]) {
                recompensa = Q[pos][i];
            }
        }
        return recompensa;
    }
    public void escreveQ(){
        System.out.println("Posicao         N       S       L       O");
for(int i=0;i<50;i++){
            String aux = i+"        ";
            for(int j=0;j<4;j++){
            aux += Q[i][j]+"    ";
            }
            System.out.println(aux);
        }
    }

}