import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllTagsInOne {

    private static final String BHK_FILTER = "<START:BHK> ";
    private static final String END             = " <END> ";
    private static final String LOCALITY_FILTER = "<START:COLUMBUS> ";
    private static final String CITY_FILTER     = "<START:COLUMBUS> ";
    private static final String PROPERTY_TYPE_FILTER = "<START:PROPERTY_TYPE> ";
    private static final String FILENAME             = "/Users/user/temp/trainingDataSet.txt";

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
        
        
        List<String> cityList  = new ArrayList<>();
        cityList.add("Mumbai");

        List<String> propertyTypeList = new ArrayList<>();
        propertyTypeList.add("flat");
        propertyTypeList.add("villa");
        propertyTypeList.add("apartment");
        propertyTypeList.add("Builder Floor");

        List<String> bhkList = new ArrayList<>();

        bhkList.add("1 BHK");
        bhkList.add("2 BHK");
        bhkList.add("3 BHK");
        bhkList.add("3 bedroom");
        
        List<Integer> buyList = new ArrayList<>();
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(FILENAME);

            bw = new BufferedWriter(fw);
        

        for (String locality : localityList) {
            for (String bhk : bhkList) {
                for (String city : cityList) {
                    for (String property : propertyTypeList) {

                    StringBuilder text = new StringBuilder();
                    addFilter(BHK_FILTER, bhk, text);

                        addFilter(PROPERTY_TYPE_FILTER, property, text);

                        text.append(" in ");
                    String locality_city = locality + " " + city;
                    addFilter(LOCALITY_FILTER, locality_city, text);
                    
                    // text.append(" ");
                    // addFilter(CITY_FILTER, city, text);

                            writeInFile(text.toString(), bw);

                    StringBuilder text1 = new StringBuilder();

                    addFilter(BHK_FILTER, bhk, text1);
                        addFilter(PROPERTY_TYPE_FILTER, property, text1);
                        text1.append(" in ");
                    text1.append(" ");
                    addFilter(CITY_FILTER, city, text1);

                            writeInFile(text1.toString(), bw);

                    StringBuilder text2 = new StringBuilder();
                    addFilter(BHK_FILTER, bhk, text2);

                        addFilter(PROPERTY_TYPE_FILTER, property, text2);
                        text2.append(" in ");
                    addFilter(LOCALITY_FILTER, locality, text2);
                            writeInFile(text2.toString(), bw);

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

        } catch (IOException e) {

            e.printStackTrace();

        }

    
    }

}
