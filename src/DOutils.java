class DOutils{
  // cette classe sert de fourre-tout à méthodes diverses
  public static int getNbChiffre(long i){
    // renvoie le nombre de chiffres que possède un entier dans sa
    // représentation décimale
    int r = 1;
    if(i != 0){
      for(r = 0; i != 0; i /= 10, ++r);
    }
    return r;
  }
}
