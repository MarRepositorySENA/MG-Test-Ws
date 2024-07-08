
function loadReserva(){
    var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
    var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
    cabinaType = localStorage.getItem("Idcabina");
    

    if (idSeleccionadoIda !=null) {
        loadSalida();
    } 
    if(idSeleccionadoRetorno !=null){
        loadRegreso()
        
    }

}
var precioFinal = 0;
var cabinaType = parseInt(localStorage.getItem("Idcabina")); 
var TypeCabina = 1; 
var ID = 0;

function almacenarID(checkbox) {
  var checkboxes = document.getElementsByClassName('registro-checkbox');
  console.log("mensajito",document.getElementsByClassName);
  
  
  // Deseleccionar todos los checkboxes excepto el actual
  for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i] !== checkbox) {
          checkboxes[i].checked = false;
      }
  }
  ID = checkbox.value
  console.log("🚀 ~ almacenarID ~ ID:", ID)
 
  
}



function loadSalida() {
    var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
    $.ajax({
        url: "http://localhost:9000/Airlines/v1/api/Schedules/detalles/" + idSeleccionadoIda,
        method: "GET",
        dataType: "json",
        success: function (response) {
            // Imprime la respuesta completa para ver su estructura
            console.log(response);

            // Acceder directamente al objeto de datos
            var item = response.data;

            var html = "";

            // Construir el HTML para el objeto recibido
            if (!item.deletedAt) {
                html += `
                    <span> origen: ${item.origen}</span>
                    <span> destino: ${item.destino}</span>
                    <span> TipoCabina: Economica</span>
                    <span> Fecha: ${item.fecha}</span>
                    <span> Numero vuelo: ${item.numeroVuelo}</span>
                `;
            }
            var precioCabina = parseFloat(item.precioCabina); // Convertir el precio de la cabina a un número
            console.log("🚀 ~ loadRegreso ~ precioCabina:", precioCabina)

          if (cabinaType == 1) {
              precioFinal = precioCabina;
              TypeCabina = 1;
          } else if (cabinaType == 2) {
              precioFinal = Math.round(precioCabina * 1.35);
              TypeCabina = 2;
          } else if (cabinaType == 3) {
              var precioEjecutivo = Math.round(precioCabina * 1.35);
              precioFinal = Math.round(precioEjecutivo * 1.30);
              TypeCabina = 3;
          }


            $("#resultSalida").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
}



function loadRegreso() {
  var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
  $.ajax({
      url: "http://localhost:9000/session3/api/v1/session3/Operational/Shedules/Filtro-Retorno" + idSeleccionadoRetorno,
      method: "GET",
      dataType: "json",
      success: function (response) {
          // Imprime la respuesta completa para ver su estructura
          console.log(response);

          // Acceder directamente al objeto de datos
          var item = response.data;

          var html = "";

          // Construir el HTML para el objeto recibido
          if (!item.deletedAt) {
              html += `
                  <span>Origen: ${item.origen}</span>
                  <span>Destino: ${item.destino}</span>
                  <span>Tipo Cabina: Económica</span>
                  <span>Fecha: ${item.fecha}</span>
                  <span>Número vuelo: ${item.numeroVuelo}</span>
              `;
          }

          var precioCabina = parseFloat(item.precioCabina); // Convertir el precio de la cabina a un número
          console.log("🚀 ~ loadRegreso ~ precioCabina:", precioCabina)

          if (cabinaType === 1) {
              precioFinal = precioCabina;
              TypeCabina = 1;
          } else if (cabinaType === 2) {
              precioFinal = Math.round(precioCabina * 1.35);
              TypeCabina = 2;
          } else if (cabinaType === 3) {
              var precioEjecutivo = Math.round(precioCabina * 1.35);
              precioFinal = Math.round(precioEjecutivo * 1.30);
              TypeCabina = 3;
          }

          $("#resultRegreso").html(html);
      },
      error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
      },
  });
}

function Confirmacion() {
  var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
    var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
   
    if (idSeleccionadoIda !=null) {
        loadSalida();
        
    } 
    if(idSeleccionadoRetorno !=null){
      loadRegreso();
      
        
    }
  
  setTimeout(function() {
    var precioFinalElement = document.getElementById('precio-final');
    console.log("🚀 ~ Confirmacion ~ precioFinal:", precioFinal)
      precioFinalElement.innerHTML = 'Valor: ' + precioFinal;

  }, 1000); // Añadir un retraso para asegurar que loadRegreso termine
}

function modificar(){
  update(ID)
}

function update(id) {
  id
  console.log(id);
  $.ajax({
    url: "http://localhost:9000/session3/api/v1/session3/Sales/Tickets/" + id,
    method: "GET",
    dataType: "json",
    success: function (response) {
      console.log(response);

      var item = response.data;

      var email = item.email;
      var bookingReference = item.bookingReference;
      var passportCountryID = item.passportCountryID.id;
      var phone = item.phone;
      var confirmed = true;
      var cabinTypesID = item.cabinTypesID.id;
      var usersID = item.usersID.id;
      var lastName = item.lastName;
      var firstName = item.firstName;
      var scheduleID = item.scheduleID.id;
      var passportNumber = item.passportNumber;
      var passportPhoto = "../../phono"; // Make sure this path is correct
      var birthday = item.birthday;
      var ID = item.id;

      var data = {
        id:ID,
        lastName: lastName,
        firstName: firstName,
        cabinTypesID: {
          id: cabinTypesID
        },
        scheduleID: {
          id: scheduleID
        },
        usersID: {
          id: usersID
        },
        email: email,
        passportCountryID: {
          id: passportCountryID
        },
        bookingReference: bookingReference,
        passportPhoto: passportPhoto,
        passportNumber: passportNumber,
        confirmed: confirmed,
        phone: phone,
        birthday: birthday
      };

      var jsonData = JSON.stringify(data);

      $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Sales/Tickets/" + ID,
        method: "PUT",
        dataType: "json",
        contentType: "application/json",
        data: jsonData,
        success: function (data) {
          alert("Registro se modificó con éxito");
          loadData();
        },
        error: function (error) {
          alert("Error: no se pudo realizar el registro.");
          console.error("Error en la solicitud:", error);
        }
      });

    },
    error: function (error) {
      console.error("Error en la solicitud:", error);
    }
  });
}
  


