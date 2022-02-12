class DEntree{
  // cette classe permet la lecture de données saisies au clavier par
  // l'utilisateur
  public static boolean getConfirmation(){
    // demande une entrée à l'utilisateur sous la forme d'un oui/non pour la
    // renvoyer sous la forme d'un booléen, si rien n'est entré ou si l'entrée
    // est incorecte, cette méthode renverra true par défaut
    String s;
    DSortie.affiche(DSortie.vert("  [O/n] >> "));
    s = lire().trim().toLowerCase();
    return s.isEmpty() ? true : s.equals("o");
  }
  public static int getInt(){
    // demande l'entrée d'un entier à l'utilisateur
    boolean c = true;
    int i = 0;
    while(c){
      try{
        DSortie.affiche(DSortie.vert("\t>> "));
        i = Integer.parseInt(lire());
        c = false;
      }catch (Exception e){
        DSortie.afficheErreur(e);
      }
    }
    return i;
  }
  public static int getInt(int min){
    // demande à l'utilisateur l'entrée d'un entier supérieur à min
    int i;
    do{
      i = getInt();
      if(i < min){
        DSortie.afficheErreur("Vous avez entré quelquechose plus petit que " +
        min);
      }
    }while(i < min);
    return i;
  }
  public static int getInt(int min, int max){
    // demande à l'utilisateur l'entrée d'un entier supérieur à min et inférieur
    // à max
    int i;
    do{
      i = getInt(min);
      if(i > max){
        DSortie.afficheErreur("Vous avez entré quelquechose plus grand que  " +
        max);
      }
    }while(i > max);
    return i;
  }
  public static String getString(){
    // demande à l'utilisateur une entrée sous la forme d'une chaine de
    // caractères
    DSortie.affiche(DSortie.vert("\t>> "));
    return lire();
  }
  private static String lire(){
    // lit les entrées au clavier et la retourne sous forme d'une chaine de
    // caractères
    String s = "";
    try{
      // lit les frappes de l'utilisateur et les convertit en chaine de
      // caractères
      s = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
          .readLine();
    }catch (Exception e){
      DSortie.afficheErreur(e);
    }
    return s;
  }
  public static void pause(){
    // met l'exécution du programme en pause jusqu'à ce que l'utilisateur
    // appuuie sur la touche ENTREE de son clavier
    DSortie.affiche(DSortie.vert(
        "\tAppuyez sur la touche ENTREE pour continuer..."));
    lire();
  }
}
