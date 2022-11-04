package com.example.crypto_currency;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class CryptoFromXML {

    private Crypto [] cryptoCurrencies;
    public Crypto[] getCryptoCurrencies() {
        return cryptoCurrencies;
    }
    private Context context;

    public CryptoFromXML(Context context) {

        this.context = context;

        // opemn a stream to the XML file + a docBuilder +Dco
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try {

            // get resources -  to get tht folder we need do a .context
            // openRawResource(R.xml.crypto) we speciy the path to xml
            stream = this.context.getResources().openRawResource(R.raw.crypto);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);


        } catch (Exception e) {
        }

        // slice xmlDoc to NodeLists
        // go throught the xml get the details
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList coinCodeList = xmlDoc.getElementsByTagName("coinCode");
        NodeList currentValueList = xmlDoc.getElementsByTagName("currentValue");
        NodeList marketCapList = xmlDoc.getElementsByTagName("marketCap");
        NodeList ratingList = xmlDoc.getElementsByTagName("rating");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList urlList = xmlDoc.getElementsByTagName("url");

        // our data is an array in our class
        // so we make this array

        cryptoCurrencies = new Crypto[nameList.getLength()];

        // noiw create each person in the people array

        for (int i = 0; i < cryptoCurrencies.length; i++) {

            String name = nameList.item(i).getFirstChild().getNodeValue();
            String coinCode = coinCodeList.item(i).getFirstChild().getNodeValue();
            String currentValue = currentValueList.item(i).getFirstChild().getNodeValue();
            String marketCap = marketCapList.item(i).getFirstChild().getNodeValue();
            String rating = ratingList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            cryptoCurrencies[i] = new Crypto(name, coinCode, currentValue, marketCap,
                    rating, image, url);

        }
    }
    public int getLength(){return cryptoCurrencies.length;}
    public Crypto getCrypto(int index){return cryptoCurrencies[index];}
    public String [] getNames() {
            String names[] = new String[cryptoCurrencies.length];
            for (int i = 0; i < getLength(); i++) {
                names[i] = getCrypto(i).getName();
            }
            return names;



    }


}
