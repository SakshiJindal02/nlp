import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllTagsInOne {

    private static final String BHK_FILTER           = "<START:BHK> ";
    private static final String END                  = " <END> ";
    private static final String LOCALITY_FILTER      = "<START:COLUMBUS> ";
    private static final String CITY_FILTER          = "<START:COLUMBUS> ";
    private static final String PROPERTY_TYPE_FILTER = "<START:PROPERTY_TYPE> ";
    private static final String PRICE_FILTER         = "<START:PRICE> ";
    private static final String FILENAME             = "/home/anmol/trainingDataSet2.txt";
    private static final String POSTEDBY_FILTER            = "<START:POSTEDBY> ";
    
    //{ "3", "BHK", "apartment", "under", "10000", "in", "Chembur Mumbai", "by", "broker" }
    public static String type1LocalityCityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();
        
        addFilter(BHK_FILTER, bhk, text);
        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);
        addFilter(PRICE_FILTER, price, text);             
        text.append(" in ");        
        String locality_city = locality + " " + city;
        addFilter(LOCALITY_FILTER, locality_city, text);       
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);        
        return text.toString();
    }
    
    //{ "3", "BHK", "apartment", "under", "10000", "in", "Chembur" , "by", "broker"}
    public static String type1CityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();

        addFilter(BHK_FILTER, bhk, text);
        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);
        addFilter(PRICE_FILTER, price, text);        
        text.append(" in ");        
        addFilter(CITY_FILTER, city, text);    
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);    
        return text.toString();
    }
    
    //{ "3", "BHK", "apartment", "under", "10000", "in", "Mumbai" , "by", "broker"}
    public static String type1LocalityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();
        
        addFilter(BHK_FILTER, bhk, text);
        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);
        addFilter(PRICE_FILTER, price, text);        
        text.append(" in ");        
        addFilter(LOCALITY_FILTER, locality, text);    
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);    
        return text.toString();
    }

    //{ "under", "1000000/1cr", "3", "BHK", "apartment", "in", "Mumbai" , "by", "broker"}
    public static String type2CityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();
        
        addFilter(PRICE_FILTER, price, text);
        addFilter(BHK_FILTER, bhk, text);
        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);        
        text.append(" in ");        
        addFilter(CITY_FILTER, locality, text);    
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);    
        return text.toString();
    }
    
    //////////////////////////////////
    //{ "apartment", "under", "1000000/1cr", "having", "3", "bhk", "in", "Mumbai" , "by", "broker"}
    public static String type3CityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();

        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);
        addFilter(PRICE_FILTER, price, text);        
        text.append(" having ");
        addFilter(BHK_FILTER, bhk, text);        
        text.append(" in ");        
        addFilter(CITY_FILTER, locality, text);    
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);    
        return text.toString();
    }
    
    //////////////////////////////////
    //{ "apartment", "having", "3", "bedroom", "under", "1000000/1cr", "in", "Mumbai", "by", "broker" }
    public static String type4CityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();
        
        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);        
        text.append(" having ");
        addFilter(BHK_FILTER, bhk, text);        
        addFilter(PRICE_FILTER, price, text);
        text.append(" in ");
        addFilter(CITY_FILTER, locality, text);    
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);    
        return text.toString();
    }
    
    //////////////////////////////////
    //{ "apartment", "in", "Mumbai", "having", "3", "bedroom", "under", "1000000/1cr", "by", "broker"}
    public static String type5CityQuery(String locality, String bhk, String city, String propertyType, String price, String postedBy) {
        StringBuilder text = new StringBuilder();

        addFilter(PROPERTY_TYPE_FILTER, propertyType, text);
        text.append(" in ");
        addFilter(CITY_FILTER, locality, text);
        text.append(" having ");
        addFilter(BHK_FILTER, bhk, text);
        addFilter(PRICE_FILTER, price, text);      
        text.append(" by ");  
        addFilter(POSTEDBY_FILTER, postedBy, text);          
        return text.toString();
    }

    public static void main(String[] args) {

        List<String> localityList = new ArrayList<>();
        localityList.add("Kharghar");
        localityList.add("Thane West");
        localityList.add("Chembur");
        localityList.add("Mira Road East");
        localityList.add("Kandivali East");
        localityList.add("Powai");
        localityList.add("Andheri West");
        localityList.add("Virar");
        localityList.add("Goregaon East");
        localityList.add("Malad West");
        localityList.add("Ulwe");
        localityList.add("Bandra West");
        localityList.add("Nala Sopara");
        localityList.add("Dombivali");
        localityList.add("Kandivali West");
        localityList.add("Bhandup West");
        localityList.add("Nalasopara West");
        localityList.add("Andheri East");
        localityList.add("Goregaon West");
        localityList.add("Ghansoli");
        localityList.add("Mulund West");
        localityList.add("Kamothe");
        localityList.add("Chembur East");
        localityList.add("Malad East");
        localityList.add("Panvel");
        localityList.add("Borivali West");
        localityList.add("Kanjurmarg");
        localityList.add("Jogeshwari East");
        localityList.add("Dombivali East");
        localityList.add("Borivali East");
        localityList.add("Ambernath East");
        localityList.add("Tilak Nagar");
        localityList.add("Badlapur East");
        localityList.add("Chandivali");
        localityList.add("Parel");
        localityList.add("Juhu");
        localityList.add("Mira Road");
        localityList.add("Kalyan West");
        localityList.add("mumbai");
        localityList.add("Taloja");
        localityList.add("Badlapur");
        localityList.add("Karanjade");
        localityList.add("Umroli");
        localityList.add("Naigaon East");
        localityList.add("Neral");
        localityList.add("Virar West");
        localityList.add("Titwala East");
        localityList.add("Sanpada");
        localityList.add("Dahisar");
        localityList.add("Lower Parel");
        localityList.add("Badlapur West");

        List<String> cityList = new ArrayList<>();
        cityList.add("Mumbai");

        List<String> propertyTypeList = new ArrayList<>();
        propertyTypeList.add("villa");
        propertyTypeList.add("apartment");
        propertyTypeList.add("builder floor");
        propertyTypeList.add("independent house");
        propertyTypeList.add("plot");

        List<String> bhkList = new ArrayList<>();
        bhkList.add("1BHK");
        bhkList.add("1 BHK");
        bhkList.add("2bhk");
        bhkList.add("2 bhk");
        bhkList.add("3BHK");
        bhkList.add("3 BHK");
        bhkList.add("4bhk");
        bhkList.add("4 bhk");

        List<String> postedByList = new ArrayList<>();
        postedByList.add("owner");

//        List<String> buyList = new ArrayList<>();
//        buyList.add("rent");
//        buyList.add("buy");
        
        List<String> priceList = new ArrayList<>();
        priceList.add("under 1 cr");
        priceList.add("under 1.1 cr");
        priceList.add("under 1.2 cr");
        priceList.add("under 1.3 cr");
        priceList.add("under 1.4 cr");
        priceList.add("under 1.5 cr");
        priceList.add("under 1.6 cr");
        priceList.add("under 1.7 cr");
        priceList.add("under 1.8 cr");
        priceList.add("under 1.9 cr");
        priceList.add("under 2 cr");
        priceList.add("under 2.1 cr");
        priceList.add("under 2.2 cr");
        priceList.add("under 2.3 cr");
        priceList.add("under 2.4 cr");
        priceList.add("under 2.5 cr");
        priceList.add("under 2.6 cr");
        priceList.add("under 2.7 cr");
        priceList.add("under 2.8 cr");
        priceList.add("under 2.9 cr");
        priceList.add("under 3 cr");

//        List<String> furnishTypeList = new ArrayList<>();
//        furnishTypeList.add("furnished");
//        furnishTypeList.add("unfurnished");

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(FILENAME);

            bw = new BufferedWriter(fw);
            
            
            for (String locality : localityList) {
                for (String bhk : bhkList) {
                    for (String city : cityList) {
                        for (String property : propertyTypeList) {
                            for(String price : priceList) {
                                for(String postedBy : postedByList) {
                                    writeInFile(type1LocalityCityQuery(locality, bhk, city, property, price, postedBy), bw);
                                    writeInFile(type1CityQuery(locality, bhk, city, property, price, postedBy), bw);
                                    writeInFile(type1LocalityQuery(locality, bhk, city, property, price, postedBy), bw);
                                    writeInFile(type2CityQuery(locality, bhk, city, property, price, postedBy), bw);
                                    writeInFile(type3CityQuery(locality, bhk, city, property, price, postedBy), bw);
                                    writeInFile(type4CityQuery(locality, bhk, city, property, price, postedBy), bw);
                                    writeInFile(type5CityQuery(locality, bhk, city, property, price, postedBy), bw);
                                }
                                
                            }


                        }
                    }
                }
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            }
            catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    private static void addFilter(String bhkFilter, String bhk, StringBuilder text) {
        text.append(bhkFilter).append(bhk).append(" ").append(END).append(" ");

    }

    public static void writeInFile(String content, BufferedWriter bw) {

        try {
            bw.write(content);
            bw.write("\n");
            System.out.println("\n done");
            

        }
        catch (IOException e) {

            e.printStackTrace();

        }

    }

}
