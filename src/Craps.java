import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static int somme, but;
    public static Scanner sc = new Scanner(System.in);

    public static int saisirMise(int nbJetons){
        System.out.println("vous avez " + nbJetons+" jetons.");
        System.out.println("Combien voulez-vous miser?");
        int mise = sc.nextInt();
        if(mise==0) System.out.println("à bientot");
        while (mise>nbJetons){
            System.out.println("Vous essayez de rouler le casino. Recommencez.");
            System.out.println("vous avez " + nbJetons);
            System.out.println("Combien voulez-vous miser?");
            mise = sc.nextInt();
        }
        return nbJetons;
    }
    public static int lancerUnDe(){
          final Random GENERATEUR = new Random();
          return GENERATEUR.nextInt(8);
    }
    public static void afficherDes(int de1, int de2){
        somme=de1+de2;
        System.out.print("vous avez lancé "+de1+" et "+de2+". La somme est ");
    }
    public static void lancerLejeu(int de1, int de2){
        do {
            de1 = lancerUnDe();
            de2 = lancerUnDe();
            somme=de1+de2;
            afficherDes(de1, de2);
            System.out.print(somme+".\n");
        }while (but!=somme);
    }

    public static boolean joueEtGagnePremierTourDeCraps(){
        boolean estGagnant = false;
        if(but==7 || but==11) estGagnant=true;
        else if(but==2 || but==3 || but==12) estGagnant=false;
        else {
            System.out.println("votre but est "+somme);
        }
        return estGagnant;
    }
    public static boolean joueEtGagneUnTourDeCraps(){
        if(somme==7) System.out.println("Perd !");
       return  but==somme;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous avez 10 jetons. Combien voulez-vous miser?");
        int mise = sc.nextInt();
        int de1,de2, somme=0, nbJetons;
        if(mise!=0) {
            de1 = lancerUnDe();
            de2 = lancerUnDe();
            somme = de1 + de2;
            afficherDes(de1, de2);
            System.out.print(somme + ".\n");
            if (joueEtGagnePremierTourDeCraps()) System.out.println("Gagne");
        }
        but=somme;
        while(mise!=0){
            de1 = lancerUnDe();
            de2 = lancerUnDe();
            lancerLejeu(de1,de2);
            if(joueEtGagneUnTourDeCraps()) System.out.println("Gagne!");
            nbJetons = mise + 10;
            saisirMise(nbJetons);
            but=somme;
//            de1 = lancerUnDe();
//            de2 = lancerUnDe();
//            lancerLejeu(de1,de2);
//            if(joueEtGagneUnTourDeCraps()) System.out.println("Gagne!");
//            nbJetons = mise + 10;
//            saisirMise(nbJetons);
        }

    }
}
