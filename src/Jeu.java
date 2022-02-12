class Jeu{
  // représente une partie et gère son déroulement
  private java.util.ArrayList<Joueur> m_joueurs; // l'ensemble des joueurs
  private Plateau m_plateau; // le plateau
  private Niveau m_niveau; // le niveau de difficulté choisi
  // constructeur
  Jeu(java.util.ArrayList<Joueur> joueurs, Niveau niveau){
    setJoueurs(joueurs);
    setNiveau(niveau);
    setPlateau(new Plateau(getNiveau().getLargeur(), getNiveau().getHauteur(),
      getNiveau().getValeurMax(), getNiveau().isIndicesVisibles()));
  }
  private void afficheCaracteristiquesJoueurs(){
    // affiche les caractéristiques des joueurs
    DSortie.afficheLigne(DSortie.magenta("Joueurs :"));
    for (Joueur j : getJoueurs()){
      DSortie.afficheLigne(DSortie.magenta(j.toString()));
    }
  }
  private void afficheCaracteristiquesPartie(){
    // affiche les caractéristiques de la partie
    DSortie.afficheLigne(DSortie.cyan("Caractéristiques du jeu :\n" +
    toString()));
    afficheCaracteristiquesJoueurs();
  }
  // accesseurs en lecture
  private Joueur getJoueur(int i){return getJoueurs().get(i);}
  private java.util.ArrayList<Joueur> getJoueurs(){return m_joueurs;}
  private int getNbJoueurs(){return getJoueurs().size();}
  private Niveau getNiveau(){return m_niveau;}
  private Plateau getPlateau(){return m_plateau;}
  public void joue(){
    // simule le déroulement d'une partie
    for(int t = 0; !getPlateau().toutesLesCasesSontDecouvertes(); t++){
      afficheCaracteristiquesPartie();
      getJoueur(t % getNbJoueurs()).joue(getPlateau(), getNiveau());
    }
    DSortie.afficheLigne(
        DSortie.jaune("Toutes les cases ont été découvertes."));
    getPlateau().affiche();
    afficheCaracteristiquesJoueurs();
  }
  // accesseurs en écriture
  private void setJoueurs(java.util.ArrayList<Joueur> j){m_joueurs = j;}
  private void setNiveau(Niveau n){m_niveau = n;}
  private void setPlateau(Plateau p){m_plateau = p;}
  public String toString(){
    // retourne les caractéristiques de la partie sous forme de chaine de
    // caractères
    String r = "Difficulté choisie : " + getNiveau().toString() +
    "\nValeur maximale : " + getNiveau().getValeurMax() + "\nIndices : " +
    (!getNiveau().isIndicesVisibles() ? "in" : "") +
    "visibles\nIndices possibles : ";
    for(Indice i : Indice.values()){
      r += i.toString() + " ";
    }
    return r;
  }
}
