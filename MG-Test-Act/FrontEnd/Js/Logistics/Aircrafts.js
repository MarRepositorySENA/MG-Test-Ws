function loadTable() {
    $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Logistics/Aircrafts/",
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(
        function (item) {
            variable = ""
            item.forEach(function (Elementos, posicion, array) {
                variable += `<tr>
                <td>` + parseInt(posicion + 1) + `</td>
                <td>`+ Elementos.name + `</td>
                <td>`+ Elementos.makeModel + `</td>
                <td>`+ Elementos.totalSeats + `</td>
                <td>`+ Elementos.economySeats + `</td>
                <td>`+ Elementos.businessSeats + `</td>
                <td>
                    <button type="button" class="btn btn-warning" onclick="findById(${Elementos.id})"><i class='bx bx-search'></i></button>
                    <button type="button" class="btn btn-danger" onclick="deleteAircrafts(${Elementos.id})"><i class='bx bx-trash'></i></button>
                </td>
                </tr>`

            });

            $("#dataResult").html(variable)
        }
    )
}

function select(id){
    $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Logistics/Aircrafts/",
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(
        function (item) {
            variable = ""
            item.forEach(function (Elementos, posicion, array) {
                variable += `<option value="${Elementos.id}">${Elementos.name}</option>`

            });

            $("#seleccionar").html(variable)
        }
    )
}

//metodo guardar

function saveAircrafts(){
    var datos={
        name:$("#name").val(),
        makeModel:$("#makeModel").val(),
        totalSeats:$("#totalSeats").val(),
        economySeats:$("#economySeats").val(),
        businessSeats:$("#businessSeats").val()    
    }
    $.ajax({
        url:"http://localhost:9000/session3/api/v1/session3/Logistics/Aircrafts/",
        data: JSON.stringify(datos),
        method:"POST",
        headers:{
            "Content-Type": "application/json"
        }
    }).done(
        function (item){
            loadTable();
            clearData()
        }
    )
}


//buscar por Id
function findById(id){
    $.ajax({
        url:"http://localhost:9000/session3/api/v1/session3/Logistics/Aircrafts/"+id,
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(
        function(item){
                $("#id").val(item.id),
                $("#name").val(item.name),
                $("#makeModel").val(item.makeModel),
                $("#totalSeats").val(item.totalSeats),
                $("#economySeats").val(item.economySeats),
                $("#businessSeats").val(item.businessSeats)
        }
    )
}

//Actualizar o modificar

function updateAircrafts(){
    id=$("#id").val()
    var datos={
        name:$("#name").val(),
        makeModel:$("#makeModel").val(),
        totalSeats:$("#totalSeats").val(),
        economySeats:$("#economySeats").val(),
        businessSeats:$("#businessSeats").val()    
    }
    $.ajax({
        url:"http://localhost:9000/session3/api/v1/session3/Logistics/Aircrafts/"+id,
        data: JSON.stringify(datos),
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(
        function (item){
            loadTable();
            clearData();

        }
    )

}
//Eliminar
function deleteAircrafts(id){
    $.ajax({
        url:"http://localhost:9000/session3/api/v1/session3/Logistics/Aircrafts/"+id,
        method:"DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(
        function(item){
            loadTable()
        }
    )
}


//limpiar datos
function clearData(){
    $("#id").val(""),
    $("#name").val(""),
    $("#makeModel").val(""),
    $("#totalSeats").val(""),
    $("#economySeats").val(""),
    $("#businessSeats").val("")
}