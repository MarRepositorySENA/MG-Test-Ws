var idSeleccionadoIda = null;
var idSeleccionadoRetorno = null;
var Asientos = "";
var TypeCabina= 1;

document.addEventListener('DOMContentLoaded', function() {
    const checkbox = document.getElementById('inlineCheckbox1');
  
   
    checkbox.addEventListener('change', function(event) {
      const isChecked = event.target.checked;
      console.log('Checkbox está ' + (isChecked ? 'marcado' : 'desmarcado'));

      if (isChecked) {

        console.log('Se ha activado la visualización de tres días antes y después.');
      } else {
        console.log('Se ha desactivado la visualización de tres días antes y después.');
      }
    });
  });
  

function almacenarID(checkbox, tipo, asientos) {
  var checkboxes = document.getElementsByClassName('registro-checkbox-' + tipo);
  Asientos = asientos;
  console.log("🚀 ~ almacenarID ~ Asientos:", Asientos)
  
  for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i] !== checkbox) {
          checkboxes[i].checked = false;
      }
  }
  if (checkbox.checked) {
      if (tipo === 'ida') {
          idSeleccionadoIda = checkbox.value;
      } else if (tipo === 'retorno') {
          idSeleccionadoRetorno = checkbox.value;
      }
  } else {
      if (tipo === 'ida') {
          idSeleccionadoIda = null;
      } else if (tipo === 'retorno') {
          idSeleccionadoRetorno = null;
      }
  }
  console.log("ID seleccionado (ida):", idSeleccionadoIda);
  console.log("ID seleccionado (retorno):", idSeleccionadoRetorno);
}



function reservar() {
    var pasajeros = document.getElementById('pasajeros').value;

if (pasajeros > Asientos) {
    alert("No hay asientos diponnibles")
} else {
    

  console.log("🚀 ~ reservar ~ IdsIda:", idSeleccionadoIda);
  console.log("🚀 ~ reservar ~ IdsRetorno:", idSeleccionadoRetorno);

  
  localStorage.removeItem("Idcabina");
  localStorage.setItem("Idcabina", TypeCabina);
  if (idSeleccionadoIda) {
      localStorage.setItem("idSeleccionadoIda", idSeleccionadoIda);
      
      
      console.log("ID de ida seleccionado:", idSeleccionadoIda);
  } else {
      localStorage.removeItem("idSeleccionadoIda");
      console.log("No se ha seleccionado ningún ID de ida");
  }

  if (idSeleccionadoRetorno) {
      localStorage.setItem("idSeleccionadoRetorno", idSeleccionadoRetorno);
      console.log("ID de retorno seleccionado:", idSeleccionadoRetorno);
  } else {
      localStorage.removeItem("idSeleccionadoRetorno");
      console.log("No se ha seleccionado ningún ID de retorno");
  }

  setTimeout(()=>{

    window.open("../../view/Operational/confirmacion.html")
  },300)
}

}

function loadSalida(tipoCabina) {
    $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Operational/Shedules/Salida",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response.data);
            var html = "";
            var data = response.data;
            console.log(data);
            data.forEach(function (item) {
                // Construir el HTML para cada objeto, incluyendo el checkbox con el ID del registro
                if (!item.deletedAt) {
                    var precioFinal = 0;
                    var precioCabina = parseFloat(item.precioCabina); // Convertir el precio de la cabina a un número

                    if (tipoCabina === "Economy") {
                        precioFinal = precioCabina;
                        
                        
                    } else if (tipoCabina === "Ejecutiva") {
                        precioFinal = Math.round(precioCabina * 1.35);
                        TypeCabina= 2 ;
                    } else if (tipoCabina === "Primera clase") {
                        TypeCabina = 3;
                        var precioEjecutivo = Math.round(precioCabina * 1.35);
                        precioFinal = Math.round(precioEjecutivo * 1.30);
                    }
                    
                    html +=
                        `<tr>
                            <td><input type="checkbox" class="registro-checkbox-ida" value="` + item.id + `" onchange="almacenarID(this, 'ida', ` + item.totalSeats + `)"></td>
                            <td>` + item.origen + `</td>
                            <td>` + item.destino + `</td>
                            <td>` + item.fecha + `</td>
                            <td>` + item.hora + `</td>
                            <td>` + item.numeroVuelo + `</td>
                            <td >$`+ precioFinal + `</td>
                        </tr>`;
                }
            });

            $("#resultSalida").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
}






