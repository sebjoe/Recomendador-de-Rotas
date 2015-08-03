/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Coordenadas {

    private String latitude;
    private String longitude;
    
    
    public void setNomeEstacao(String c) throws MalformedURLException, IOException {
        latitude = "Não encontrado";
        longitude = "Não encontrado";
        try {
//            List<String> coord = new ArrayList<String>();

            String adresa = c;
            adresa = adresa.replaceAll(" ", "%20");
            
            //Obtem o xml utilizando a api do google maps
            URL u = new URL("http://maps.googleapis.com/maps/api/geocode/xml?address=" + adresa + "&components=country:BR|administrative_area:Curitiba&sensor=true");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(u.openStream());
            Element raiz = doc.getDocumentElement();
            NodeList listaContatos = raiz.getElementsByTagName("location");//Procura pela tag onde se encontram as coordenadas
            //Se a URL n�o retornar nenhuma informa��o, as coordenadas n�o s�o encontradas
            if (listaContatos.getLength() == 0) {
                latitude = "Não encontrado";
                longitude = "Não encontrado";
            } else {
                //Quando a URL retorna as informa��es solicitadas, esse la�o procura pelas tags no xml que guardam o valor das coordenadas
                for (int i = 0; i < listaContatos.getLength(); i++) {
                    Element contato = (Element) listaContatos.item(i);
                    NodeList listalat = contato.getElementsByTagName("lat");
                    NodeList listalng = contato.getElementsByTagName("lng");
                    latitude = listalat.item(0).getFirstChild().getNodeValue();
                    longitude = listalng.item(0).getFirstChild().getNodeValue();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Coordenadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getLatitude(){
        return latitude;
    }
    
    public String getLongitude(){
        return longitude;
    }
    
    public String getLatLong(String ponto){
         try {
//            List<String> coord = new ArrayList<String>();

           String adress = ponto;
            //Retira todos os caracteres especiais encontrados no nome da esta��o de �nibus
//          adress = adress.replaceAll("[ÂÀÁÄÃ]", "A");
//            adress = adress.replaceAll("[âãàáä]", "a");
//            adress = adress.replaceAll("[ÊÈÉË]", "E");
//            adress = adress.replaceAll("[êèéë]", "e");
//            adress = adress.replaceAll("ÎÍÌÏ", "I");
//            adress = adress.replaceAll("îíìï", "i");
//            adress = adress.replaceAll("[ÔÕÒÓÖ]", "O");
//            adress = adress.replaceAll("[ôõòóö]", "o");
//            adress = adress.replaceAll("[ÛÙÚÜ]", "U");
//            adress = adress.replaceAll("[ûúùü]", "u");
//            adress = adress.replaceAll("Ç", "C");
//            adress = adress.replaceAll("ç", "c");
//            adress = adress.replaceAll("[ýÿ]", "y");
//            adress = adress.replaceAll("Ý", "Y");
//            adress = adress.replaceAll("ñ", "n");
//            adress = adress.replaceAll("Ñ", "N");
            adress = adress.replaceAll(" ", "%20");
            //Obtem o xml utilizando a api do google maps
            URL u = new URL("http://maps.googleapis.com/maps/api/geocode/xml?address=" + adress + "&components=country:BR|administrative_area:Curitiba&sensor=true");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(u.openStream());
            Element raiz = doc.getDocumentElement();
            NodeList listaContatos = raiz.getElementsByTagName("location");//Procura pela tag onde se encontram as coordenadas
            //Se a URL n�o retornar nenhuma informa��o, as coordenadas n�o s�o encontradas
            if (listaContatos.getLength() == 0) {
                latitude = "Não encontrado";
                longitude = "Não encontrado";
                return latitude+","+longitude;
            } else {
                //Quando a URL retorna as informa��es solicitadas, esse la�o procura pelas tags no xml que guardam o valor das coordenadas
                for (int i = 0; i < listaContatos.getLength(); i++) {
                    Element contato = (Element) listaContatos.item(i);
                    NodeList listalat = contato.getElementsByTagName("lat");
                    NodeList listalng = contato.getElementsByTagName("lng");
                    latitude = listalat.item(0).getFirstChild().getNodeValue();
                    longitude = listalng.item(0).getFirstChild().getNodeValue();
                }
                return latitude+","+longitude;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Coordenadas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
