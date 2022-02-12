class Joueur{
  // représente un joueur
  private String m_nom; // contient le nom du joueur
  private long m_score; // contient le score actuel du joueur
  // constructeur
  Joueur(String nom){
    setNom(nom);
    setScore(0);
  }
  // accesseurs en lecture
  public String getNom(){return m_nom;}
  public long getScore(){return m_score;}
  public void joue(Plateau p, Niveau n){
    //simule le déroulement d'un tour
    Case[] c = new Case[2];
    int i = 0, j = 0, k;
    double d;
    boolean b;
    DSortie.afficheLigne(DSortie.vert("C'est à " + getNom() + " de jouer."));
    p.affiche();
    // demande au joueur de sélectionner deux cases
    for(k = 0; k < 2; k++){
      b = true;
      DSortie.afficheLigne(DSortie.vert("Sélectionnez la " + (k == 0 ?
          "première" : "seconde") + " case."));
      while(b){
        DSortie.afficheLigne(DSortie.vert("Entrez un numéro de ligne :"));
        j = DEntree.getInt(1, p.getHauteur()) - 1;
        DSortie.afficheLigne(DSortie.vert("Entrez un numéro de colonne :"));
        i = DEntree.getInt(1, p.getLargeur()) - 1;
        if(b = p.getCase(i, j).isCaseDecouverte()){
          DSortie.afficheErreur("Cette case a déjà été dévoilée. " +
              "Choisissez-en une autre !");
        }
      }
      c[k] = p.getCase(i, j);
      if(c[0].equals(c[1])){
        DSortie.afficheErreur("Vous devez choisir deux cases distinctes.");
        k = 0;
      }
    }
    // affiche les indices des cases
    for(k = 0; k < 2; k++){
      d = 0;
      try{
        d = Indice.getResultat(c[k], c[(k + 1) % 2]);
      }catch(Exception e){
        DSortie.afficheErreur(e);
      }finally{
        DSortie.afficheLigne(DSortie.vert("Indice de la " + (k == 0 ?
            "première" : "seconde") + " case : " + d));
      }
    }
    // propose au joueur de faire une hypothèse
    DSortie.afficheLigne(DSortie.vert("Faire une hypothèse ?"));
    if(DEntree.getConfirmation()){
      i = 0;
      for(k = 0; k < 2; k++){
        DSortie.afficheLigne(DSortie.vert(
            "Entrez la valeur hypothétique de la " + (k == 0 ? "première" :
            "seconde") + " case."));
        i += c[k].isValeur(DEntree.getInt(0, n.getValeurMax())) ? 1 : 0;
      }
      switch(i){
        case 2:
          DSortie.afficheLigne(
              DSortie.vert("Les deux hypothèses sont justes."));
          reussi(c[0].getValeur() + c[1].getValeur());
          for(k = 0; k < 2; k++){
            c[k].setCaseDecouverte(true);
          }
          break;
        case 1:
          DSortie.afficheLigne(
              DSortie.vert("L'une des deux hypothèses est fausse."));
          break;
        default:
          DSortie.afficheLigne(
              DSortie.vert("Les deux hypothèses sont fausses."));
      }
    }
  }
  public void reussi(long s){
    // ajoute un entier s au score actuel du joueur
    setScore(getScore() + s);
  }
  // accesseurs en écriture
  private void setNom(String n){m_nom = n;}
  private void setScore(long s){m_score = s;}
  public String toString(){
    // retourne les caractéristiques du joueur sous forme d'une chaine de
    // caractères
    return DSortie.magenta("Nom : " + getNom() + "\t[Score : " +
    getScore() + "]");
  }
}
