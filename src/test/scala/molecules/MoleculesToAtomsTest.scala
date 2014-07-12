package molecules
import molecules.MoleculesToAtoms._
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class MoleculesToAtomsTest extends WordSpec with ShouldMatchers {
    
    "MoleculesToAtoms" should {
        """parse "H" from a string containing only "H"""" in {
            parseElement("H", "") should be (("", Option(Atom("H"))))
        }
        
        """parse "H" from a string containing "H2"""" in {
            parseElement("H2", "") should be (("2", Option(Atom("H"))))
        }
        
        """parse "Hg" from a string containing "Hg2"""" in {
            parseElement("Hg2", "") should be (("2", Option(Atom("Hg"))))
        }
        
        """parse "2" from a string containing only "2"""" in {
            parseNumber("2", "") should be ("", Option(2))
        }

        """parse "1" from a string containing no digits """ in {
            parseNumber("N", "") should be ("N", Option(1))
        }

        
                
        "count the number of atoms contained in a molecule of H2" in {
            pending
            parseMolecule("H2") should be ("{H: 2}")
        }

        "count the number of atoms contained in a molecule of H20" in {
            pending
            val water = "H20"
            parseMolecule("H2") should be ("{H: 2, O: 1}")               
        }

        "count the number of atoms contained in a molecule of Mg(OH)2" in {
            pending
	        val magnesiumHydroxide = "Mg(OH)2"
	        parseMolecule(magnesiumHydroxide) should be ("{Mg: 1, O: 2, H: 2}")
        }

        "count the number of atoms contained in a molecule of H2SO4" in {
            pending
        	val fremySalt = "K4[ON(SO3)2]2"
        	parseMolecule(fremySalt) should be ("{K: 4, O: 14, N: 2, S: 4}")
        }
    }

}