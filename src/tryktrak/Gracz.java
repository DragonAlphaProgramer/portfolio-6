/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryktrak;

/**
 *
 * @author Patryk
 */
public class Gracz {

    public int[] getPozycje() {
        return pozycje;
    }

    public int getWyprowadzki() {
        return wyprowadzki;
    }
    private final boolean kolor;
    private int[] pozycje = new int[24];
    private int banda = 0;
    private boolean wygrana=false;
    private int wyprowadzki = 0;
    private boolean czy_zbite = false;

    public boolean isPozwolenie_na_wyprowadzke() {
        return pozwolenie_na_wyprowadzke;
    }
    public  int punkty=0,wymagane=0;
    private  boolean pozwolenie_na_wyprowadzke = false;
    public Gracz(boolean kolor){
        this.kolor = kolor;
       start_ust();
    }

    public int getBanda() {
        return banda;
    }
     void ruszaj_sie(int pole, int ruch){
        pozycje[pole]=pozycje[pole]-1;
        if(pole+ruch<24){
        pozycje[pole+ruch]=pozycje[pole+ruch]+1;
        }else{
            if(pozwolenie_na_wyprowadzke==true){
            wyprowadzki=wyprowadzki+1;
            }
        }
        int i = 0;
        for(int p=18;p<24;p++){
            i = i+pozycje[p];
        }
        if(pozwolenie_na_wyprowadzke==false&&i == 15){
            pozwolenie_na_wyprowadzke=true;
        }
    }
     void bicie(int pole){
         pozycje[pole]=0;
         banda=banda+1;
         czy_zbite=true;
     }

    public int getPunkty() {
        return punkty;
    }
     void wprowadz_do_gry(int pole){
         pozycje[pole]=pozycje[pole]+1;
         banda = banda-1;
         czy_zbite = banda>0;
     }
     void dolicz_punkty(boolean wyprowadzka_rywala,boolean zbity_rywal){
         punkty = punkty + (wyprowadzka_rywala==true ? 1 : zbity_rywal==false ? 2 : 3);
         wygrana = punkty>=wymagane;
         if(wygrana==false){
             start_ust();
         }
     }

    public void start_ust() {
         for(int i =0;i<24;i++){
           /* Random los = new Random();
            pozycje[i]= (i%2==1) ? los.nextInt(8) : 0;
            banda = los.nextInt(9);*/
            switch(i){
                case 0: pozycje[i] = 2; break;
                case 11: pozycje[i] = 5; break;
                case 16: pozycje[i] = 3; break;
                case 18: pozycje[i] = 5; break;
                default: pozycje[i]=0;
                break;
            }
        }}
    }
