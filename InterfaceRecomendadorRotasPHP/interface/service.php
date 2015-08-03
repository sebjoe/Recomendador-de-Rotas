<?php
    session_start();   
    include './JSON.php';
    $origem = str_replace(" ", "%20", $_POST["txtEnderecoPartida"]);
    $destino = str_replace(" ", "%20", $_POST["txtEnderecoChegada"]);

    if($origem == null || $destino == null){
        session_start();   
        if (isset($_SESSION['result'])) {
            setcookie(session_name(), '', time()-42000, '/');
            // Finally, destroy the session.
            session_destroy();
        }
        echo "<script>location.href='index.php?no_results=1'</script>";
    }else{
        $url = utf8_decode("http://localhost:8080/RecomendadorRotas/webresources/service/get/$origem/$destino");
        print_r($url);
//        $result =json_decode(utf8_decode(file_get_contents($url)), true);
//        $result = file_get_contents($url);
        
        
        $value = new Services_JSON(SERVICES_JSON_LOOSE_TYPE);
        $result = $value->decode(file_get_contents($url));
        
//        echo '<pre>';
//            print_r ($result);
//        echo '</pre>'; 
//        session_start();   
        $_SESSION['result'] = $result;
//        echo "<script>location.href='index.php'</script>";
    }
?>

