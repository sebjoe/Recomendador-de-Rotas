<?php session_start(); ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recomendador de Rotas para Deficientes Visuais</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="css/responsive_table.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script> 
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;libraries=places"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" src="js/mapa.js"></script>
        <script type="text/javascript" src="js/auto_complete.js"></script>
        <script type="text/javascript" src="js/accordion.js"></script>
        <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                //Preloader
                $("#carregando").hide();
                $("#form").submit(function() {
                    $("#carregando").ajaxStart(function(){
                        $("#resultados").hide();
                        $(this).show();
                    });
                    $.ajax({
                        type: "POST",
                        url: "service.php",
                        data: 'txtEnderecoPartida='+ $('#txtEnderecoPartida').val() +'&txtEnderecoChegada='+ $('#txtEnderecoChegada').val(),
                        complete: hide
                    });
                    return false;
                });

                // validate signup form on keyup and submit
                $("#form").validate({
                    errorLabelContainer: $('#div_mensagens'),
                        rules: {
                                txtEnderecoPartida: "required",
                                txtEnderecoChegada: "required"
                        },
                        messages: {
                                txtEnderecoPartida: "O Campo Endereço de Partida é Obrigatório!",
                                txtEnderecoChegada: "O Campo Endereço de Chegada é Obrigatório!"
                        }
                });
            });

            //pre loader
            function hide(){
                $("#carregando").hide();
                $("#resultados").show();
                $("#resultados").load("index.php #resultados");
            }
            
            function table_sorter(opcao){
                if(opcao == 7){
                    $("#tabela").tablesorter( {sortList: [[opcao,1]]} ); 
                }else{
                    $("#tabela").tablesorter( {sortList: [[opcao,0]]} ); 
                }
            }
        </script>
    </head>

    <body>
        <div id="page-wrap">
            <h1>Recomendador de Rotas para Deficientes Visuais</h1>
            <h4>Antes de recomendar sua rota, por favor leia as instruções <a href="about.html">aqui.</a></h4>

            <form id="form" action="#" title="Recomendar Rota">
                <fieldset>
                    <legend>Recomendar Rota</legend>
                    <button type="button" name="btnLocalAtual" id="btnLocalAtual" onclick="getLocalAtual();" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-screenshot"></span> Meu Local Atual
                    </button>
                    
                    <br>
                    <div id="div_mensagens" ></div>
                    <br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon">End. Partida</span>
                        <input type="text" id="txtEnderecoPartida" title="Endereço de Partida" name="txtEnderecoPartida" class="form-control">
                    </div>
                    <br>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon">End. Chegada</span>
                        <input type="text" id="txtEnderecoChegada" title="Endereço de Chegada" name="txtEnderecoChegada" class="form-control">
                    </div>
                    <br>
                    <div>
                        <input type="submit" id="btnEnviar" name="btnEnviar" value="Enviar" class="btn btn-lg btn-primary btn-block">
                    </div>
                </fieldset>
            </form>
            <div id="carregando">
                <br>
                <br>
                <p>Por favor, aguarde o processamento ...</p>
            </div>
            <!--<div id="mapa"></div>-->
            <div id="resultados">
                <?php
                    if (isset($_SESSION['result'])){
                        echo"<h1>Recomendação de Rotas</h1>";
                        $result = $_SESSION['result'];
                        echo"<label for='ordenar'>Ordenar Por: </label><br/>";
                        echo"<select id='selectOrder' name='ordenar' onchange='table_sorter(this.value)'>";
                            echo"<option value='7'>Maior Média Acessibilidade</option>";
                            echo"<option value='1'>Parada de Ônibus mais próxima da Partida</option>";
                            echo"<option value='4'>Parada de Ônibus mais próxima da Chegada</option>";
                        echo"</select>"; 
                        echo"<table id='tabela'>";
                            echo"<caption>Resultado da Recomendação de Rotas</caption>";
                            echo"<thead>";
                            echo"<tr>";
                                echo"<th scope='col'>Estação Tubo Origem</th>";
                                echo"<th scope='col'>Distância (Km)</th>";
                                echo"<th scope='col'>Nível Acessibilidade</th>";
                                echo"<th scope='col'>Estação Tubo Destino</th>";
                                echo"<th scope='col'>Distância (Km)</th>";
                                echo"<th scope='col'>Nível Acessibilidade</th>";
                                echo"<th scope='col'>Tempo</th>";
                                echo"<th scope='col'>Média Nível Acessibilidade</th>";
                                echo"<th scope='col'>Detalhes</th>";
                            echo"</tr>";
                            echo"</thead>";
                            echo"<tbody>";

                            for ($i = 0; $i < count($result['rotas']); $i++) {
                                echo"<tr>";
                                    echo"<td>" . $result['rotas'][$i]['estacaoTuboOrigem']['nome'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['estacaoTuboOrigem']['distancia'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['estacaoTuboOrigem']['nivelAcessibilidade'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['estacaoTuboDestino']['nome'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['estacaoTuboDestino']['distancia'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['estacaoTuboDestino']['nivelAcessibilidade'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['tempoViagem'] . "</td>";
                                    echo"<td>" . $result['rotas'][$i]['mediaNivelAcessRota'] . "</td>";
                                    echo"<td>" . "<a class='accordion-toggle' data-toggle='collapse' data-parent='#accordion' href='#collapse$i'>Clique Aqui Para Mais Detalhes</a>"; //. "</td>";
//                                echo"</tr>";
//                                echo"<tr>";
//                                    echo"<td colspan=8 id='collapse$i' class='panel-collapse collapse'>";
                                       echo"<span colspan=8 id='collapse$i' class='panel-collapse collapse'>";
                                        echo"<ul>";
                                            for ($j=0; $j < count($result['rotas'][$i]['travel_detail']); $j++) {
                                                echo "<li> " . $result['rotas'][$i]['travel_detail'][$j]['html_instruction'] . "</li>";
                                                if (isset($result['rotas'][$i]['travel_detail'][$j]['departure_stop']) && $result['rotas'][$i]['travel_detail'][$j]['departure_stop']['nome'] != "Sem Informação"){
                                                    echo "<li> " . $result['rotas'][$i]['travel_detail'][$j]['departure_stop']['nome'] . " Nível de Acessibilidade: " . $result['rotas'][$i]['travel_detail'][$j]['departure_stop']['nivelAcessibilidade'] . "</li>";
                                                    echo "<li> " . $result['rotas'][$i]['travel_detail'][$j]['arrival_stop']['nome'] . " Nível de Acessibilidade: " . $result['rotas'][$i]['travel_detail'][$j]['arrival_stop']['nivelAcessibilidade'] . "</li>";
                                                }
                                            }
                                        echo"</ul>";
                                        echo"</span>";
                                    echo"</td>";
                                echo"</tr>";
                            }
                            echo"</tbody>";
                        echo"</table>";
                    }
                ?>
            </div>
            <div id="certificacao"> 
                <p>
                    <a href="http://validator.w3.org/check?uri=referer">
                        <img src="http://www.w3.org/Icons/valid-html401" alt="Valid HTML 4.01 Strict" height="31" width="88">
                    </a>
                    <a href="http://achecker.ca/checker/index.php?uri=referer&amp;gid=WCAG2-AAA">
                        <img src="http://achecker.ca/images/icon_W2_aaa.jpg" alt="WCAG 2.0 (Level AAA)" height="32" width="102">
                    </a>
                </p>
            </div>
        </div>
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
    
</html>





