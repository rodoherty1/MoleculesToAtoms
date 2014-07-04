package molecules
import molecules.MoleculesToAtoms._
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class MoleculesToAtomsTest extends WordSpec with ShouldMatchers {
    
    "MoleculesToAtoms" should {
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