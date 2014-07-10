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
    val periodTable = Set("H")
    
    def parseMolecule(molecules: String): String = {
    	def _parse(s: String, m: ChemicalExpr): Option[ChemicalExpr] = {    	    
    	    def parseElement(s1: String, a: String): (String, Option[Atom]) = {
	    	    periodTable(a) match {
	    	        case true => (s1, Option(Atom(a)))
	    	        case false => if (!s1.isEmpty()) parseElement(s1.tail, s1.head + a) else (s1, None)
	    	    }
    	    }
    	    
    	    def parseNumber(s1: String, n: String): (String, Option[Int]) = {
    	        ???
    	    }
    	    
    	    val (s1, element) = parseElement(s, "")
    	    val (s2, number) = parseNumber(s1, "")
    	    
    	    element match {
    	        case None => Option(m)
    	        case Some(e) => _parse(s2, Molecule(number, m, Molecule(number, element)))
    	    }

    	}
    	
    	// K4[ON(SO3)2]2
    	
    	
    	val molecule = _parse(molecules, Nothing())
    	???
    }
}