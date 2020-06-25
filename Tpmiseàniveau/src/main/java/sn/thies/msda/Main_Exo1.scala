package sn.thies.msda

import java.io.{FileNotFoundException, FileReader}
import org.apache.spark.sql.SparkSession

object Main_Exo1 extends App {
  val spark = SparkSession
    .builder
    .appName("Movies Reviews")
    .config("spark.master", "local")
    .getOrCreate()
  /*



   */

  println("Travaux pratiques mise à niveau ")
  println("EXO1: Bonnes pratiques")

  //Question1:
  println("1-) L'avantage de la Programmation Scala: ")
  println("Scala regroupe un ensemble de de caractéristiques trés intéressantes:\n la simplicité de sa syntaxe et du paradigme\n des programmations orientée objet et fonctionnelle. ")
  /*


   */
  //Question 2:
  println("2-) Interprétaton des instructions suivantes: ")
  var a=1 //ou var a:Int=1
  println("var a=1 //ou var a:Int=1 a; est une variable, int pour le type dela variable")
  val b=2
  println("val b=2; b est une constante")
  final val c=4
  println("final val c=4; final permet de faire de la programmation fonctionnelle avec des données non mutables\n et eviter les derivees. ici affecte c la valeur 4 immutable")
  private final val e=3
  println("visible que par les instance de cette classe")
  lazy val name ="fall"
  println("l'expression fall n'est pas imediatement utilisé mais lors du premier accès")

  //Question 3:
  println("3-L’initialisation d’une variable peut etre optimiser par Option[Type]")
  def salairenet(salairebrute:Int ,taxe:Int, primes:Option[Int]=None)=salairebrute - taxe + primes.getOrElse(0)
  println("son salaire est de ", salairenet(30000,1700))
  println("son salaire est de ",salairenet(40000,2100, Some(4000)))

  //Question 4:
  println("Definition polymorphisme et exemple ")
  println("C'est l'un des concept les plus importants de l'orienté objet.\n Il s'agit de la capacité d'une quelconque donnée à pouvoir evoluer sur plus d'une forme")
 //Exemple:
 // Forme 1
   def plm(lieunaiss:String, paysnaiss:String)
   {
     println("Monsieur est né à:" + lieunaiss)
     println(" Il se situe au: " + paysnaiss)
   }
  // Forme 2
   def plm(montant:Int, depense:Int)
   {
     println(s"Il dispose de: ${montant-depense}")
   }
  plm("Malika", "Galsen")
  plm(20, 10)

  //Question 5
  println("Comment appel-ton le mécanisme d' incorporer une référence dans une chaîne de caractère\nDeux exemples\n(interpoler une variable et évaluer une fonction)")
  println("C'est une interpolation")
  //Interpoler une référence dans une chaîne
  val point1="Sud"
  val point2="Nord"
  val point3="Est"
  val point4="Ouest"
  println(s"Les quatres points cardinaux sont $point3, $point4,$point2 et $point1 "  )
  println( "le " + point1 + " est en bas\nle "+ point2 +" en haut\nl'"+ point3 +" à droite" )
  //Interpoler une evaluation dans une chaîne
  val p=10
  val q=5
  println("le produit de p et q est donné par "+p+"*"+q+ s"= ${p*q}" )
  //Question 6
  println("Exemple de fonction avec du pattern matching: ")
  def mention(note : Int): Unit=
      note match{
        case 1 | 2 | 3 | 4 | 5 => println(s"$note: mention Médiocre")
        case 6 | 7 | 8 |  9 => println(s"$note: mention Insuffisant")
        case 10 | 11  => println(s"$note: mention Passable")
        case 12 | 13  => println(s"$note: mention Abien")
        case 14 | 15  => println(s"$note: mention Bien")
        case 16 | 17  => println(s"$note: mention TBien")
        case 18 | 19  => println(s"$note: mention Excellent")
        case 20  => println(s"$note: mention etonnement du jury")
      }
  mention(10)
  //Question 7
  println("l'avantage des lambda expression\n Lorsqu'on utilise une fonction simple,\n les lambda expressions sont plus pratiques au meme endroit\n  Elles sont plus rapides et plus expressives que la fonction entière.")
  //Question 8:
  println("Utilisation d'un tableau(array) et une liste(List):\nL'utilisation dépend de la complexité. \nOn utilise un tableau lorsque les elements sont accessibles, de meme type, continus et statiques.\n Une liste est une collection d'élements hétérogénes dont la déclaration est dynamique et aléatoire utilisé pour supprimé un élement,\n inserer un element, ou faire de la concaténation.")
  //Somme moyenne max liste
  //Programmation Impérative:
  println("Programmation Impérative:")
  def maxim(list:List[Int]):Int = {
    if (list.isEmpty)
    {
    throw new RuntimeException("empty list")
    }
    else {
      if (list.length == 1){
        list.head
      }
      else {
        if (list.head >= maxim(list.tail)){
          (list.head)
        }
        else{
          maxim(list.tail)
        }
      }
    }
  }
  println("Le max de la liste est",maxim(List(1,2)))


