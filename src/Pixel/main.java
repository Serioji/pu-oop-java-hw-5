package Pixel;


import java.util.ArrayList;

public class main {
    private static int phoneChecked;
    private static final Custom<String> deadCollection = new Custom<String>();
    private static final Custom<String> goodCollection = new Custom<String>();

    public static void main(String[] args){
            onExit(-1,"");
    }


    public static void onExit(int deadPixels,String title) {
        if(deadPixels>2048){
            deadCollection.add(title);
        } else if(deadPixels >= 0) {
            goodCollection.add(title);
        }
        if(phoneChecked<5){
            phoneChecked++;
           gameboard GameBoard = new gameboard();
        } else{
            System.out.println("Good Phones");
            System.out.println("");
            goodCollection.display();
            System.out.println();
            System.out.println("Bad Phones");
            System.out.println("");
            deadCollection.display();
        }
    }
}