var rutaIm = "";

function uploadFile() {
    return new Promise((resolve, reject) => {
        const fileInput = document.getElementById('formFile');
        const file = fileInput.files[0];
        const formData = new FormData();
        formData.append('file', file);

        const xhr = new XMLHttpRequest();
        xhr.open('POST', 'http://localhost:9000/Airlines/v1/api/Tickets/upload', true);
        xhr.onload = function () {
            if (xhr.status === 200) {
                try {
                    //const response = JSON.parse(xhr.responseText);
                    const filePath = response.filePath;
                    rutaIm = filePath;
                    console.log("🚀 ~ uploadFile ~ filePath:", filePath);
                    resolve(response); // Resuelve la promesa con la respuesta del servidor
                } catch (error) {
                    reject('Error al procesar la respuesta del servidor');
                }
            } else {
                reject('Error al subir el archivo');
            }
        };
        xhr.send(formData);
    });
}


function saveIDa(idSeleccionadoIda,cabinaType) {
    uploadFile();
    if (rutaIm ==null) {
        alert("pail")
    }
    var selectedCountriesId = parseInt($("#selected_Countries_id").val());
    if (isNaN(selectedCountriesId) || selectedCountriesId === null) {
      console.error("ID de ciudad no válido");
      return;
    }
   try {
      
      var data = {
        "lastName": $("#lastName").val(),
        "firstName": $("#firstName").val(),
        "cabinTypesID": {
            "id":cabinaType
        },
        "scheduleID":{
            "id":idSeleccionadoIda
        },
        "usersID":{
        "id":1
        },

        "email": $("#email").val(),

        "passportCountryID":{
            "id":selectedCountriesId
        },

        "bookingReference": "hsdeff",
        "passportPhoto": "././",
        "passportNumber": $("#passportNumber").val(),
        "confirmed": false,
        "phone": $("#phone").val(),
        "birthday": $("#birthday").val(),
        "Confirmed": false
      };
  
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Sales/Tickets/",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsonData,
        success: function(data) {
          alert("Registro agregado con éxito");
         
          loadData();
          
        },
        error: function(error) {
          alert(`Error no se pudo realizar el registro.`);
          //console.log($("#person_id").val());
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }

  


function saveRetorno(idSeleccionadoRetorno,cabinaType) {
    
    var selectedCountriesId = parseInt($("#selected_Countries_id").val());
    if (isNaN(selectedCountriesId) || selectedCountriesId === null) {
      console.error("ID no valid");
      return;
    }
   try {
      
      var data = {
        "lastName": $("#lastName").val(),
        "firstName": $("#firstName").val(),
        "cabinTypesID": {
            "id":cabinaType
        },
        "scheduleID":{
            "id":idSeleccionadoRetorno
        },
        "usersID":{
        "id":1
        },

        "email": $("#email").val(),

        "passportCountryID":{
            "id":selectedCountriesId
        },
        "bookingReference": "hsdeff",
        "passportPhoto": "././",
        "passportNumber": $("#passportNumber").val(),
        "confirmed": false,
        "phone": $("#phone").val(),
        "birthday": $("#birthday").val(),
        "Confirmed": false
      };
  
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Sales/Tickets/",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsonData,
        success: function(data) {
          alert("Registro agregado con éxito");
         
          loadData();
          uploadFile();
       
        },
        error: function(error) {
          alert(`Error no se pudo realizar el registro.`);
          //console.log($("#person_id").val());
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }



function guardar() {
    var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
    var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
    var cabinaType = localStorage.getItem("Idcabina");

    if (idSeleccionadoIda !=null) {
        saveIDa(idSeleccionadoIda,cabinaType);
    } 
    if(idSeleccionadoRetorno !=null){
        saveRetorno(idSeleccionadoRetorno,cabinaType)
        
    }
    
}
  

  

  function loadCountries() {

    $.ajax({
      url: "http://localhost:9000/session3/api/v1/session3/Parameter/Countries/",
      method: "GET",
      dataType: "json",
      success: function (response) {
        if (response.status && Array.isArray(response.data)) {
          var cities = response.data.map(function (Countries) {
            return {
              label: Countries.name,
              value: Countries.id ,
            };
          });
  
          
          $("#Countries_id").autocomplete({
            source: cities,
            select: function (event, ui) {
              $("#selected_Countries_id").val(ui.item.value);
              $("#Countries_id").val(ui.item.label);
              console.log("ID de ciudad seleccionada: " + ui.item.value);
              return false; 
            }
          });
        } else {
          console.error("Error: No se pudo obtener la lista de ciudades.");
        }
      },
      error: function (error) {
        console.error("Error en la solicitud:", error);
      },
    });
  }


  function loadData() {
    $.ajax({
      url: "http://localhost:9000/session3/api/v1/session3/Sales/Tickets/",
      method: "GET",
      dataType: "json",
      success: function (response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          if (!item.deletedAt) {
            html += `
              <tr>
                <td><input type="checkbox" class="registro-checkbox" value="` + item.id + `" onchange="almacenarID(this)"></td>
                <td>${item.lastName}</td>
                <td>${item.firstName}</td>
                <td>${item.birthday}</td>
                <td>${item.passportNumber}</td>
                <td>${item.passportCountryID.name}</td>
                <td>${item.phone}</td>
                <td>
                  <button type="button" class="btn btn-secondary" onclick="delet(${item.id})">
                    <img src="/assets/icon/trash3.svg" alt="Delete">
                  </button>
                </td>
              </tr>`;
          }
        });
  
        $("#resultData").html(html);
      },
      error: function (error) {
        // Función que se ejecuta si hay un error en la solicitud
        console.error("Error en la solicitud:", error);
      },
    });
  }
  

  function delet(id){
    $.ajax({
      url: "http://localhost:9000/session3/api/v1/session3/Sales/Tickets/" + id,
      method: "delete",
      headers: {
        "Content-Type": "application/json",
      },
    }).done(function (result) {
      alert("Registro eliminado con éxito");
      loadData();
    });
  }