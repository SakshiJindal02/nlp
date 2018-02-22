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
    private static final String FILENAME             = "/Users/user/temp/trainingDataSet.txt";
    private static final String POSTEDBY_FILTER            = "<START:POSTEDBY> ";
    private static final String LISTING_TYPE_FILTER  = "<START:LISTINGTYPE> ";
    private static final String SORT_ORDER_FILTER    = "<START:SORTORDER> ";
    
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

    private static String bhkForListingTypeInLocality(String bhk, String locality, String listingType) {
        StringBuilder text = new StringBuilder();
        addFilter(BHK_FILTER, bhk, text);
        text.append(" for ");
        addFilter(LISTING_TYPE_FILTER, listingType, text);
        text.append(" in ");
        addFilter(LOCALITY_FILTER, locality, text);
        return text.toString();
    }

    private static String sortOrderPropertyInLocality(String locality, String property, String sortO) {
        StringBuilder text = new StringBuilder();
        addFilter(SORT_ORDER_FILTER, sortO, text);
        addFilter(PROPERTY_TYPE_FILTER, property, text);
        text.append(" in ");
        addFilter(LOCALITY_FILTER, locality, text);

        return text.toString();
    }

    public static void main(String[] args) {

        List<String> localityList = new ArrayList<>();
        localityList.add("kharghar");
        localityList.add("thane west");
        localityList.add("chembur");
        localityList.add("mira road east");
        localityList.add("kandivali east");
        localityList.add("powai");
        localityList.add("andheri west");
        localityList.add("virar");
        localityList.add("goregaon east");
        localityList.add("malad west");
        localityList.add("ulwe");
        localityList.add("bandra west");
        localityList.add("nala sopara");
        localityList.add("dombivali");
        localityList.add("kandivali west");
        localityList.add("bhandup west");
        localityList.add("nalasopara west");
        localityList.add("andheri east");
        localityList.add("goregaon west");
        localityList.add("ghansoli");
        localityList.add("mulund west");
        localityList.add("kamothe");
        localityList.add("chembur east");
        localityList.add("malad east");
        localityList.add("panvel");
        localityList.add("borivali west");
        localityList.add("kanjurmarg");
        localityList.add("jogeshwari east");
        localityList.add("dombivali east");
        localityList.add("borivali east");
        localityList.add("ambernath east");
        localityList.add("tilak nagar");
        localityList.add("badlapur east");
        localityList.add("chandivali");
        localityList.add("parel");
        localityList.add("juhu");
        localityList.add("mira road");
        localityList.add("kalyan west");
        localityList.add("mumbai");
        localityList.add("taloja");
        localityList.add("badlapur");
        localityList.add("karanjade");
        localityList.add("umroli");
        localityList.add("naigaon east");
        localityList.add("neral");
        localityList.add("virar west");
        localityList.add("titwala east");
        localityList.add("sanpada");
        localityList.add("dahisar");
        localityList.add("lower parel");
        localityList.add("badlapur west");

        List<String> cityList = new ArrayList<>();
        cityList.add("mumbai");

        List<String> propertyTypeList = new ArrayList<>();
        propertyTypeList.add("villa");
        propertyTypeList.add("apartment");
        propertyTypeList.add("builder-floor");
        propertyTypeList.add("independent-house");
        propertyTypeList.add("plot");
        propertyTypeList.add("residential-plot");

        List<String> bhkList = new ArrayList<>();
        bhkList.add("1bhk");
        bhkList.add("1 bhk");
        bhkList.add("2bhk");
        bhkList.add("2 bhk");
        bhkList.add("3bhk");
        bhkList.add("3 bhk");

        List<String> postedByList = new ArrayList<>();
        postedByList.add("owner");

        List<String> listingTypesList = new ArrayList<>();
        listingTypesList.add("rent");
        listingTypesList.add("buy");
        
        List<String> sortOrder = new ArrayList<>();
        sortOrder.add("low budget");
        sortOrder.add("high budget");
        sortOrder.add("popular");

        List<String> priceList = new ArrayList<>();
        priceList.add("under 1 cr");
        priceList.add("under 1.1cr");
        priceList.add("under 1.2 cr");
        priceList.add("under 1.3 cr");
        priceList.add("under 1.4cr");
        priceList.add("under 1.5 cr");
        priceList.add("under 1.6 cr");
        priceList.add("under 1.7 cr");
        priceList.add("under 1.8cr");
        priceList.add("under 1.9 cr");
        priceList.add("under 2 cr");
        priceList.add("under 2.1 cr");
        priceList.add("under 2.2 cr");
        priceList.add("under 2.3 cr");
        priceList.add("under 2.4cr");
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
                for (String property : propertyTypeList) {
                    for (String sortO : sortOrder) {
                        writeInFile(sortOrderPropertyInLocality(locality, property, sortO), bw);
                    }
                }
            }

            for (String locality : cityList) {
                for (String property : propertyTypeList) {
                    for (String sortO : sortOrder) {
                        writeInFile(sortOrderPropertyInLocality(locality, property, sortO), bw);
                    }
                }
            }

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
                    for (String listingType : listingTypesList) {
                        writeInFile(bhkForListingTypeInLocality(bhk, locality, listingType), bw);
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
