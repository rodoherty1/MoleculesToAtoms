package molecules

sealed trait ChemicalExpr 


case class Atom(element: String) extends ChemicalExpr

case class Molecule(cardinality: Option[Int], m: List[ChemicalExpr]) extends ChemicalExpr 

