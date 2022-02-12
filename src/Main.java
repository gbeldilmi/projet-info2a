class Main{
  public static void main(String[] args){
    // point d'entrée du programme
    java.util.ArrayList<Joueur> u = new java.util.ArrayList<Joueur>();
    String s;
    int i;
    boolean c = true;
    while (c){
      // entrée des joueurs
      while(c){
        s = "";
        while(c){
          DSortie.afficheLigne(DSortie.vert("Entrez le nom du joueur."));
          s = DEntree.getString().trim();
          if(c = s.equals("")){
            DSortie.afficheErreur("Veuillez entrer un nom valide.");
          }
        }
        u.add(new Joueur(s));
        DSortie.afficheLigne(DSortie.vert(
            "Voulez-vous ajouter un autre joueur ?"));
        c = DEntree.getConfirmation();
      }
      // choix de la difficulté
      DSortie.afficheLigne(DSortie.vert("Choisissez une difficulté :"));
      for (i = 0; i < Niveau.values().length; i++){
        DSortie.afficheLigne(DSortie.vert("  " + i + " > " +
            Niveau.values()[i].toString()));
      }
      // création du jeu et début de la partie
      new Jeu(u, Niveau.values()[DEntree.getInt(0, Niveau.values().length - 1)])
          .joue();
      // demande à l'utilisateur s'il souhaite rejouer
      DSortie.afficheLigne(
          DSortie.vert("Voulez-vous faire une nouvelle partie ?"));
      c = DEntree.getConfirmation();
    }
  }
}
