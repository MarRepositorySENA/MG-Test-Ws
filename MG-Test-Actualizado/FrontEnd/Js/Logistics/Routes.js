function loadTable() {
    $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Sales/CabinTypes/",
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(
        function (item) {
            variable = ""
            item.forEach(function (Elementos, Posicion, Array) {
                variable += `<tr>
                <td> ` + parseInt(Posicion + 1) + `</td>
                <td> `+ Elementos.departureAirportId.name + `</td>
                <td> `+ Elementos.arrivalAirportId.name + `</td>
                <td> `+ Elementos.distance + `</td>
                <td>` + Elementos.flight_time + `</td>
                <td>
                    <button type="button" class="btn btn-warning" onclick="findById(${Elementos.id})"><i class='bx bx-search'></i></button>
                    <button type="button" class="btn btn-danger" onclick="deleteRoutes(${Elementos.id})"><i class='bx bx-trash'></i></button>
                </td>
                </tr>`;
            })
            $("dataResult").html(variable);
        }
    )
}
//metodo guardar
function saveRoutes() {
    var datos = {

        departureAirportId: $("#departureAirportId").val(),
        arrivalAirportId: $("#arrivalAirportId").val(),
        distance: $("#distance").val(),
        flight_time: $("#flight_time").val()
    }
    $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Logistics/Routes/",
        method: "POST",
        data: JSON.stringify(datos),
        headers: {
            contentType: "application/json",
        }
    }).done(
        function (item) {
            loadTable();
            clearData();
        }
    )
}
//buscar por Id
// function findById(id) {
//     $.ajax({
//         url:
//     })
// }





//limpiar datos
function clearData() {
    $("#id").val("");
    $("#departureAirportId").val("");
    $("#arrivalAirportId").val("");
    $("#distance").val("");
    $("#flight_time").val("");
}