  println("Programmation recursive:")
  def sommerec(xs : List[Int]): Int =
    xs match {
      case Nil =>0
      case y :: ys =>y + sommerec(ys)

    }
  println(s"la somme est ${sommerec(List(1,2))}, la moyenne est  ${sommerec(List(1,2))/List(1,2).length}")
  //
  println("Programmation avec les lambda expressions:")
  def sommelamb(xs : List[Int])= xs.reduce((a,b)=>a+b)
  def meanlamb(xs : List[Int])= xs.reduce((a,b)=>a+b) / (xs.length)
  println("La somme est ",sommelamb(List(1,2)))
  println("La moyenne est ",meanlamb(List(1,2)))
  //Question 9:
  println("les mêmes fonctions pour une matrice")
  println("Programmation avec les lambda expressions:")
  def sommelambmat(ms : List[List[Int]])= ms.map(e=>e.reduce((a,b)=>a+b)).reduce((a,b)=>a+b)
  println("la somme de la matrice est",sommelambmat( List(List(1,2,3),List(1,3))))

  //Question 10. Définissez une fonctionne sommecol(matrice)
    //programmation impérative
  def sommecol(ms : List[List[Int]])= ms.transpose.map(e=>e.reduce((a,b)=>a+b))
  println("la somme d es colonnes de la matrice est", sommecol( List(List(1,2,3),List(1,3,8))))
  //Question 11: intérêt d’utiliser foldLeft ou foldRight à la place de reduce/donneons un exemple
  println("Intérêt d’utiliser foldLeft ou foldRight à la place de reduce")
  println("FoldLeft ou Foldright sont comme reduce définie en terme de fonction plus générale.\nElles prennent un accumulateur ou zero qui est routourné lorsqu'elles sont appelées sur des listes vides")
  //Exemple
  def produit(xs : List[Int])= (xs foldLeft 1)(_*_)
  println(produit(List(1,2)))

 //Question 12: Définissez une de fonction reader(path) qui lit un fichier en gérant ses exceptions avec try catch et finally

   def lecteur():Unit = {
     try {
       val fichier = new FileReader("C:\\Users\\Abdul Lahi Jaaw\\Documents\\tableauclass.txt")
     }
     catch {
       case ex: FileNotFoundException => {
         println("fichier sans exceptions")
       }
       case ex: IndexOutOfBoundsException => {
         println("IO exception")
       }
     }
     finally {
       println("fichier existe...")
     }
 }
  lecteur()
  //Question13
  println("Dresser un tableau qui compare une case class et class simple")
  var tab=spark.sparkContext.textFile("C:\\Users\\Abdul Lahi Jaaw\\Documents\\tableauclass.txt")
  tab.foreach(println)
  //Question 14
  class Etudiant(private var nomd:String, var age:Int )
  //L'incovenient est que ages est publiaue et accessible.
  //Question 15
  print("L'encapsulation est un processus d'embellage de code et de données\nensemble dans une seule unité.")
  //Etant donné que chaque fonction est une value, et chaque value est un objet,chaque value a ses propres getter et setter
  private var _laye=1
  // Getter
  def laye=_laye
  //Setter
  def laye_=(value:Int):Unit=_laye=value
  //Question16
  println("Analysons la classe suivante/proposons une solution pour les accès et les modifications de son état")
///class Person(var nom:String, val prenom :String, idcni:Int, private var age :Int)
  println("On a déclaré la variable nom et la contante prénom étant plublique et accessible.\nLa variable age elle, comme étant privée.\nDonc il est accessible que par la classe.\nOn utilise la fonction show() pour modifier et acceder à age")
  /*class Person(var nom:String, val prenom :String, idcni:Int, private var age :Int)
  def show() {
  age=nvelval
  }
  object access extends App{
  var person2= new Person
  person2.show()
  }
*/
  // Si on avait une case case, on pourrait directement acceder aux attributs.
  //Question17
  println("Dresser un tableau qui compare un trait et une class abstraite/donnez des exemples concrètes")
  var tab1=spark.sparkContext.textFile("C:\\Users\\Abdul Lahi Jaaw\\Documents\\traitabsatrait.txt")
  tab1.foreach(println)

  abstract class layelaye {
    def calling()
  }

    class laye extends layelaye {
      def calling(){
        println ("call laye for me")
      }
    }
var layebi= new laye()
  layebi.calling()

  trait layelayet
  {
    def done
    def callingt() {
      println("call laye for me")

    }
  }
class layet extends layelayet
{
  def done()
  {
    println("laye called")
  }
}
  var layebit= new layet ()
  layebit.callingt()
  layebit.done()

  //Question18
  println("C'est un object dont le nom es le meme que celui de la classe.\nOn l'utilise quand on veut accéder aux domaines privés de la classe")
//Quesrion19:Objectif des implicites /donnez deux exemples(variable implicites et fonction implicite)
  implicit val sontyp= "Questio,"
  implicit val  numerp = 19
  def  typenum(implicit sontype:String, numero:Int ) = println(s"$sontype numero $numero")
typenum("question",19)

  case class Produit(prix: String , montant:Int)
  implicit def prixTotal(   prixprod: String) = Produit(prixprod.split(",")(0),  prixprod.split(",")(1).toInt  )
  def pripro( n:Int, p:Produit ): Int = p.montant+n
  val banana:String= "banana,300"
  println("banana vaut", pripro(100, banana))


}

