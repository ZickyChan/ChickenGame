/*
 * This is where each type of the chicken product is cloned 
 * instead of being created as a new object to save resources
 */
package GameObjects;

import java.util.Hashtable;
public class ChickenProductionCache {
    // A collection to store all the types of chicken product
    private static Hashtable<String, ChickenProduction> chickenProductMap = 
            new Hashtable<String, ChickenProduction>();
    
    // Store all product types in a Hashtable collection
    public static void loadCache(){
        GoldenEgg goldenEgg = GoldenEgg.getGoldenEgg();
        goldenEgg.setId("prod-01");
        chickenProductMap.put(goldenEgg.getId(), goldenEgg);
        
        NormalEgg normalEgg = NormalEgg.getNormalEgg();
        normalEgg.setId("prod-02");
        chickenProductMap.put(normalEgg.getId(), normalEgg);
        
        Poop poop = Poop.getPoop();
        poop.setId("prod-03");
        chickenProductMap.put(poop.getId(), poop);
    }
    
    // Clone a chicken product based on its type id (prodId)
    public static ChickenProduction getChickProd(String prodId){
        return (ChickenProduction) chickenProductMap.get(prodId).clone();
    }
}
