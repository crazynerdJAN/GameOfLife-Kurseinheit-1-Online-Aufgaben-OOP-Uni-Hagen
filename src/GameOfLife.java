public class GameOfLife {
    boolean[][] feld = {
        { false, false, false, false, false },
        { false, false, true, false, false },
        { false, false, true, false, false },
        { false, false, true, false, false },
        { false, false, false, false, false } };

    boolean[][] nextGen = new boolean [5][5];
  
    void print() {
      for (int i = 0; i < feld.length; i++) {
        for (int j = 0; j < feld[i].length; j++) {
          if (feld[i][j]) {
            System.out.print("o ");
          } else {
            System.out.print(". ");
          }
        }
        System.out.println();
      }
    }
  
    void nextGeneration() {
        int anzahlnachbarn =0;

        for(int n=0; n < this.feld[0].length; n++){
            for(int m=0; m < this.feld[1].length; m++){

                      if(n == 0 || m ==0 || n == 4 || m == 4){
                            nextGen[m][n] = false;

                        }else{

                        anzahlnachbarn=prüfenachbarn(n,m);  

                            if(anzahlnachbarn == 3 && this.feld[n][m] == false){
                            this.nextGen[n][m] = true;
                                }
                            else if((anzahlnachbarn ==2 || anzahlnachbarn ==3) && this.feld[n][m] == true){
                            this.nextGen[n][m] = true;
                                }
                            else{
                            this.nextGen[n][m] = false;
                                }

                            }        
                
            }
        }
    for(int n = 0; n<this.feld[0].length; n++){
        for(int m=0; m < this.feld[1].length; m++){
            this.feld[n][m] = this.nextGen[n][m]; 
        }
    }

    }

    int prüfenachbarn(int n, int m){
        int zähler =0;
 
                if(this.feld[n][m-1]){
                    zähler++;   
                }
                if(this.feld[n-1][m-1]){
                    zähler++;  
                }
                if(this.feld[n-1][m]){
                    zähler++; 
                }
                if(this.feld[n-1][m+1]){
                    zähler++; 
                }
                if(this.feld[n][m+1]){
                    zähler++; 
                }
                if(this.feld[n+1][m+1]){
                    zähler++; 
                }
                if(this.feld[n+1][m]){
                    zähler++; 
                }
                if(this.feld[n+1][m-1]){
                    zähler++; 
                }


                return zähler;

    }
  
    public static void main(String[] args) {
      GameOfLife myGame = new GameOfLife();
      for (int i = 0; i < 10; i++) {
        myGame.nextGeneration();
        myGame.print();
        System.out.println();
      }
    } 
}
