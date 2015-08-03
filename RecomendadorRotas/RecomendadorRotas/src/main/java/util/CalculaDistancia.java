package util;

import com.google.gson.Gson;
import entity.Estacao;
import entity.GsonDistanceMatrix;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.EstacaoDao;

/**
 *
 * @author marlon
 */
public class CalculaDistancia {

    //Cenario 1 - Uusario digita onde ele está (ou pega automatico com gps do browser)
    //Depois digita na onde ele quer ir
    //Este metodo irá retornar uma lista de estações tubos mais próximas dele e mostrar em uma lista o nível de acessibilidade dessas estações
    public List<Estacao> getEstacoesProximas(String ponto, int raio) throws IOException {
        String pontoFormatado = pontoFormatado(ponto);
        EstacaoDao dao = new EstacaoDao();
        List<Estacao> estacoesCadastradas = dao.findAll();
        List<Estacao> estacoesProximas = new ArrayList<Estacao>();
        for (Estacao estacao : estacoesCadastradas) {
            if (isPontoProximo(pontoFormatado, estacao.getLatitude() + "," + estacao.getLongitude(), raio)) {
                estacoesProximas.add(estacao);
            }
        }
        return estacoesProximas;
    }

    private boolean isPontoProximo(String pontoOrigem, String pontoDestino, int raio) throws IOException {
        InputStream is = null;
        try {
            is = new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins=" + pontoOrigem + "&destinations=" + pontoDestino + "&mode=driving&language=pt-BR&sensor=false").openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            if (isProximo(jsonText, raio)) {
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(CalculaDistancia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            is.close();
        }
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private boolean isProximo(String jsonString, int raio) {
        Gson gson = new Gson();
        GsonDistanceMatrix distancia = gson.fromJson(jsonString, GsonDistanceMatrix.class);

        if (distancia.getValueDistance(0, 0) <= raio) {
            System.out.println(distancia.getValueDistance(0, 0));
            System.out.println(distancia.getTextDistance(0, 0));
            System.out.println(distancia.getValueDuration(0, 0));
            System.out.println(distancia.getTextDuration(0, 0));
            System.out.println(distancia.getStatus(0, 0));
            System.out.println(distancia.getStatus());
            System.out.println(distancia.getDestinationAddresses(0));
            System.out.println(distancia.getOriginAddresses(0));
            return true;
        } else {
            return false;
        }
    }

    private String pontoFormatado(String ponto) {
        String pontoFormtado = ponto;
        pontoFormtado = pontoFormtado.replaceAll("[ÂÀÁÄÃ]", "A");
        pontoFormtado = pontoFormtado.replaceAll("[âãàáä]", "a");
        pontoFormtado = pontoFormtado.replaceAll("[ÊÈÉË]", "E");
        pontoFormtado = pontoFormtado.replaceAll("[êèéë]", "e");
        pontoFormtado = pontoFormtado.replaceAll("ÎÍÌÏ", "I");
        pontoFormtado = pontoFormtado.replaceAll("îíìï", "i");
        pontoFormtado = pontoFormtado.replaceAll("[ÔÕÒÓÖ]", "O");
        pontoFormtado = pontoFormtado.replaceAll("[ôõòóö]", "o");
        pontoFormtado = pontoFormtado.replaceAll("[ÛÙÚÜ]", "U");
        pontoFormtado = pontoFormtado.replaceAll("[ûúùü]", "u");
        pontoFormtado = pontoFormtado.replaceAll("Ç", "C");
        pontoFormtado = pontoFormtado.replaceAll("ç", "c");
        pontoFormtado = pontoFormtado.replaceAll("[ýÿ]", "y");
        pontoFormtado = pontoFormtado.replaceAll("Ý", "Y");
        pontoFormtado = pontoFormtado.replaceAll("ñ", "n");
        pontoFormtado = pontoFormtado.replaceAll("Ñ", "N");
        pontoFormtado = pontoFormtado.replaceAll(" ", "%20");

        return pontoFormtado;
    }
}
