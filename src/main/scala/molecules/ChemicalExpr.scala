package molecules

sealed trait ChemicalExpr {
    def add (m: ChemicalExpr) = ??? 
}

case class Atom(element: String) extends ChemicalExpr

case class Molecule(cardinality: Option[Int], m: ChemicalExpr*) extends ChemicalExpr 

case class Nothing() extends ChemicalExpr

