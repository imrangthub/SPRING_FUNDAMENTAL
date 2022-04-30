import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import domain.request.Member;
import domain.request.Request;
import domain.response.Accumulator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void xmlToMethodCall() {
        try {
            File file = new File("src/main/resources/requestBody.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Request request = (Request) unmarshaller.unmarshal(file);

            for (Member member : request.getParams().getParam().getValue().getStruct().getMember()) {
                if (member.getValue().getDateTime() != null) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ssZ");
                    df.setTimeZone(TimeZone.getTimeZone("GMT"));
                    member.getValue().setDateTime(df.format(new Date()));
                }
            }

            System.out.println(request);
            methodCallToXml(request);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void methodCallToXml(Request request) {
        try {
            JAXBContext context = JAXBContext.newInstance(Request.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            marshaller.marshal(request, new File("src/main/resources/responseBody.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String readXMLData(String filename) throws IOException {
        File xmlFile = new File(filename);
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder xmlData = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            xmlData.append(line).append("\n");
        }
        return xmlData.toString();
    }



    public static void main(String[] args) throws IOException {

        String IP = "112.116.18.113";
        String Port = "6693";
        String reqBody = readXMLData("src/main/resources/requestBody.xml");

        String resBosy = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<methodCall><methodName>GetAccumulators</methodName><params><param><value><struct><member><name>originHostName</name><value><string>apihub</string></value></member><member><name>originNodeType</name><value><string>EXT</string></value></member><member><name>originTimeStamp</name><value><dateTime.iso8601>20220427T08:48:58+0000</dateTime.iso8601></value></member><member><name>originTransactionID</name><value><string>7972754869417856753</string></value></member><member><name>subscriberNumber</name><value><string>8801902798185</string></value></member></struct></value></param></params></methodCall>";


        String response = httpUCIP.callApi(IP, Port, resBosy);
        List<Accumulator> accumulators = getAccumulators(response);
        accumulators.forEach(System.out::println);
    }

    private static List<Accumulator> getAccumulators(String xmlData) throws IOException {
        ObjectMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xmlData.getBytes());
        JsonNode members = node.get("params").get("param").get("value").get("struct").get("member");
        JsonNode accumulatorList = null;

        if (members.isArray()) {
            for (JsonNode n : members) {
                String value = n.findValuesAsText("name").get(0);
                if ("accumulatorInformation".equalsIgnoreCase(value)) {
                    accumulatorList = n.get("value").get("array").get("data").get("value");
                    break;
                }
            }
        }

        List<Accumulator> dataList = new ArrayList<>();
        if (accumulatorList != null) {
            for (JsonNode struct : accumulatorList) {

                Accumulator accumulator = new Accumulator();
                members = struct.get("struct").get("member");

                for (JsonNode member : members) {

                    String property = member.findValuesAsText("name").get(0).toLowerCase();
                    JsonNode valueNode = member.get("value");

                    int propertyNo = property.contains("id") ? 1 :
                            property.contains("value") ? 2 :
                                    property.contains("startdate") ? 3 :
                                            property.contains("enddate") ? 4 : -1;

                    String value = propertyNo == -1 ? "" :
                            propertyNo <= 2 ? valueNode.findValuesAsText("i4").get(0) :
                                    valueNode.findValuesAsText("dateTime.iso8601").get(0);


                    switch (propertyNo) {
                        case 1:
                            accumulator.setId(Integer.parseInt(value));
                            break;
                        case 2:
                            accumulator.setValue(Integer.parseInt(value));
                            break;
                        case 3:
                            accumulator.setStartDate(value);
                            break;
                        case 4:
                            accumulator.setEndDate(value);
                            break;
                        default:
                            break;
                    }
                }
                dataList.add(accumulator);
            }
        }
        return dataList;
    }
}
