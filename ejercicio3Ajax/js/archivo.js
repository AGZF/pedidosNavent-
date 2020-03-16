$(document).ready(function(){
      var nombre = $("#nombre");
      var monto = $("#monto");
      var descuento = $("#descuento");
      $("#guardar").click(function(){

          if( nombre.val().trim().length == 0 || isNaN(monto.val()) || isNaN(descuento.val())){
            alert("Ingrese bien los datos");

          }else{
            datos = {
              nombre:nombre.val(),
              monto:monto.val(),
              descuento:descuento.val()
            }
            //console.log("realizando pteciin");
            //debugger;
            $.ajax({
              type:'POST',
            	url: 'server/pedidos/guardar',
              data:datos,
            	success: function(respuesta) {
            		alert("Registro dado de alta");
                //esta info podria mostrarla en el documento como resultado
                console.log(respuesta);
            	},
            	error: function() {
                    alert("No se ha podido obtener la información");
                }
            });
          }

      });
});
