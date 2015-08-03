/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entity.Estacao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jpa.EstacaoDao;

/**
 *
 * @author marlon
 */
public class PegaCoordenadas {
    
    public static void main(String[] args) throws IOException {
        
        List<Estacao> estacoes = new ArrayList<Estacao>();
        
        estacoes.add(new Estacao("Estação tubo Agrárias", "-25.4105796", "-49.248257", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Água Verde - Av. Iguaçu", "-25.4483056", "-49.2853925", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Água Verde - Av. Pres. Getúlio Vargas", "-25.44972", "-49.2845637", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Ahú", "-25.39113", "-49.258136", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Alferes Poli / Catedral da Fé", "-25.4394368","-49.2712288", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Almirante Gonçalves", "-25.4474786","-49.2638158", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Alto Boqueirão", "-25.5248245","-49.2475247", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Antero de Quental", "-25.474783","-49.2741558", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Antônio Cavalheiros", "-25.4032761","-49.2495257", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Antônio de Paula", "-25.5125759","-49.2321429", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Antônio Lago", "-25.3888591","-49.2361428", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Antônio Meirelles Sobrinho", "-25.446973","-49.216855", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Araça", "-25.5264818","-49.2361153", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Arroio Cercado", "-25.5345361","-49.2826349", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Autódromo", "-25.4183845","-49.2721235", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Bairro Novo", "-25.5445784","-49.2657799", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Barigui", "-25.4318613","-49.3161786", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Bento Viana", "-25.4447254","-49.2851055", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Bigorrilho", "-25.4332178","-49.2999686", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Bom Jesus", "-25.409774","-49.2556532", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Brigadeiro Franco", "-25.4294511","-49.2845298", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Bruno Filgueira", "-25.4319509","-49.2964911", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Cajuru", "-25.4604325","-49.2117481", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Camilo de Lellis", "-25.4461565","-49.1888585", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Carlos Dietzsch", "-25.472613","-49.294477", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Carlos Gomes", "-25.4297216","-49.271944", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Catulo da Paixão Cearense", "-25.4650652","-49.2097995", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Cavalo Baio", "-25.5898751","-49.4006762", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Central", "-25.4299755","-49.2675032", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Centro Cívico - Assembleia", "-25.415624","-49.266386", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Centro Cívico - Palácio Iguaçu", "-25.415392","-49.26791", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Centro Comunitário", "-25.547591","-49.260234", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo China", "-25.423638","-49.202354", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo CIC Norte", "-25.449641","-49.353854", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Círculo Militar", "-25.427251","-49.2647908", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Colégio Militar", "-25.428899","-49.225105", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Comendador Fontana", "-25.4197529","-49.2691252", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Conselheiro Dantas", "-25.4514609","-49.2618974", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Constantino Marochi", "-25.4161411","-49.2614296", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Coqueiros", "-25.532568","-49.261786", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Coronel Luiz José", "-25.4952886","-49.2404457", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Del. Amazor Prestes", "-25.441818","-49.2307318", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Detran", "-25.430373","-49.211228", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Dom Ático", "-25.476524","-49.2801104", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Dom Pedro I", "-25.4569611","-49.2885135", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação Tubo Érico Veríssimo - Alto Boqueirão", "-25.5311162","-49.255629", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Erton Coelho", "-25.525441","-49.2309061", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Eucaliptos", "-25.5288411","-49.24591", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Euclides da Cunha", "-25.5300089","-49.2501654", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Fanny", "-25.474888","-49.258592", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Fernando de Noronha", "-25.3851347","-49.2328504", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação Tubo Ferrari - Loteamento São José", "-25.44271","-49.520037", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Ferrovila", "-25.466707","-49.2545159", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Gago Coutinho", "-25.3965282","-49.2433767", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Gastão Câmara", "-25.4349485","-49.3043433", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Germânia", "-25.4422222","-49.2177321", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Getúlio Vargas", "-25.4446867","-49.2653064", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Guadalupe", "-25.4336581","-49.2634645", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Henry Ford", "-25.4724248","-49.2644667", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Herculano de Araújo", "-25.4878096","-49.2943332", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Hipólito da Costa", "-25.4906983","-49.242861", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Holanda", "-25.3995533","-49.2462185", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Hospital Cajuru", "-25.437027","-49.2436667", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Hospital do Trabalhador", "-25.4844431","-49.2936896", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Hospital Militar", "-25.438171","-49.289567", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Imperial", "-25.4400423","-49.3369348", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Itajubá", "-25.4811005","-49.2925041", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Jardim Botânico", "-25.4381872","-49.2387167", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Jardim das Américas", "-25.444061","-49.2456715", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo João Viana Seiler", "-25.4544059","-49.2604758", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Joaquim Nabuco", "-25.3807328","-49.2288405", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo José C.Bettega", "-25.4994902","-49.2960677", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Lindoia", "-25.474042","-49.2699827", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Major Heitor Guimarães", "-25.437969","-49.3140905", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Marechal Floriano", "-25.4691023","-49.2540123", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Maria Clara", "-25.4194561","-49.2645112", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Mariano Torres", "-25.4356484","-49.2607765", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Mercês", "-25.422391","-49.291634", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Morretes", "-25.4676877","-49.2931387", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Mossunguê", "-25.4385963","-49.3331771", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Moisés Marcondes", "-25.4131501","-49.2586318", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Nestor de Castro", "-25.4282763","-49.2720911", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Nova Europa", "-25.4817825","-49.2510515", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Oscar Niemeyer", "-25.4107152","-49.2661312", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Osternack", "-25.553179","-49.25092", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Ouro Verde", "-25.5076945","-49.2958115", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Pádua Fleury", "-25.4769867","-49.2495585", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Paiol", "-25.448164","-49.258018", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Parolin", "-25.4630122","-49.2562452", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Parque Iguaçu", "-25.5210922","-49.2280358", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Passarela", "-25.4859237","-49.2451945", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Passeio Público", "-25.4239656","-49.2683414", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Pastor Manoel V. de Souza", "-25.4430916","-49.2142925", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Paulo Gorski", "-25.4375003","-49.3243445", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Paulo Kissula", "-25.4438","-49.2091", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Pedro Gusso", "-25.4955765","-49.2944378", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Petit Carneiro", "-25.4523182","-49.2879245", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça 19 de Dezembro", "-25.4231383","-49.2699467", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça da Bandeira", "-25.416572","-49.279273", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça da Ucrânia", "-25.4302892","-49.2926154", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça das Nações", "-25.4259652","-49.2423399", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça do Expedicionário", "-25.4293626","-49.2584493", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça Eufrásio Correia", "-25.4375995","-49.2667728", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça Osório", "-25.4328707","-49.2763132", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça Oswaldo Cruz", "-25.4411008","-49.2755702", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça Rui Barbosa - 603 -Pinheirinho", "-25.4361177","-49.2742538", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Praça Rui Barbosa Centro", "-25.4358713","-49.2749114", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Prefeitura Centro Cívico", "-25.4178362","-49.268692", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Presidente Taunay", "-25.4287595","-49.2879336", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Profª. Maria Aguiar Teixeira", "-25.4388267","-49.2263651", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo PUC", "-25.452508","-49.252833", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Quartel", "-25.5062916","-49.2351148", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Quitandinha", "-25.5358139","-49.2744729", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Rio Barigui", "-25.4392067","-49.3177168", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Roberto Hauer", "-25.4721911","-49.2517901", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Rodoferroviária", "-25.4356342","-49.2566111", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Rosa Tortato", "-25.5308536","-49.2877673", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Sagrado Coração", "-25.5279117","-49.2913467", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Salgado Filho", "-25.471734","-49.237478", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Santa Bernadethe", "-25.485174","-49.266884", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Santa Quitéria", "-25.459128","-49.302436", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Santa Regina", "-25.5034762","-49.2959215", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo São Grato", "-25.4364817","-49.3284751", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo São Pedro", "-25.506752","-49.28432", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Sebastião Paraná - Água Verde", "-25.4612512","-49.2897929", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Sete de Setembro", "-25.4392345","-49.269587", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Silva Jardim", "-25.4483269","-49.2877797", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Teffé", "-25.414542","-49.279605", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Teofilo Otoni", "-25.4572975","-49.2129323", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo TRE", "-25.4591762","-49.2582462", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação Tubo U.S. Campo Comprido", "-25.4409688","-49.3425098", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Urbano Lopes", "-25.4407535","-49.2365937", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo UTFPR", "-25.4388815","-49.2681717", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Viaduto Capanema", "-25.4356354","-49.2505747", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Vila Accordes", "-25.524879","-49.268818", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Vila Guaira", "-25.4718603","-49.2856972", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Vila Nova", "-25.4431859","-49.203502", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Vila São Pedro", "-25.51284","-49.279851", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Visconde de Nacar", "-25.4313514","-49.2788677", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Vital Brasil", "-25.4646305","-49.2913148", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Wenceslau Braz", "-25.4774514","-49.2849722", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Westphalen", "-25.4434956","-49.2681985", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Winston Churchill", "-25.5207218","-49.2955604", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Xapinhal", "-25.535803","-49.2847739", geraNivelAcessbilidade()));
        estacoes.add(new Estacao("Estação tubo Xaxim Capão Raso", "-25.496481","-49.2733105", geraNivelAcessbilidade()));
        
        EstacaoDao dao = new EstacaoDao();
        for(Estacao estacao : estacoes){
            dao.saveOrUpdate(estacao);
        }
    }
    
    private static int geraNivelAcessbilidade(){
        return (int) (Math.random() * 4);
    }
}
