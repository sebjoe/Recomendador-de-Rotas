function iniciar(){
    var defaultBounds = new google.maps.LatLngBounds(
        new google.maps.LatLng(-18.8800397, -47.05878999999999)
    );

    var origin_input = document.getElementById('txtEnderecoPartida');
    var destination_input = document.getElementById('txtEnderecoChegada');

    var options = {
            bounds: defaultBounds,
            componentRestrictions: {country: 'br'}
    };

    var autocomplete_origin = new google.maps.places.Autocomplete(origin_input, options);    
    var autocomplete_destination = new google.maps.places.Autocomplete(destination_input, options);
}
google.maps.event.addDomListener(window, 'load', iniciar);