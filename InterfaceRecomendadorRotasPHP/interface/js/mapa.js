var map;
var directionsDisplay;
var geocoder;
var directionsService = new google.maps.DirectionsService();

function initialize() {	
	directionsDisplay = new google.maps.DirectionsRenderer();
	var latlng = new google.maps.LatLng(-18.8800397, -47.05878999999999);
	
    var options = {
        zoom: 5,
		center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

//    map = new google.maps.Map(document.getElementById("mapa"), options);
    geocoder = new google.maps.Geocoder();//Inicializa o Geocoder para usar o autoComplete
//	directionsDisplay.setMap(map);
//	directionsDisplay.setPanel(document.getElementById("trajeto-texto"));
}

$(document).ready(function () {
    initialize();
});

function getLocalAtual(){
    if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function (position) {

			pontoPadrao = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
			map.setCenter(pontoPadrao);
			
			var geocoder = new google.maps.Geocoder();
			
			geocoder.geocode({
				"location": new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
            },
            function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					$("#txtEnderecoPartida").val(results[0].formatted_address);
				}
            });
		});
	}else {
            alert("Seu navegador não tem suporte a localização");
        }
}