function Filtro(tipoCabina) {
  var tipoDeReserva = "";
  var url = "";
  var Tabla = "";
  var fechaId = ""; // Usaremos esto para almacenar el ID del campo de fecha

  // Verificar qué tipo de reserva se seleccionó
  if (document.getElementById('inlineCheckbox1').checked) {
      tipoDeReserva = 'retorno';
  } else if (document.getElementById('inlineCheckbox2').checked) {
      tipoDeReserva = 'ida';
  }

  switch (tipoDeReserva) {
      case 'retorno':
          Tabla = "resultRegreso";
          url = "http://localhost:9000/session3/api/v1/session3/Operational/Shedules/Filtro-Retorno";
          fechaId = "fechaRegreso";
          break;
      case 'ida':
          Tabla = "resultSalida";
          url = "http://localhost:9000/session3/api/v1/session3/Operational/Shedules/Filtro-Ida";
          fechaId = "fechaSalida";
          break;
      default:
          alert("Seleccione un tipo de reserva");
          return;
  }

  var isCheckedA = document.getElementById('flexCheckCheckedA').checked;
  var isCheckedB = document.getElementById('flexCheckCheckedB').checked;


  var origen = parseInt($("#selected_origen_id").val());
  var destino =parseInt( $("#selected_destino_id").val());
  var fecha = $("#" + fechaId).val();

  var consult = {
      "origen": origen,
      "destino": destino,
      "fecha": fecha,
      "tresDias" :isCheckedA,
      "tresDiaR":isCheckedB
  };

  $.ajax({
      url: url,
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(consult),
      success: function (response) {
          if (response.data == null || response.data.length === 0) {
              alert("No se encontraron datos");
          } else {

              console.log(response.data);
              var html = "";
              var data = response.data;

              console.log(data);
              data.forEach(function (item) {
                  if (!item.deletedAt) {

                    var precioFinal = 0;
                    var precioCabina = parseFloat(item.precioCabina); 

                    if (tipoCabina === "Economy") {
                        precioFinal = precioCabina;
                    } else if (tipoCabina === "Ejecutiva") {
                        precioFinal = Math.round(precioCabina * 1.35);
                    } else if (tipoCabina === "Primera clase") {
                        var precioEjecutivo = Math.round(precioCabina * 1.35);
                        precioFinal = Math.round(precioEjecutivo * 1.30);
                    }
                    
                      html +=
                          `<tr>
                      <td><input type="checkbox" class="registro-checkbox-retorno" value="` + item.id + `" onchange="almacenarID(this, 'retorno')"></td>

                          <td>` + item.origen + `</td>
                          <td>` + item.destino + `</td>
                          <td>` + item.fecha + `</td>
                          <td>` + item.hora + `</td>
                          <td>` + item.numeroVuelo + `</td>
                        <td >$`+ precioFinal + `</td>
                      </tr>`;
                  }
              });

              $("#" + Tabla).html(html); // Usar el nombre de la tabla dinámicamente
          }
      },
      error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
      },
  });
}


function aeropuerto() {
    $.ajax({
      url: "http://localhost:9000/session3/api/v1/session3/Operational/Airports/",
      method: "GET",
      dataType: "json",
      success: function(response) {
        var data = response.data;
        var autocomplete = [];
            console.log("entrnado");
        data.forEach(function(item) {
          autocomplete.push({ label: item.name, value: item.id });
        });

        $("#origen").autocomplete({
          source: autocomplete,
          select: function(event, ui) {
            $(this).val(ui.item.label);
            $('#origenId').val(ui.item.value); // Set the hidden input with the selected value
            return false;
          }
        });

        $("#destino").autocomplete({
          source: autocomplete,
          select: function(event, ui) {
            $(this).val(ui.item.label);
            $('#destinoId').val(ui.item.value); // Set the hidden input with the selected value
            return false;
          }
        });
      },
      error: function(error) {
        console.error("Error fetching data: ", error);
      }
    });
  }



  
  function loadAere() {
    console.log("ejecutando loadPerson");
    $.ajax({
        url: "http://localhost:9000/session3/api/v1/session3/Operational/Airports/",
        method: "GET",
        dataType: "json",
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
              var origens = response.data.map(function(item) {
                return {
                  label: item.name,
                  value: item.id 
                };
              });
      
              $("#origen_id").autocomplete({
                source: function(request, response) {
                  var results = $.ui.autocomplete.filter(origens, request.term);
                  if (!results.length) {
                    results = [{ label: 'No se encontraron resultados', value: null }];
                  }
                  response(results);
                },
                select: function(event, ui) {
                  $("#selected_origen_id").val(ui.item.value);
                  $("#origen_id").val(ui.item.label);
                  return false; 
                }
              
              });
              $("#destino_id").autocomplete({
                source: function(request, response) {
                  var results = $.ui.autocomplete.filter(origens, request.term);
                  if (!results.length) {
                    results = [{ label: 'No se encontraron resultados', value: null }];
                  }
                  response(results);
                },
                select: function(event, ui) {
                  $("#selected_destino_id").val(ui.item.value);
                  $("#destino_id").val(ui.item.label);
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