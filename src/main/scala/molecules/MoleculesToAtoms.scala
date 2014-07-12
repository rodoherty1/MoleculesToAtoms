package molecules

object Int {
    def unapply(s: String): Option[Int] = {
        try {
	        Some(s.toInt)
	    } catch {
		    case _ : java.lang.NumberFormatException => None
        }
    }


}
object MoleculesToAtoms {

    // K4[ON(SO3)2]2
    def parseElement(s: String, a: String): (String, Option[Atom]) = {
        s match {
            case s1 if (s1.isEmpty) => if (a.isEmpty()) (s, None) else (s1, Option(Atom(a)))
            case s1 if s1.head.isDigit => (s, Option(Atom(a)))
            case s1 if s1.head.isLower => (s.tail, Option(Atom(a + s1.head.toString)))
            case _ => parseElement(s.tail, s.head.toString)
        }
    }
    
    def parseNumber(s: String, n: String): (String, Option[Int]) = {
        s match {
            case s1 if s1.isEmpty => if (n.isEmpty) (s, Option(1)) else (s, Option(n.toInt))
            case s1 if s1.head.isDigit => parseNumber(s1.tail, n + s1.head)
            case _ => if (n.isEmpty) (s, Option(1)) else (s, Option(n.toInt))
        }
	}

    def parse(s: String, l: List[ChemicalExpr]): List[ChemicalExpr] = {    	    
	    val (s1, element) = parseElement(s, "")
	    val (s2, number) = parseNumber(s1, "")
	    
	    element match {
	        case None => l
	        case Some(e) => parse(s2, Molecule(number, List(e)) :: l)
	    }
	}
    	    
    def parseMolecule(molecules: String): String = {
    	
    	// K4[ON(SO3)2]2
    	val molecule = parse(molecules, List())
    	???
    }
}