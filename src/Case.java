class Case{
  // représente une case du plateau
  private Indice m_indice; // indice de la case
  private int m_valeur, // valeur de la case
              m_valeur_max; // valeur maximale que peut prendre la case
  private boolean m_indice_visible, // vaut true si  l'indice doit être affiché
                  m_case_decouverte; // vaut true si  la case est découverte
  // constructeur
  Case(int max, boolean indiceVisible){
    setValeurMax(max);
    setCaseDecouverte(false);
    setIndiceVisible(indiceVisible);
    genCase();
  }
  private void genCase(){
    // génère la case aléatoirement
    java.util.Random r = new java.util.Random();
    // choisi un indice parmi ceux présents dans l'énumération
    setIndice(Indice.values()[r.nextInt(Indice.values().length)]);
    // donne une valeur aléatoire
    setValeur(r.nextInt(getValeurMax() + 1));
  }
  // accesseurs en lecture
  public Indice getIndice(){return m_indice;}
  public int getValeur(){return m_valeur;}
  private int getValeurMax(){return m_valeur_max;}
  public boolean isCaseDecouverte(){return m_case_decouverte;}
  private boolean isIndiceVisible(){return m_indice_visible;}
  public boolean isValeur(int v){
    // vérifie si la valeur de la case est égale à la valeur passée en paramètre
    return getValeur() == v;
  }
  // accesseurs en écriture
  public void setCaseDecouverte(boolean d){m_case_decouverte = d;}
  private void setIndice(Indice i){m_indice = i;}
  private void setIndiceVisible(boolean iv){m_indice_visible = iv;}
  private void setValeur(int v){m_valeur = v;}
  private void setValeurMax(int vm){m_valeur_max = vm;}
  public String toString(){
    // renvoie la représentation de la case sous forme de chaine de caractères
    String r = "";
    int i;
    if(isCaseDecouverte()){
      // ajoute un nombre d'espace avant la valeur pour coller avec un affichage
      // sous forme de tableau
      for(i = 0; i < DOutils.getNbChiffre(getValeurMax()) -
          DOutils.getNbChiffre(getValeur()); r += " ", i++);
      // ajoute la valeur sous forme de chaine
      r += "" + getValeur();
    }else{
      // ajoute le nombre de '#' correspondant à la valeur la plus grande
      // possible pour la case
      for(i = 0; i < DOutils.getNbChiffre(getValeurMax()); r += "#", i++);
    }
    // ajoute l'indice selon s'il doit être représenté ou non
    r += isIndiceVisible() || isCaseDecouverte() ? getIndice().toString() : "#";
    return r;
  }
}
