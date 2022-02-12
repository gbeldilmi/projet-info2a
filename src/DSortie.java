class DSortie{
  // cette classe gère l'affichage dans le terminal
  public static void affiche(Object x){
    // un enrobeur pour System.out.print() sensé être plus court à écrire
    System.out.print(x.toString());
  }
  public static void afficheErreur(Object e){
    // affiche une erreur dans le terminal
    afficheLigne(rouge("---- ERREUR ---------------------------------\n  " +
    e.toString() + "\n---------------------------------------------"));
  }
  public static void afficheLigne(Object x){
    // un enrobeur pour System.out.println() sensé être plus court à écrire
    affiche(x.toString() + "\n");
  }
  // ces méthodes servent à changer la couleur d'affichage d'un texte dans le
  // terminal (ex: blanc(Object) change le texte en blanc)
  public static String blanc(Object x){
    return DCouleur.BLANC + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String bleu(Object x){
    return DCouleur.BLEU + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String cyan(Object x){
    return DCouleur.CYAN + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String jaune(Object x){
    return DCouleur.JAUNE + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String magenta(Object x){
    return DCouleur.MAGENTA + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String noir(Object x){
    return DCouleur.NOIR + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String rouge(Object x){
    return DCouleur.ROUGE + x.toString() + DCouleur.REINITIALISATION;
  }
  public static String vert(Object x){
    return DCouleur.VERT + x.toString() + DCouleur.REINITIALISATION;
  }
}
